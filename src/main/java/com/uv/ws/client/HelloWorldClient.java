package com.uv.ws.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

//import com.uv.types.helloworld.Greeting;
import com.uv.types.helloworld.Response;
import com.uv.types.helloworld.ObjectFactory;
//import com.uv.types.helloworld.Person;
import com.uv.types.helloworld.ResolucionTratamientoDoc;


@Component
public class HelloWorldClient {

  private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldClient.class);

  @Autowired
  private WebServiceTemplate webServiceTemplate;

  public String sayHello(String medicoTratante, int rut) {
    ObjectFactory factory = new ObjectFactory();
    ResolucionTratamientoDoc resolucionTratamientoDoc= factory.createResolucionTratamientoDoc();
    ResolucionTratamientoDoc.PacienteRes pacienteRes = factory.createResolucionTratamientoDocPacienteRes();
    pacienteRes.setRUT(rut);

    resolucionTratamientoDoc.setMedicoTratante(medicoTratante);
    resolucionTratamientoDoc.setPacienteRes(pacienteRes);

    LOGGER.info("Client sending resolucionTratamientoDoc[MedicoTratante={},RUT_paciente={}]", resolucionTratamientoDoc.getMedicoTratante(),
        resolucionTratamientoDoc.getPacienteRes().getRUT());

    Response response = (Response) webServiceTemplate.marshalSendAndReceive(resolucionTratamientoDoc);

    LOGGER.info("Client received response=[Codigo={} Mensaje='{}'", response.getCodigo(), response.getMensaje());
    return response.getMensaje().toString();
  }
}
