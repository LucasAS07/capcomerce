package io.lrsystem.capcomerce.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError{

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String descripition) {
        super(timestamp, status, error, descripition);
    }

    public List<FieldMessage> getErros() {
        return erros;
    }

    public void addError(String fieldName, String messagem) {
        erros.removeIf(x -> x.getFieldName().equals(fieldName));
        erros.add(new FieldMessage(fieldName, messagem));
    }

}
