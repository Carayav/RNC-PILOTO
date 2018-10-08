package com.uv.ws.endpoint;

import com.uv.types.rnc.Documento;

public class BodyDocProcessor {
    private Documento.BodyDoc body;
    private int tipoDoc;

    public BodyDocProcessor(Documento request) {
        this.body = request.getBodyDoc();
        this.tipoDoc = request.getHeaderDoc().getTipoDocumento();
    }
}
