package com.foxsavvystudios.portfolio.core.portfoliofile;

public class PortfolioFileNotFoundException extends Exception {

    private static final String MESSAGE_TEMPLATE = "No Portfolio File exists for this id: %d";

    public PortfolioFileNotFoundException(Long id) { super(String.format(MESSAGE_TEMPLATE, id)); }

}
