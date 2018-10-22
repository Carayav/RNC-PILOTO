package com.uv.ws.validator.rules;

import com.uv.types.rnc.Documento;
import com.uv.ws.endpoint.ErrorCodes;
import com.uv.ws.validator.DocumentoValidator;
import com.uv.ws.validator.ValidationException;

import javax.xml.datatype.XMLGregorianCalendar;

public class CreadorNombreEstablecimientoValidator implements DocumentoValidator {
    String elemento = "NombreEstablecimiento";
    @Override
    public void validate(Documento documento) {
        String establecimiento = documento.getHeaderDoc().getCreadorDocumento().getEstablecimiento().getNombreEstablecimiento();
        if (establecimiento == null) {
            throw new ValidationException(ErrorCodes.ELEMENTO_VACIO_STR + elemento, ErrorCodes.ELEMENTO_VACIO_COD);
        } else if (!establecimiento.equals("Instituto Nacional del Cancer")) {
            throw new ValidationException(ErrorCodes.FORMATO_NO_VALIDO_STR + elemento, ErrorCodes.FORMATO_NO_VALIDO_COD);
        }

    }
}
