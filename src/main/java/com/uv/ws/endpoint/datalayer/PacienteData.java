package com.uv.ws.endpoint.datalayer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.uv.model.*;
import com.uv.ws.endpoint.utils.DocXmlToJson;
import com.uv.ws.endpoint.utils.HibernateUtility;
import com.uv.ws.validator.DocumentoValidator;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacienteData {


    public void save(com.uv.types.rnc.Documento docu){
        Transaction tx1 = null;
        Session session = null;

        try {
            SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
            session = sessionFactory.openSession();
            Paciente paciente = new Paciente(docu);
            Diagnostico diag = new Diagnostico(docu);
            Medico medico = (new Medico(docu));
            List<Tratamiento> tratamientos = new ArrayList();
            for (com.uv.types.rnc.Tratamiento t : docu.getBodyDoc().getResolucionTratamientoDoc().getTratamientos().getTratamiento()) {
                tratamientos.add(new Tratamiento(docu, t));
            }

            tx1 = session.beginTransaction();
            Criteria criteria = session.createCriteria(Paciente.class);
            criteria.add(Restrictions.eq("rut", paciente.getRut()));
            //TODO ARREGLAR
            Paciente findPaciente = (Paciente) criteria.setMaxResults(1).uniqueResult();


            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            Marshaller jaxbMarshaller = DocXmlToJson.getMarshaller();
            StringWriter stringWriter = new StringWriter();
            try {
                jaxbMarshaller.marshal(docu, stringWriter);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            JsonElement je = jp.parse(stringWriter.toString());
            String prettyJsonString = gson.toJson(je);
            System.out.println(prettyJsonString);

//            Documentos docJson = new Documentos(prettyJsonString);


            if (findPaciente == null) {
                session.save(paciente);
                diag.setPaciente(paciente);
//                docJson.setPaciente(paciente);
            } else {
                diag.setPaciente(findPaciente);
//                docJson.setPaciente(findPaciente);
            }
            Criteria critEstblecimiento = session.createCriteria(Establecimiento.class);
            critEstblecimiento.add(Restrictions.eq("codigo_establecimiento", docu.getHeaderDoc().getCreadorDocumento().getEstablecimiento().getCodigoEstablecimiento()));
            Establecimiento establecimiento = (Establecimiento) critEstblecimiento.setMaxResults(1).uniqueResult();
            System.out.printf(establecimiento.toString());
            medico.setId_establecimiento(establecimiento.getId());

            session.save(medico);
            for(Tratamiento t: tratamientos){
                t.setDiagnostico(diag);
                t.setMedico(medico);
            }
            session.save(diag);
            for(Tratamiento t: tratamientos){
                session.save(t);
            }








            tx1.commit();

        } catch (Exception e ) {
            e.printStackTrace();
            tx1.rollback();
        } finally {
            session.close();
        }
    }
}
