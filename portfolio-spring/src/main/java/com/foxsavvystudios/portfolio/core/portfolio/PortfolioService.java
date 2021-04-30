package com.foxsavvystudios.portfolio.core.portfolio;

import com.foxsavvystudios.portfolio.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PortfolioService {

    private AppConfig appConfig;
    private PortfolioRepository portfolioRepository;
    private PortfolioFileRepository portfolioFileRepository;

    public PortfolioService(AppConfig appConfig, PortfolioRepository portfolioRepository, PortfolioFileRepository portfolioFileRepository) {
        this.appConfig = appConfig;
        this.portfolioRepository = portfolioRepository;
        this.portfolioFileRepository = portfolioFileRepository;
    }

    public Portfolio createPortfolioFromDirectory(String directory) {
        Portfolio portfolio = new Portfolio();
        try {
            portfolio.setFiles(scanDirectoryForImageFiles(directory));
            portfolio.setEnabled(true);
            portfolio.setDirectory(directory);
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }
//        portfolioRepository.save(portfolio);

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
            // TODO: handle exception
        }
//        portfolioRepository.save(portfolio);

        return portfolio;
    }

    private List<PortfolioFile> scanDirectoryForImageFiles(String directory) throws IOException {
        List<PortfolioFile> portfolioFiles = new ArrayList<>();

        if(Files.isDirectory(Paths.get(directory))) {
            try (Stream<Path> stream = Files.walk(Paths.get(directory), 1)) {
                portfolioFiles = stream
                        .filter(file -> isSupportedImage(file))
                        .map(file -> new PortfolioFile(file.toAbsolutePath().toString(), true))
                        .collect(Collectors.toList());
            }
        } else {
            throw new NotDirectoryException(directory);
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
