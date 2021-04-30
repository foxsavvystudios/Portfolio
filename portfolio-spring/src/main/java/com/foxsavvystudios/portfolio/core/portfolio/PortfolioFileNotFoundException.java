package com.foxsavvystudios.portfolio.core.portfolio;

public class PortfolioFileNotFoundException extends Exception {

    private static final String MESSAGE_TEMPLATE = "No PortfolioFile exists for id: %d";

    public PortfolioFileNotFoundException(Long id) {
        super(String.format(MESSAGE_TEMPLATE, id));
    }
}
