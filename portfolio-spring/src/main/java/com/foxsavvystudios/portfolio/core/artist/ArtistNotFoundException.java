package com.foxsavvystudios.portfolio.core.artist;

public class ArtistNotFoundException extends Exception {

    private static final String MESSAGE_TEMPLATE = "No Artist exists for id: %d";

    public ArtistNotFoundException(Long id) {
        super(String.format(MESSAGE_TEMPLATE, id));
    }
}
