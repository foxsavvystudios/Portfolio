package com.foxsavvystudios.portfolio.core.portfoliofile;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolio-file")
public class PortfolioFileController {

    private PortfolioFileRepository portfolioFileRepository;

    public PortfolioFileController(@Autowired PortfolioFileRepository portfolioFileRepository){ this.portfolioFileRepository = portfolioFileRepository; }

    @GetMapping
    public List<PortfolioFile> getAllPortfolioFiles(){ return portfolioFileRepository.findAll(); }

    @PostMapping
    public PortfolioFile createPortfolioFile(@RequestBody PortfolioFile portfolioFile){ return portfolioFileRepository.save(portfolioFile); }

    @GetMapping("/{portfolio-file}")
    public PortfolioFile getPortfolioFile(@PathVariable Long portfolioFileId) throws PortfolioFileNotFoundException {
        return portfolioFileRepository.findById(portfolioFileId).orElseThrow(() -> new PortfolioFileNotFoundException(portfolioFileId));
    }

    @PutMapping("/{portfolio-file}")
    public PortfolioFile editPortfolioFile(@RequestBody PortfolioFile newPortfolioFileId, @PathVariable Long portfolioFileId) throws PortfolioFileNotFoundException {
        PortfolioFile portfolioFile = portfolioFileRepository.findById(portfolioFileId).orElseThrow(() -> new PortfolioFileNotFoundException(portfolioFileId));
        newPortfolioFileId.setPortfolioFileId(newPortfolioFileId.getPortfolioFileId());
        return portfolioFileRepository.save(newPortfolioFileId);
    }

    @PostMapping("/{portfolio-file}/include")
    public PortfolioFile includePortfolioFile(@RequestBody PortfolioFile includedPortfolioFile, @PathVariable Long portfolioFileId) throws PortfolioFileNotFoundException {
        PortfolioFile portfolioFile = portfolioFileRepository.findById(portfolioFileId).orElseThrow(() -> new PortfolioFileNotFoundException(portfolioFileId));
        includedPortfolioFile.setPortfolioFileId(includedPortfolioFile.getPortfolioFileId());
        includedPortfolioFile.setInclude(true);
        return portfolioFileRepository.save(includedPortfolioFile);
    }

    @PostMapping("/{portfolio-file}/ignore")
    public PortfolioFile ignorePortfolioFile(@RequestBody PortfolioFile ignoredPortfolioFile, @PathVariable Long portfolioFileId) throws PortfolioFileNotFoundException {
        PortfolioFile portfolioFile = portfolioFileRepository.findById(portfolioFileId).orElseThrow(() -> new PortfolioFileNotFoundException(portfolioFileId));
        ignoredPortfolioFile.setPortfolioFileId(ignoredPortfolioFile.getPortfolioFileId());
        ignoredPortfolioFile.setInclude(false);
        return portfolioFileRepository.save(ignoredPortfolioFile);
    }

    @DeleteMapping("/{portfolio-file}")
    public void deletePortfolioFile(@PathVariable Long portfolioFileId) throws PortfolioFileNotFoundException {
        PortfolioFile portfolioFile = portfolioFileRepository.findById(portfolioFileId).orElseThrow(() -> new PortfolioFileNotFoundException(portfolioFileId));
        portfolioFileRepository.delete(portfolioFile);
    }
}
