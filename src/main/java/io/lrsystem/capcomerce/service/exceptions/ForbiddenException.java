package io.lrsystem.capcomerce.service.exceptions;

public class ForbiddenException extends RuntimeException{

    public ForbiddenException(String mensagem) {
        super(mensagem);
    }

}
