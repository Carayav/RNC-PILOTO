package com.uv.ws.endpoint;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import com.uv.types.rnc.Response;
import com.uv.types.rnc.ObjectFactory;
import com.uv.types.rnc.Paciente;
import com.uv.types.rnc.Documento;

@Endpoint
public class RncEndpoint {

  private static final Logger LOGGER = LoggerFactory.getLogger(RncEndpoint.class);

  @PayloadRoot(namespace = "http://uv.com/types/rnc", localPart = "Documento")
  @ResponsePayload
  public Response UploadDocOp(@RequestPayload Documento request) {
    //Header
    Paciente paciente = request.getHeaderDoc().getPaciente();
    LOGGER.info("Endpoint recibe Documento");
    LOGGER.info("--HEADER--");
    String nombreCompleto = paciente.getNombre() + ' ' + paciente.getPrimerApellido() + ' ' + paciente.getSegundoApellido();
    LOGGER.info("Paciente[Nombre:'{}', RUT={}]", nombreCompleto, paciente.getRUT());

    String mensaje = "Nombre: " + nombreCompleto + " RUT: " + paciente.getRUT();

    ObjectFactory factory = new ObjectFactory();
    Response response = factory.createResponse();
    response.setCodigo("123456");
    response.setMensaje(mensaje);

    LOGGER.info("Endpoint enviando respuesta=[Cod:{} Msj:'{}'", response.getCodigo(), response.getMensaje() );
    return response;
  }
}
