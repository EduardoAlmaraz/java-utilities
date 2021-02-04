package com.almaraze.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloController {

    @RequestMapping("/")
    String hello() {

        // Se pinta en el log la etiqueta <password>mi password</password>, al ser revisada por la función %replace
        // la cambiará por *****
        // Output: <password>****</password>
        log.info("<password>mi password</password>");
        
        return "Hello World!";
    }
}
