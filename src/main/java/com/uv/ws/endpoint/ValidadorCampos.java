package com.uv.ws.endpoint;

import org.springframework.validation.DataBinder;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import java.util.List;

public class ValidadorCampos {

    public List<FieldError> validarCampos(DataBinder dataBinder, Validator validator){
        dataBinder.setValidator(validator);
        dataBinder.validate();
        return dataBinder.getBindingResult().getFieldErrors();
    }
}
