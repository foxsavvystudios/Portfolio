package com.foxsavvystudios.portfolio.core.portfolio;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class PortfolioFile {

    private Long portfolioField;
    private String title;
    private String description;
    private String filepath;

    private boolean include;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @PrePersist
    private void prePersist(){
        createdDate = LocalDateTime.now();
        modifiedDate = LocalDateTime.now();
    }

    public PortfolioFile(){

    }

    public PortfolioFile(Long portfolioField, String title, String description, String filepath, boolean include){

        this.portfolioField = portfolioField;
        this.title = title;
        this.description = description;
        this.filepath = filepath;
        this.include = include;

    }

    @PreUpdate
    private void preUpdate() { modifiedDate = LocalDateTime.now(); }


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "portfolio_field")
    public Long getPortfolioField() {
        return portfolioField;
    }

    public void setPortfolioField(Long portfolioField) {
        this.portfolioField = portfolioField;
    }

    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "filepath")
    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    @Column(name = "include")
    public boolean isInclude() {
        return include;
    }

    public void setInclude(boolean include) {
        this.include = include;
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


