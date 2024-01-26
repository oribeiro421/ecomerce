package com.ecomerce.ecomerce.model.exception;

import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends RuntimeException {

    public ResourceNotFoundException(String mensagem){
        super(mensagem);
    }
}
