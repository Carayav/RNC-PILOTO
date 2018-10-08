package com.uv.ws.endpoint;

import com.uv.types.rnc.HeaderDoc;
import com.uv.validador.rnc.EstablecimientoValidador;
import com.uv.validador.rnc.HeaderDocValidador;
import org.springframework.validation.DataBinder;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class HeaderDocValidadorCampos extends ValidadorCampos {
    private HeaderDoc header;
    private PacienteValidadorCampos pacienteValidadorCampos;

    public HeaderDocValidadorCampos(HeaderDoc header) {
        this.pacienteValidadorCampos = new PacienteValidadorCampos(header.getPaciente());
        this.header = header;
    }

    public List<FieldError> start(){
        List<FieldError> errors = new ArrayList<>();
        List<FieldError> errorHeader = validarCampos(new DataBinder(header),
                new HeaderDocValidador());
        List<FieldError> errorPaciente = pacienteValidadorCampos.start();
        List<FieldError> errorCreadorDoc = validarCampos(new DataBinder(header.getCreadorDocumento().getEstablecimiento()),
                new EstablecimientoValidador());

        errors.addAll(errorHeader);
        errors.addAll(errorPaciente);
        errors.addAll(errorCreadorDoc);
        return errors;
    }



}
