package br.com.itauseguros.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidProductNameException extends Exception {
    public InvalidProductNameException(String message) {
        super(message);
    }
}
