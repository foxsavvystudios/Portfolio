package com.foxsavvystudios.portfolio.config;


import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class AppConfig {


    public Set<String> getApprovedImageFileExtensions(){
        Set<String> approvedExtensions = new HashSet<>();

        approvedExtensions.add(".jpg");
        approvedExtensions.add(".jpeg");
        approvedExtensions.add(".png");

        return approvedExtensions;
    }
}
