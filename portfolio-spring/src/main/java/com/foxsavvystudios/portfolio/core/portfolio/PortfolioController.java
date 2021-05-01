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
@RequestMapping("/portfolio")
public class PortfolioController {

    private final PortfolioRepository portfolioRepository;

    public PortfolioController(@Autowired PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    @GetMapping
    public List<Portfolio> getAllPortfolios() {
        return portfolioRepository.findAll();
    }

    @GetMapping("/{portfolioId}")
    public Portfolio getPortfolioById(@PathVariable Long portfolioId) throws EntityNotFoundException {
        return portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new EntityNotFoundException(Portfolio.class, portfolioId));
    }

    @PostMapping("/{portfolioId}/disable")
    public Portfolio disablePortfolio(@PathVariable Long portfolioId) throws EntityNotFoundException {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new EntityNotFoundException(Portfolio.class, portfolioId));
        portfolio.setEnabled(false);

        return portfolio;
    }

    @PostMapping("/{portfolioId}/enable")
    public Portfolio enablePortfolio(@PathVariable Long portfolioId) throws EntityNotFoundException {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new EntityNotFoundException(Portfolio.class, portfolioId));
        portfolio.setEnabled(true);

        return portfolio;
    }

    @DeleteMapping("/{portfolioId}")
    public void deletePortfolio(@PathVariable Long portfolioId) throws EntityNotFoundException {
        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() -> new EntityNotFoundException(Portfolio.class, portfolioId));
        portfolioRepository.delete(portfolio);
    }
}
