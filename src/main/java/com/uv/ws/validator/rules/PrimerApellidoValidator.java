package com.uv.ws.validator.rules;

import com.uv.types.rnc.Documento;
import com.uv.ws.endpoint.ErrorCodes;
import com.uv.ws.validator.DocumentoValidator;
import com.uv.ws.validator.ValidationException;


public class PrimerApellidoValidator implements DocumentoValidator {
    String elemento = "PrimerApellido";
    @Override
    public void validate(Documento documento) throws ValidationException {
        String primer_Apellido = documento.getHeaderDoc().getPaciente().getPrimerApellido();
        if (primer_Apellido == null){
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + " " + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        } else if (primer_Apellido.trim().isEmpty()){
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + " " + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        } else if(primer_Apellido.length() > 30){
            throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR + " " + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
        }

    }
}
