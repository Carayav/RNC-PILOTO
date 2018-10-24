package com.uv.ws.endpoint.utils;

import com.uv.types.rnc.Documento;
import com.uv.types.rnc.ObjectFactory;
// import org.eclipse.persistence.jaxb.JAXBContextFactory;
// import org.eclipse.persistence.jaxb.JAXBContextProperties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class DocXmlToJson implements Serializable {

    // private static final Map<String, Object> properties;
    // private static JAXBContext jaxbContext;
    // public static Marshaller jaxbMarshaller;
    // //Set the various properties you want
    // static {
    //     properties = new HashMap<>();
    //     properties.put(JAXBContextProperties.MEDIA_TYPE, "application/json");
    //     properties.put(JAXBContextProperties.JSON_INCLUDE_ROOT, false);
    // }

    // public static synchronized Marshaller getMarshaller() {
    //     if(jaxbContext == null){
    //         try {
    //             jaxbContext = JAXBContextFactory.createContext(new Class[]{
    //                     Documento.class, ObjectFactory.class}, properties);

    //         } catch (JAXBException e) {
    //             e.printStackTrace();
    //         }
    //     }
    //     if(jaxbMarshaller == null){
    //         try {
    //             jaxbMarshaller = jaxbContext.createMarshaller();
    //         } catch (JAXBException e) {
    //             e.printStackTrace();
    //         }
    //     }
    //     return jaxbMarshaller;
    // }

}
