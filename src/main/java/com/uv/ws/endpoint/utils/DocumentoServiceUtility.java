package com.uv.ws.endpoint.utils;

import com.uv.ws.Services.DocumentoService;
import com.uv.ws.validator.DocumentoValidator;
import com.uv.ws.validator.rules.*;

import java.util.Arrays;

public class DocumentoServiceUtility {
    public static DocumentoService docSrv;

    public static synchronized DocumentoService getDocSrv(){
        if(docSrv == null){
            docSrv = new DocumentoService(Arrays.<DocumentoValidator>asList(
                    new RutValidator(),
                    new NombreValidator(),
                    new PrimerApellidoValidator(),
                    new SegundoApellidoValidator(),
                    new FechaDeNacimientoValidator(),
                    new GeneroValidator(),
                    new CreadorNombreEstablecimientoValidator(),
                    new CreadorCodigoEstablecimientoValidator(),
                    new CreadorServicioSaludValidator(),
                    new MedicoTratanteValidator(),
                    new ResolucionComiteValidator()
            ));
        }
        return docSrv;
    }
}
