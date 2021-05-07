package com.foxsavvystudios.portfolio.core.portfolio;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
public class Portfolio {

    private Long portfolioId;
    private String directory;
    private List<PortfolioFile> files;

    private boolean enabled;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @PrePersist
    private void prePersist(){
        createdDate = LocalDateTime.now();
        modifiedDate = LocalDateTime.now();
    }

    public Portfolio(){

    }

    public Portfolio(Long portfolioId, String directory, List<PortfolioFile> files){

        this.portfolioId = portfolioId;
        this.directory = directory;
        this.files = files;
    }

    @PreUpdate
    private void preUpdate() { modifiedDate = LocalDateTime.now(); }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolio_id")
    public Long getPortfolioId() {
        return portfolioId;
    }

    public void setPortfolioId(Long portfolioId) {
        this.portfolioId = portfolioId;
    }

    @Column(name = "directory")
    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    @Column(name = "files")
    public List<PortfolioFile> getFiles() {
        return files;
    }

    public void setFiles(List<PortfolioFile> files) {
        this.files = files;
    }

    @Column(name = "enabled")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Column(name = "created_date")
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "modified_date")
    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
