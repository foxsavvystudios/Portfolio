package com.foxsavvystudios.portfolio.core.portfolio;


import com.foxsavvystudios.portfolio.core.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolio-file")
public class PortfolioFileController {

    private PortfolioFileRepository portfolioFileRepository;

    public PortfolioFileController(@Autowired PortfolioFileRepository portfolioFileRepository){
        this.portfolioFileRepository = portfolioFileRepository; }

    @GetMapping
    public List<PortfolioFile> getAllPortfolioFiles(){ return portfolioFileRepository.findAll(); }

    @PostMapping
    public PortfolioFile createPortfolioFile(@RequestBody PortfolioFile portfolioFile){
        return portfolioFileRepository.save(portfolioFile); }

    @GetMapping("/{portfolio-file}")
    public PortfolioFile getPortfolioFile(@PathVariable Long portfolioFileId) throws EntityNotFoundException {
        return portfolioFileRepository.findById(portfolioFileId)
                .orElseThrow(() -> new EntityNotFoundException(PortfolioFile.class, portfolioFileId));
    }

    @PutMapping("/{portfolio-file}")
    public PortfolioFile editPortfolioFile(@RequestBody PortfolioFile newPortfolioFileId,
                                           @PathVariable Long portfolioFileId) throws EntityNotFoundException {
        PortfolioFile portfolioFile = portfolioFileRepository.findById(portfolioFileId)
                .orElseThrow(() -> new EntityNotFoundException(PortfolioFile.class, portfolioFileId));
        newPortfolioFileId.setPortfolioFileId(newPortfolioFileId.getPortfolioFileId());
        return portfolioFileRepository.save(newPortfolioFileId);
    }

    @PostMapping("/{portfolio-file}/include")
    public PortfolioFile includePortfolioFile(@PathVariable Long portfolioFileId) throws EntityNotFoundException {
        PortfolioFile portfolioFile = portfolioFileRepository.findById(portfolioFileId)
                .orElseThrow(() -> new EntityNotFoundException(PortfolioFile.class, portfolioFileId));
        portfolioFile.setInclude(true);
        return portfolioFileRepository.save(portfolioFile);
    }

    @PostMapping("/{portfolio-file}/ignore")
    public PortfolioFile ignorePortfolioFile(@PathVariable Long portfolioFileId) throws EntityNotFoundException {
        PortfolioFile portfolioFile = portfolioFileRepository.findById(portfolioFileId)
                .orElseThrow(() -> new EntityNotFoundException(PortfolioFile.class, portfolioFileId));
        portfolioFile.setInclude(false);
        return portfolioFileRepository.save(portfolioFile);
    }

    @DeleteMapping("/{portfolio-file}")
    public void deletePortfolioFile(@PathVariable Long portfolioFileId) throws EntityNotFoundException {
        PortfolioFile portfolioFile = portfolioFileRepository.findById(portfolioFileId)
                .orElseThrow(() -> new EntityNotFoundException(PortfolioFile.class, portfolioFileId));
        portfolioFileRepository.delete(portfolioFile);
    }
}
