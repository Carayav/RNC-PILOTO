package com.uv.ws.endpoint;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.uv.types.rnc.Documento;
import com.uv.types.rnc.ObjectFactory;
import com.uv.types.rnc.Response;
import com.uv.ws.Services.DocumentoService;
import com.uv.ws.endpoint.datalayer.PacienteData;
import com.uv.ws.endpoint.utils.DocXmlToJson;
import com.uv.ws.endpoint.utils.DocumentoServiceUtility;
import com.uv.ws.validator.DocumentoValidator;
import com.uv.ws.validator.ValidationException;
import com.uv.ws.validator.rules.*;
import org.hibernate.exception.JDBCConnectionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Arrays;


@Endpoint
public class RncEndpoint {
  private static final Logger LOGGER = LoggerFactory.getLogger(RncEndpoint.class);


  @PayloadRoot(namespace = "http://uv.com/types/rnc", localPart = "Documento")
  @ResponsePayload
  public Response UploadDocOp(@RequestPayload Documento request)  {
    String msj;
    ObjectFactory factory = new ObjectFactory();
    Response response = factory.createResponse();

    DocumentoService docSrv = DocumentoServiceUtility.getDocSrv();

    try {
        docSrv.validate(request);
    }
    catch (ValidationException e){
        e.printStackTrace();
        response.setCodigo(e.getCode());
        response.setMensaje(e.getMessage());
        LOGGER.error(e.getMessage());
        return response;
    }

//    Gson gson = new GsonBuilder().setPrettyPrinting().create();
//    JsonParser jp = new JsonParser();
//    Marshaller jaxbMarshaller = DocXmlToJson.getMarshaller();
//    StringWriter stringWriter = new StringWriter();
//    try {
//      jaxbMarshaller.marshal(request, stringWriter);
//    } catch (JAXBException e) {
//      e.printStackTrace();
//    }
//    JsonElement je = jp.parse(stringWriter.toString());
//    String prettyJsonString = gson.toJson(je);

//    LOGGER.info(prettyJsonString);


    PacienteData pacData = new PacienteData();
    try {
      pacData.save(request);
    }
    catch (JDBCConnectionException e){
      response.setCodigo(ErrorCodes.CONEXION_BD_COD);
      response.setMensaje(ErrorCodes.CONEXION_BD_STR);
      LOGGER.error(e.getMessage());
      return response;
    }

    response.setCodigo(ErrorCodes.CARGA_EXITOSA_COD);
    response.setMensaje(ErrorCodes.CARGA_EXITOSA_STR);

    LOGGER.info(ErrorCodes.CARGA_EXITOSA_COD);
    LOGGER.info(ErrorCodes.CARGA_EXITOSA_STR);
    return response;
  }
}
