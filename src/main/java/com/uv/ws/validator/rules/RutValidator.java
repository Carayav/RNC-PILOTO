package com.uv.ws.validator.rules;

import com.uv.types.rnc.Documento;
import com.uv.ws.endpoint.ErrorCodes;
import com.uv.ws.validator.DocumentoValidator;
import com.uv.ws.validator.ValidationException;

public class RutValidator implements DocumentoValidator {
    String elemento = "Rut";
    @Override
    public void validate(Documento documento) {
        String rut = documento.getHeaderDoc().getPaciente().getRUT();
        if (rut == null){
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + " " + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        } else if (rut.trim().isEmpty()){
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + " " + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        } else if (rut.length() < 3){
            throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR + " " + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
        } else if (rut.length() > 10){
            throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR + " " + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
        }
    }
}

