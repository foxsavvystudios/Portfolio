package com.foxsavvystudios.portfolio.core.portfolio;

public class PortfolioNotFoundException extends Exception {

    private static final String MESSAGE_TEMPLATE = "No Portfolio exists for id: %d";

    public PortfolioNotFoundException(Long id) {
        super(String.format(MESSAGE_TEMPLATE, id));
    }
}
