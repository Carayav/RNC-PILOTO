package com.uv.ws.endpoint;


import com.uv.types.rnc.Documento;
import com.uv.types.rnc.ObjectFactory;
import com.uv.types.rnc.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class RncEndpoint {
  private static final Logger LOGGER = LoggerFactory.getLogger(RncEndpoint.class);

  @PayloadRoot(namespace = "http://uv.com/types/rnc", localPart = "Documento")
  @ResponsePayload
  public Response UploadDocOp(@RequestPayload Documento request) {
    String msj;
    ObjectFactory factory = new ObjectFactory();
    Response response = factory.createResponse();

    DocumentValidadorCampos reqProc = new DocumentValidadorCampos(request);
    List<FieldError> allErrors = reqProc.start();

    for (FieldError error : allErrors) {
      if(error.getCode().equals(ErrorCodes.ELEMENTO_VACIO_COD)){
        response.setCodigo(ErrorCodes.ELEMENTO_VACIO_COD);
        msj = ErrorCodes.ELEMENTO_VACIO_STR + error.getField();
        response.setMensaje(msj);
        LOGGER.error(msj);
        return response;
      } else if(error.getCode().equals(ErrorCodes.FORMATO_NO_VALIDO_COD)){
        response.setCodigo(ErrorCodes.FORMATO_NO_VALIDO_COD);
        msj = ErrorCodes.FORMATO_NO_VALIDO_STR + error.getField() + " VALOR: " + error.getRejectedValue();
        response.setMensaje(msj);
        LOGGER.error(msj);
        return response;
      } else if(error.getCode().equals(ErrorCodes.CODIGO_NO_VALIDO_COD)){
        response.setCodigo(ErrorCodes.CODIGO_NO_VALIDO_COD);
        msj = ErrorCodes.CODIGO_NO_VALIDO_STR + error.getField() + " VALOR: " + error.getRejectedValue();
        response.setMensaje(msj);
        LOGGER.error(msj);
        return response;
      }
    }

    response.setCodigo(ErrorCodes.CARGA_EXITOSA_COD);
    response.setMensaje(ErrorCodes.CARGA_EXITOSA_STR);

    LOGGER.info(ErrorCodes.CARGA_EXITOSA_COD);
    LOGGER.info(ErrorCodes.CARGA_EXITOSA_STR);
    return response;
  }
}
