package com.uv.validador.rnc;

import com.uv.types.rnc.Paciente;
import com.uv.ws.endpoint.ErrorCodes;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PacienteValidador implements Validator {

    /**
     * This Validator validates *only* Person instances
     */
    public boolean supports(Class clazz) {
        return Paciente.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "nombre", ErrorCodes.ELEMENTO_VACIO_COD);
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "primerApellido", ErrorCodes.ELEMENTO_VACIO_COD);
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "segundoApellido", ErrorCodes.ELEMENTO_VACIO_COD);
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "fechaDeNacimiento", ErrorCodes.ELEMENTO_VACIO_COD);
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "genero", ErrorCodes.ELEMENTO_VACIO_COD);

        Paciente p = (Paciente) obj;

        if (p.getNombre().length() > 50) {
            e.rejectValue("nombre", ErrorCodes.FORMATO_NO_VALIDO_COD);
        }
        if(p.getRUT().length() < 3){
            e.rejectValue("rut", ErrorCodes.FORMATO_NO_VALIDO_COD);
        }
        if(p.getRUT().length() > 10){
            e.rejectValue("rut", ErrorCodes.FORMATO_NO_VALIDO_COD);
        }
        if(p.getPrimerApellido().length() > 30){
            e.rejectValue("primerApellido", ErrorCodes.FORMATO_NO_VALIDO_COD);
        }
        if(p.getSegundoApellido().length() > 30) {
            e.rejectValue("segundoApellido", ErrorCodes.FORMATO_NO_VALIDO_COD);
        }
    }
}
