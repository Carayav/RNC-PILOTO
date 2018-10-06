package com.uv.ws.client;

import com.uv.types.helloworld.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class HelloWorldClient {

  private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldClient.class);

  @Autowired
  private WebServiceTemplate webServiceTemplate;

  public String sayHello(String nombre, String primerApellido, String segundoApellido, String rut) {
    ObjectFactory factory = new ObjectFactory();
    Documento documento = factory.createDocumento();
    Paciente paciente = factory.createPaciente();
    HeaderDoc header = factory.createHeaderDoc();
    paciente.setRUT(rut);
    paciente.setNombre(nombre);
    paciente.setPrimerApellido(primerApellido);
    paciente.setSegundoApellido(segundoApellido);
    header.setPaciente(paciente);
    documento.setHeaderDoc(header);

    LOGGER.info("Cliente enviando Documento");
    LOGGER.info("--HEADER--");
    String nombreCompleto = paciente.getNombre() + ' ' + paciente.getPrimerApellido() + ' ' + paciente.getSegundoApellido();
    LOGGER.info("Paciente[Nombre:'{}', RUT={}]", nombreCompleto, paciente.getRUT());

    Response response = (Response) webServiceTemplate.marshalSendAndReceive(documento);

    LOGGER.info("Cliente recibe response=[Cod:{} Msj='{}'", response.getCodigo(), response.getMensaje());
    return response.getMensaje().toString();
  }
}
