package com.uv.ws.endpoint.datalayer;

import com.uv.model.Diagnostico;
import com.uv.model.Paciente;
import com.uv.model.Tratamiento;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class PacienteData {


    public void save(com.uv.types.rnc.Documento docu){
        Transaction tx1 = null;
        Session session = null;

        try {
            SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            Paciente paciente = new Paciente(docu);
            Diagnostico diag = new Diagnostico(docu);
            Tratamiento tra = new Tratamiento(docu);

            tx1 = session.beginTransaction();
            session.save(paciente);
            diag.setPaciente(paciente);
            tra.setDiagnostico(diag);

            session.save(diag);
            session.save(tra);
            tx1.commit();

        } catch (Exception e ) {
            tx1.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
