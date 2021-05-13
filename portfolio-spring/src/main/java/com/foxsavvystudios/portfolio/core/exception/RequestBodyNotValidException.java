package com.foxsavvystudios.portfolio.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class RequestBodyNotValidException extends Exception {

    private static final String MESSAGE_TEMPLATE = "Request body not valid: %s";

    public RequestBodyNotValidException(String message) {
        super(String.format(MESSAGE_TEMPLATE, message));
    }
}
