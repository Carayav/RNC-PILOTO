package com.uv.ws.validator.rules;

import com.uv.types.rnc.Documento;
import com.uv.ws.endpoint.ErrorCodes;
import com.uv.ws.validator.DocumentoValidator;
import com.uv.ws.validator.ValidationException;

public class MedicoTratanteValidator implements DocumentoValidator {
    String elemento = "MedicoTratante";

    @Override
    public void validate(Documento documento) {
        String medico_tratante = documento.getBodyDoc().getResolucionTratamientoDoc().getMedicoTratante();
        if (medico_tratante == null || medico_tratante.trim().isEmpty()) {
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        }
    }
}

