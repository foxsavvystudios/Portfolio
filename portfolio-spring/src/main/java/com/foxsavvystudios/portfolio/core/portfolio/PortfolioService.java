package com.foxsavvystudios.portfolio.core.portfolio;


import com.foxsavvystudios.portfolio.core.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PortfolioService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PortfolioService.class)
    private PortfolioFileRepository portfolioFileRepository;


    private static final String MESSAGE_TEMPLATE = "%s is not a valid directory!";

    public PortfolioService(@Autowired PortfolioFileRepository portfolioFileRepository){
        this.portfolioFileRepository = portfolioFileRepository;
    }

    public Portfolio createPortfolioFromDirectory(String directory) {
        Portfolio portfolio = new Portfolio();

        try {
            portfolio.setDirectory(directory);
            portfolio.setFiles(scanDirectoryFiles(directory));
            portfolio.setEnabled(true);
        } catch (Exception e) {
            Logger.error(e.getMessage());
        }

        return portfolioRepository.save(portfolio);
    }

    public Portfolio updatePortfolioFromDirectory(Portfolio portfolio, String directory) {
        return null;
    }

    private List <PortfolioFile> scanDirectoryFiles(String directory) throws IOException {
        List<PortfolioFile> portfolioFiles;

        if (Files.isDirectory(Paths.get(directory))) {
            try (Stream<Path> stream = Files.walk(Paths.get(directory))) {
                portfolioFiles = new PortfolioFile();
            }
        } else {
            new PortfolioException(String.format(MESSAGE_TEMPLATE, directory));
        }

        return portfolioFiles;
    }
}
