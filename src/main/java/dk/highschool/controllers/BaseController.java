package dk.highschool.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class BaseController {
    @ExceptionHandler({
        Exception.class
    })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public static String handleException(final Exception ex) {
        return ex.getMessage();
    }

}
