package com.uv.ws.validator.rules;

import com.uv.types.rnc.Documento;
import com.uv.ws.endpoint.ErrorCodes;
import com.uv.ws.validator.DocumentoValidator;
import com.uv.ws.validator.ValidationException;

public class SegundoApellidoValidator implements DocumentoValidator {
    String elemento = "SegundoApellido";
    @Override
    public void validate(Documento documento) {
        String segundo_apellido = documento.getHeaderDoc().getPaciente().getSegundoApellido();
        if (segundo_apellido == null){
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + " " + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        } else if (segundo_apellido.trim().isEmpty()){
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + " " + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        } else if(segundo_apellido.length() > 30) {
            throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR+ " " + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
        }
    }
}

