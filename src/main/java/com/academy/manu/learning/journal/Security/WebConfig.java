package com.academy.manu.learning.journal.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Erlaubt CORS für alle Routen
                .allowedOrigins("http://localhost:3000") // Dein Frontend-Host
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
