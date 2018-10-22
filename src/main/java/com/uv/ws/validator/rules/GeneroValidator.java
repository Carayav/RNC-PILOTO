package com.uv.ws.validator.rules;

import com.uv.types.rnc.Documento;
import com.uv.ws.endpoint.ErrorCodes;
import com.uv.ws.validator.DocumentoValidator;
import com.uv.ws.validator.ValidationException;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;

public class GeneroValidator implements DocumentoValidator {
    String elemento = "Genero";
    @Override
    public void validate(Documento documento) {
        BigInteger genero = documento.getHeaderDoc().getPaciente().getGenero();
        if (genero == null){
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + " " + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        }
    }
}