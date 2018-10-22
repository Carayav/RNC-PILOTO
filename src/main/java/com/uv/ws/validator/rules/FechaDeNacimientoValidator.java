package com.uv.ws.validator.rules;

import com.uv.types.rnc.Documento;
import com.uv.ws.endpoint.ErrorCodes;
import com.uv.ws.validator.DocumentoValidator;
import com.uv.ws.validator.ValidationException;

import javax.xml.datatype.XMLGregorianCalendar;

public class FechaDeNacimientoValidator implements DocumentoValidator {
    String elemento = "FechaDeNacimiento";
    @Override
    public void validate(Documento documento) {
        XMLGregorianCalendar fechaDeNacimiento = documento.getHeaderDoc().getPaciente().getFechaDeNacimiento();
        if (fechaDeNacimiento == null){
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + " " + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        }
    }
}
