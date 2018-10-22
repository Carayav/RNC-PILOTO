package com.uv.ws.Services;

import com.uv.types.rnc.Documento;
import com.uv.ws.validator.DocumentoValidator;

import java.util.List;

public class DocumentoService {
    private final List<DocumentoValidator> validators;

    public DocumentoService(List<DocumentoValidator> validators) {
        this.validators = validators;
    }


    public void validate(Documento documento) {
        for (DocumentoValidator validator:validators) {
            validator.validate(documento);
        }
    }
}
