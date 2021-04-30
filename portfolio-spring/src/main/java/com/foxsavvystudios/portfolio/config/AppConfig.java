package com.foxsavvystudios.portfolio.config;

import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class AppConfig {

    public Set<String> getSupportedImageFileExtensions() {
        Set<String> supportedExtensions = new HashSet<>();
        supportedExtensions.add("jpg");
        supportedExtensions.add("jpeg");
        supportedExtensions.add("png");
        return supportedExtensions;
    }
}
