package com.foxsavvystudios.portfolio.core.user;

public class UserNotFoundException extends Exception {

    private static final String MESSAGE_TEMPLATE = "No User exists for id: %d";

    public UserNotFoundException(Long id) {
        super(String.format(MESSAGE_TEMPLATE, id));
    }
}
