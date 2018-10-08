package com.uv.validador.rnc;

import com.uv.types.rnc.CreadorDocumento;
import com.uv.types.rnc.Establecimiento;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EstablecimientoValidador implements Validator {

    /**
     * This Validator validates *only* Establecimiento instances
     */
    public boolean supports(Class clazz) {
        return Establecimiento.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "nombreEstablecimiento", "nombreEstablecimiento.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "codigoEstablecimiento", "codigoEstablecimiento.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "servicioSalud", "codigoEstablecimiento.empty");

        Establecimiento es = (Establecimiento) obj;

    }
}

