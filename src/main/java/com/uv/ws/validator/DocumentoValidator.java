package com.uv.ws.validator;

import com.uv.types.rnc.Documento;

public interface DocumentoValidator {
    void validate(Documento documento) throws ValidationException;
}
