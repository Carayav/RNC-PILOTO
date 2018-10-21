package com.uv.ws.endpoint;

import com.uv.types.rnc.Documento;
import com.uv.types.rnc.ObjectFactory;
import org.eclipse.persistence.jaxb.JAXBContextFactory;
import org.eclipse.persistence.jaxb.JAXBContextProperties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class Data implements Serializable {
    private String json;

    public Data(Documento request) {
        //Set the various properties you want
        Map<String, Object> properties = new HashMap<>();
        properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
        properties.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
        try {
            JAXBContext jaxbContext =
            JAXBContextFactory.createContext(new Class[]{
            Documento.class, ObjectFactory.class}, properties);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            //Marshall the object
            StringWriter stringWriter = new StringWriter();
            jaxbMarshaller.marshal(request, stringWriter);
            this.json = stringWriter.toString();
        } catch (PropertyException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return json;
    }
}
