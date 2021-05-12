package com.foxsavvystudios.portfolio.core.portfolio;

import com.foxsavvystudios.portfolio.core.portfolio.PortfolioFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioFileRepository extends JpaRepository <PortfolioFile, Long> {
}
