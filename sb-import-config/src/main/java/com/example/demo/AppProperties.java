package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "app.properties")
@Getter
@Setter
public class AppProperties {
    
    /**
     * Propiedades privadas
     */
    private AppPrivateProperties appPrivateProperties;

    /**
     * Propiedades publicas
     */
    private AppPublicProperties appPublicProperties;
}
