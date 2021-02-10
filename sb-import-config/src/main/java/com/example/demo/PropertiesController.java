package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PropertiesController {

    private final AppProperties appProperties;

    @GetMapping("/properties")
    @ResponseBody AppProperties getProperties() {
        return appProperties;
    }

}
