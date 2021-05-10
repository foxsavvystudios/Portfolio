package com.foxsavvystudios.portfolio.core.portfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    private PortfolioRepository portfolioRepository;

    public PortfolioController(@Autowired PortfolioRepository portfolioRepository) { this.portfolioRepository = portfolioRepository; }

    @GetMapping
    public List<Portfolio> getAllPortfolios(){ return portfolioRepository.findAll(); }

    @PostMapping
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio){ return portfolioRepository.save(portfolio); }

    @GetMapping("/{portfolioId}")
    public Portfolio getPortfolioById(@PathVariable Long portfolioId) throws PortfolioNotFoundException {
        return portfolioRepository.findById(portfolioId).orElseThrow(() -> new PortfolioNotFoundException(portfolioId));
    }

    @PutMapping("/{portfolioId}")
    public Portfolio editPortfolio(@RequestBody Portfolio newPortfolio, @PathVariable Long portfolioId) throws PortfolioNotFoundException {
        Portfolio portfolio = portfolioRepository.findById(portfolioId).orElseThrow(() -> new PortfolioNotFoundException(portfolioId));
        newPortfolio.setPortfolioId(portfolio.getPortfolioId());
        return portfolioRepository.save(newPortfolio);
    }

    @PostMapping("/{portfolioId}/disable")
    public Portfolio disablePortfolio(@RequestBody Portfolio disabledPortfolio, @PathVariable Long portfolioId) throws PortfolioNotFoundException {
        Portfolio portfolio = portfolioRepository.findById(portfolioId).orElseThrow(() -> new PortfolioNotFoundException(portfolioId));
        disabledPortfolio.setPortfolioId(portfolio.getPortfolioId());
        disabledPortfolio.setEnabled(false);
        return portfolioRepository.save(disabledPortfolio);
    }

    @PostMapping("/{portfolioId}/enable")
    public Portfolio enablePortfolio(@RequestBody Portfolio enabledPortfolio, @PathVariable Long portfolioId) throws PortfolioNotFoundException {
        Portfolio portfolio = portfolioRepository.findById(portfolioId).orElseThrow(() -> new PortfolioNotFoundException(portfolioId));
        enabledPortfolio.setPortfolioId(portfolio.getPortfolioId());
        enabledPortfolio.setEnabled(true);
        return portfolioRepository.save(enabledPortfolio);
    }

    @DeleteMapping("/{portfolioId}")
    public void deletePortfolio(@PathVariable Long portfolioId) throws PortfolioNotFoundException {
        Portfolio portfolio = portfolioRepository.findById(portfolioId).orElseThrow(() -> new PortfolioNotFoundException(portfolioId));
        portfolioRepository.delete(portfolio);
    }

}
