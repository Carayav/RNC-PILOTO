package com.uv.validador.rnc;

import com.uv.types.rnc.HeaderDoc;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class HeaderDocValidador implements Validator {

    /**
     * This Validator validates *only* HeaderDoc instances
     */
    public boolean supports(Class clazz) {
        return HeaderDoc.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "paisEmisor", "paisEmisor.empty");
        HeaderDoc h = (HeaderDoc) obj;

        if (h.getPaisEmisor() != 152) {
            e.rejectValue("paisEmisor", "paisEmisor.NoChile");
        }
    }
}

