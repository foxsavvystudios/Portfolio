package com.foxsavvystudios.portfolio.core.portfolio;

import com.foxsavvystudios.portfolio.core.exception.EntityNotFoundException;
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
    public PortfolioFile getPortfolioFileById(@PathVariable Long portfolioFileId) throws EntityNotFoundException {
        return portfolioFileRepository.findById(portfolioFileId)
                .orElseThrow(() -> new EntityNotFoundException(PortfolioFile.class, portfolioFileId));
    }

    @PostMapping("/{portfolioFileId}/include")
    public PortfolioFile includePortfolioFile(@PathVariable Long portfolioFileId) throws EntityNotFoundException {
        PortfolioFile portfolioFile = portfolioFileRepository.findById(portfolioFileId)
                .orElseThrow(() -> new EntityNotFoundException(PortfolioFile.class, portfolioFileId));
        portfolioFile.setInclude(true);

        return portfolioFileRepository.save(portfolioFile);
    }

    @PostMapping("/{portfolioFileId}/ignore")
    public PortfolioFile ignorePortfolioFile(@PathVariable Long portfolioFileId) throws EntityNotFoundException {
        PortfolioFile portfolioFile = portfolioFileRepository.findById(portfolioFileId)
                .orElseThrow(() -> new EntityNotFoundException(PortfolioFile.class, portfolioFileId));
        portfolioFile.setInclude(false);

        return portfolioFileRepository.save(portfolioFile);
    }

    @DeleteMapping("/{portfolioFileId}")
    public void deletePortfolioFile(@PathVariable Long portfolioFileId) throws EntityNotFoundException {
        PortfolioFile portfolioFile = portfolioFileRepository.findById(portfolioFileId)
                .orElseThrow(() -> new EntityNotFoundException(PortfolioFile.class, portfolioFileId));
        portfolioFileRepository.delete(portfolioFile);
    }
}
