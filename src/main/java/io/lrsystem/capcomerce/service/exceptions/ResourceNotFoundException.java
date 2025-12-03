package io.lrsystem.capcomerce.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String mensagem) {
        super(mensagem);
    }

}
