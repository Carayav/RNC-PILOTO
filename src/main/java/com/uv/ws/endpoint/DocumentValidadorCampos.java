package com.uv.ws.endpoint;

import com.uv.types.rnc.Documento;
import com.uv.types.rnc.HeaderDoc;
import com.uv.validador.rnc.DocumentoValidador;
import org.springframework.validation.DataBinder;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class DocumentValidadorCampos extends ValidadorCampos {
    private Documento doc;
    private HeaderDoc header;
    private HeaderDocValidadorCampos headerProc;

    public DocumentValidadorCampos(Documento request) {
        this.doc = request;
        this.header = request.getHeaderDoc();
        this.headerProc = new HeaderDocValidadorCampos(request.getHeaderDoc());
    }

    public List<FieldError> start(){
        List<FieldError> errors = new ArrayList<>();
        List<FieldError> errorDoc = validarCampos(new DataBinder(doc),
                new DocumentoValidador());
        errors.addAll(errorDoc);
        errors.addAll(headerProc.start());
        return errors;
    }
}
