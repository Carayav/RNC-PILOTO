package com.uv.ws.endpoint;

import com.uv.types.rnc.Paciente;
import com.uv.validador.rnc.PacienteValidador;
import org.springframework.validation.DataBinder;
import org.springframework.validation.FieldError;

import java.util.List;

public class PacienteValidadorCampos extends ValidadorCampos {
    private Paciente paciente;

    public PacienteValidadorCampos(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<FieldError> start() {
        return this.validarCampos(new DataBinder(paciente), new PacienteValidador());
    }
}
