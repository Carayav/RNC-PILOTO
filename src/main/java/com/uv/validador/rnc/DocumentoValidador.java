package com.uv.validador.rnc;

import com.uv.types.rnc.Documento;
import com.uv.ws.endpoint.ErrorCodes;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class DocumentoValidador implements Validator {

    /**
     * This Validator validates *only* Person instances
     */
    public boolean supports(Class clazz) {
        return Documento.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {

        Documento d = (Documento) obj;

        int tipoDoc = d.getHeaderDoc().getTipoDocumento();

        if (tipoDoc == 1 && d.getBodyDoc().getResolucionTratamientoDoc() == null) {
            e.rejectValue("bodyDoc", ErrorCodes.FORMATO_NO_VALIDO_COD);
        } else if(tipoDoc == 2 && d.getBodyDoc().getDiagnosticoDoc() == null){
            e.rejectValue("bodyDoc", ErrorCodes.FORMATO_NO_VALIDO_COD);
        }
    }
}
