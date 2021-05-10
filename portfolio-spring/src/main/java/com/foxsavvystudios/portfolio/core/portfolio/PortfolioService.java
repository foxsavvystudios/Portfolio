package com.foxsavvystudios.portfolio.core.portfolio;


import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class PortfolioService {

    private PortfolioRepository portfolioRepository;

    public PortfolioService(){

    }

    public Portfolio createPortfolioFromDirectory(String directory) {

    }

    public Portfolio updatePortfolioFromDirectory(Portfolio portfolio, String directory) {

    }
}
