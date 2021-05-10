package com.foxsavvystudios.portfolio.core.portfoliofile;

import com.foxsavvystudios.portfolio.core.portfoliofile.PortfolioFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioFileRepository extends JpaRepository <PortfolioFile, Long> {
}
