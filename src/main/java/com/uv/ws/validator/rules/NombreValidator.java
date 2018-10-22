package com.uv.ws.validator.rules;

import com.uv.types.rnc.Documento;
import com.uv.ws.endpoint.ErrorCodes;
import com.uv.ws.validator.DocumentoValidator;
import com.uv.ws.validator.ValidationException;
import org.springframework.context.annotation.Bean;


public class NombreValidator implements DocumentoValidator {
    String elemento = "Nombre";
    @Override
    public void validate(Documento documento) {
        String first_name = documento.getHeaderDoc().getPaciente().getNombre();
        if (first_name == null){
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + " " + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        } else if (first_name.trim().isEmpty()){
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + " " + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        } else if (first_name.length() > 50) {
            throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR + " " + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
        }
    }
}
