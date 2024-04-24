package br.com.itauseguros.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCategoryException extends Exception {

    public InvalidCategoryException(String message) {
        super(message);
    }
}
