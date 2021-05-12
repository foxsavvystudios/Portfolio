package com.foxsavvystudios.portfolio.core.portfolio;

import com.foxsavvystudios.portfolio.core.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    private PortfolioRepository portfolioRepository;

    public PortfolioController(@Autowired PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository; }

    @GetMapping
    public List<Portfolio> getAllPortfolios(){ return portfolioRepository.findAll(); }

    @PostMapping
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio){ return portfolioRepository.save(portfolio); }

    @GetMapping("/{portfolioId}")
    public Portfolio getPortfolioById(@PathVariable Long portfolioId) throws EntityNotFoundException {
        return portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new EntityNotFoundException(Portfolio.class, portfolioId));
    }

    @PutMapping("/{portfolioId}")
    public Portfolio editPortfolio(@RequestBody Portfolio newPortfolio, @PathVariable Long portfolioId)
            throws EntityNotFoundException {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new EntityNotFoundException(Portfolio.class, portfolioId));
        newPortfolio.setPortfolioId(portfolio.getPortfolioId());
        return portfolioRepository.save(newPortfolio);
    }

    @PostMapping("/{portfolioId}/disable")
    public Portfolio disablePortfolio(@PathVariable Long portfolioId) throws EntityNotFoundException {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new EntityNotFoundException(Portfolio.class, portfolioId));
        portfolio.setEnabled(false);
        return portfolioRepository.save(portfolio);
    }

    @PostMapping("/{portfolioId}/enable")
    public Portfolio enablePortfolio(@PathVariable Long portfolioId) throws EntityNotFoundException {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new EntityNotFoundException(Portfolio.class, portfolioId));
        portfolio.setEnabled(true);
        return portfolioRepository.save(portfolio);
    }

    @DeleteMapping("/{portfolioId}")
    public void deletePortfolio(@PathVariable Long portfolioId) throws EntityNotFoundException {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new EntityNotFoundException(Portfolio.class, portfolioId));
        portfolioRepository.delete(portfolio);
    }

}
