package com.foxsavvystudios.portfolio.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends Exception {

    private static final String MESSAGE_TEMPLATE = "No %s exists for id: %d";

    public EntityNotFoundException(Class<?> clazz, Long id) {
        super(String.format(MESSAGE_TEMPLATE, clazz.getName(), id));
    }
}
