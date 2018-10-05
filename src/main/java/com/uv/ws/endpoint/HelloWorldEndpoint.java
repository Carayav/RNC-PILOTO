package com.uv.ws.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

//import com.uv.types.helloworld.Greeting;
import com.uv.types.helloworld.Response;
import com.uv.types.helloworld.ObjectFactory;
//import com.uv.types.helloworld.Person;
import com.uv.types.helloworld.ResolucionTratamientoDoc;

@Endpoint
public class HelloWorldEndpoint {

  private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldEndpoint.class);

  //@PayloadRoot(namespace = "http://uv.com/types/helloworld", localPart = "person")
  @PayloadRoot(namespace = "http://uv.com/types/helloworld", localPart = "ResolucionTratamientoDoc")
  @ResponsePayload
  //public Greeting sayHello(@RequestPayload Person request) {
  public Response sayHello(@RequestPayload ResolucionTratamientoDoc request) {
    //LOGGER.info("Endpoint received person[firstName={},lastName={}]", request.getFirstName(),
    LOGGER.info("Endpoint received resolucionTratamientoDoc[MedicoTratante={},RUT_paciente={}]", request.getMedicoTratante(),
        request.getPacienteRes().getRUT());

    String mensaje = "Medico tratante " + request.getMedicoTratante() + " RUT paciente " + request.getPacienteRes().getRUT() + "!";

    ObjectFactory factory = new ObjectFactory();
    Response response = factory.createResponse();
    response.setCodigo("123456");
    response.setMensaje(mensaje);

    LOGGER.info("Endpoint sending response=[Codigo={}m Mensaje='{}'", response.getCodigo(), response.getMensaje() );
    return response;
  }
}
