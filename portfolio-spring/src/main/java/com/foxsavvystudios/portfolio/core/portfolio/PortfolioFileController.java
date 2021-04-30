package com.foxsavvystudios.portfolio.core.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/portfolio-file")
public class PortfolioFileController {

    private final PortfolioFileRepository portfolioFileRepository;

    public PortfolioFileController(@Autowired PortfolioFileRepository portfolioFileRepository) {
        this.portfolioFileRepository = portfolioFileRepository;
    }

    @GetMapping
    public List<PortfolioFile> getAllPortfolioFiles() {
        return portfolioFileRepository.findAll();
    }

    @GetMapping("/{portfolioFileId}")
    public PortfolioFile getPortfolioFileById(@PathVariable Long portfolioFileId) throws PortfolioFileNotFoundException {
        return portfolioFileRepository.findById(portfolioFileId)
                .orElseThrow(() -> new PortfolioFileNotFoundException(portfolioFileId));
    }

    @PostMapping("/{portfolioFileId}/include")
    public PortfolioFile disablePortfolioFile(@PathVariable Long portfolioFileId) throws PortfolioFileNotFoundException {
        PortfolioFile portfolioFile = portfolioFileRepository.findById(portfolioFileId)
                .orElseThrow(() -> new PortfolioFileNotFoundException(portfolioFileId));
        portfolioFile.setInclude(true);

        return portfolioFile;
    }

    @PostMapping("/{portfolioFileId}/ignore")
    public PortfolioFile enablePortfolioFile(@PathVariable Long portfolioFileId) throws PortfolioFileNotFoundException {
        PortfolioFile portfolioFile = portfolioFileRepository.findById(portfolioFileId)
                .orElseThrow(() -> new PortfolioFileNotFoundException(portfolioFileId));
        portfolioFile.setInclude(false);

        return portfolioFile;
    }

    @DeleteMapping("/{portfolioFileId}")
    public void deletePortfolioFile(@PathVariable Long portfolioFileId) throws PortfolioFileNotFoundException {
        PortfolioFile portfolioFile = portfolioFileRepository.findById(portfolioFileId)
                .orElseThrow(() -> new PortfolioFileNotFoundException(portfolioFileId));
        portfolioFileRepository.delete(portfolioFile);
    }
}
