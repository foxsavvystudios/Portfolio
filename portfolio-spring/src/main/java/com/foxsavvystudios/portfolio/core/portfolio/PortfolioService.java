package com.foxsavvystudios.portfolio.core.portfolio;


import com.foxsavvystudios.portfolio.core.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class PortfolioService {

    private PortfolioRepository portfolioRepository;

    private static final String MESSAGE_TEMPLATE = "Not a valid directory!";
    public Portfolio createPortfolioFromDirectory(String directory) {
        Portfolio portfolio = new Portfolio();
        if(Files.isDirectory(Paths.get(directory))){
            portfolio.setDirectory(directory);
            portfolio.setFiles(portfolio.getFiles());
        }else{

        }

        return portfolioRepository.save(portfolio);
    }

    public Portfolio updatePortfolioFromDirectory(Portfolio portfolio, String directory) {
        return null;
    }
}
