package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "app.properties")
@Getter
@Setter
public class AppProperties {

    /**
     * Application property foo
     */
    private String foo;

    /**
     * Application property bar
     */
    private String bar;
}
