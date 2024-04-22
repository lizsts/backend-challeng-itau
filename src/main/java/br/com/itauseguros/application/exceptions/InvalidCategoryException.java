package br.com.itauseguros.application.exceptions;

import org.apache.coyote.BadRequestException;

public class InvalidCategoryException extends BadRequestException {

    public InvalidCategoryException(String message) {
        super(message);
    }
}
