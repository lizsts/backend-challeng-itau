package br.com.itauseguros.infrastructure.rest.handler;

import br.com.itauseguros.application.exceptions.InvalidCategoryException;
import br.com.itauseguros.application.exceptions.InvalidProductNameException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler({InvalidCategoryException.class, InvalidProductNameException.class, NullPointerException.class, IllegalArgumentException.class })
    public ResponseEntity<ErrorResponse> handleBadRequest(Exception exception) {
        return ResponseEntity.badRequest().body(ErrorResponse.builder()
                .timestamp(OffsetDateTime.now())
                .message(exception.getMessage())
                .status(400)
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .path("/products")
                .build());

    }
}
