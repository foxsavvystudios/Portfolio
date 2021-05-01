package com.foxsavvystudios.portfolio.core.portfolio;

import com.foxsavvystudios.portfolio.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PortfolioService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PortfolioService.class);

    private static final String INVALID_DIRECTORY_MESSAGE_TEMPLATE = "%s is not a valid directory";

    private final AppConfig appConfig;
    private final PortfolioFileRepository portfolioFileRepository;

    public PortfolioService(@Autowired AppConfig appConfig,
                            @Autowired PortfolioFileRepository portfolioFileRepository) {
        this.appConfig = appConfig;
        this.portfolioFileRepository = portfolioFileRepository;
    }

    public Portfolio createPortfolioFromDirectory(String directory) {
        Portfolio portfolio = new Portfolio();
        try {
            portfolio.setFiles(scanDirectoryForImageFiles(directory));
            portfolio.setEnabled(true);
            portfolio.setDirectory(directory);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return portfolio;
    }

    public Portfolio updatePortfolioFromDirectory(Portfolio portfolio, String directory) {
        portfolioFileRepository.deleteAll();

        try {
            List<PortfolioFile> portfolioFiles = scanDirectoryForImageFiles(directory);
            portfolioFileRepository.deleteAll(portfolio.getFiles());
            portfolio.setFiles(portfolioFiles);
            portfolio.setDirectory(directory);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return portfolio;
    }

    private List<PortfolioFile> scanDirectoryForImageFiles(String directory) throws IOException {
        List<PortfolioFile> portfolioFiles;

        if(Files.isDirectory(Paths.get(directory))) {
            try (Stream<Path> stream = Files.walk(Paths.get(directory), 1)) {
                portfolioFiles = stream
                        .filter(this::isSupportedImage)
                        .map(file -> new PortfolioFile(file.toAbsolutePath().toString(), true))
                        .collect(Collectors.toList());
            }
        } else {
            throw new NotDirectoryException(String.format(INVALID_DIRECTORY_MESSAGE_TEMPLATE, directory));
        }

        return portfolioFiles;
    }

    private boolean isSupportedImage(Path file) {
        Set<String> supportedExtensions = appConfig.getSupportedImageFileExtensions();
        boolean supported = false;

        for(String ext: supportedExtensions) {
            if(file.toString().endsWith(ext)) {
                supported = true;
                break;
            }
        }

        return supported;
    }
}