package com.foxsavvystudios.portfolio.core.portfolio;


import com.foxsavvystudios.portfolio.core.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Service
public class PortfolioService {

    private PortfolioRepository portfolioRepository;

    private static final String MESSAGE_TEMPLATE = "%s is not a valid directory!";
    public Portfolio createPortfolioFromDirectory(String directory) {
        Portfolio portfolio = new Portfolio();
        if(Files.isDirectory(Paths.get(directory))){
            portfolio.setDirectory(directory);
            portfolio.setFiles(scanDirectoryFiles(directory));
            portfolio.setEnabled(true);
        }else{
            new PortfolioException(String.format(MESSAGE_TEMPLATE, directory));
        }

        return portfolioRepository.save(portfolio);
    }

    public Portfolio updatePortfolioFromDirectory(Portfolio portfolio, String directory) {
        return null;
    }

    private List <PortfolioFile> scanDirectoryFiles(String directory) throws IOException {
        List <PortfolioFile> portfolioFiles;

        try(Stream<Path> stream = Files.walk(Paths.get(directory)), int maxDepth = 1){

        }
    }
}
