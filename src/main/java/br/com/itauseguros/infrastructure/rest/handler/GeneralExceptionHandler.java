package br.com.itauseguros.infrastructure.rest.handler;

import br.com.itauseguros.application.exceptions.InvalidCategoryException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GeneralExceptionHandler {

    @ExceptionHandler(InvalidCategoryException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ResponseEntity<Object> handleBadRequest(BadRequestException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(exception.getMessage());

    }
}
