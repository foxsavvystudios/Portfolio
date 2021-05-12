package com.foxsavvystudios.portfolio.core.portfolio;



import com.foxsavvystudios.portfolio.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
public class PortfolioService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PortfolioService.class);

    private PortfolioFileRepository portfolioFileRepository;
    private AppConfig appConfig;

    private static final String MESSAGE_TEMPLATE = "%s is not a valid directory!";

    public PortfolioService(@Autowired AppConfig appConfig,
                            @Autowired PortfolioFileRepository portfolioFileRepository){

        this.appConfig = appConfig;
        this.portfolioFileRepository = portfolioFileRepository;
    }

    public Portfolio createPortfolioFromDirectory(String directory) {
        Portfolio portfolio = new Portfolio();

        try {
            portfolio.setDirectory(directory);
            portfolio.setFiles(scanDirectoryFiles(directory));
            portfolio.setEnabled(true);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return portfolio;
    }

    public Portfolio updatePortfolioFromDirectory(Portfolio portfolio, String directory) {

        try{
            List<PortfolioFile> portfolioFiles = scanDirectoryFiles(directory);
            portfolioFileRepository.deleteAll(portfolio.getFiles());
            portfolio.setFiles(portfolioFiles);
            portfolio.setDirectory(directory);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

        return portfolio;
    }

    private List <PortfolioFile> scanDirectoryFiles(String directory) throws IOException, PortfolioException {
        List<PortfolioFile> portfolioFiles;

        if (Files.isDirectory(Paths.get(directory))) {
            try (Stream<Path> stream = Files.walk(Paths.get(directory), 1)) {
                portfolioFiles = stream
                                .filter(this::isApprovedImage)
                                .map(file -> new PortfolioFile(file.toAbsolutePath().toString(), true))
                                .collect(Collectors.toList());
            }
        } else {
            throw new PortfolioException(String.format(MESSAGE_TEMPLATE, directory));
        }

        return portfolioFiles;
    }

    private boolean isApprovedImage(Path file){
        Set<String> approvedExtensions = appConfig.getApprovedImageFileExtensions();
        boolean approved = false;

        for(String extens: approvedExtensions){
            if(file.toString().endsWith(extens)){
                approved = true;
                break;
            }
        }

        return approved;
    }
}
