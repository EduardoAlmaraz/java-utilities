package com.almaraze.jasypt;

import com.almaraze.jasypt.config.AppProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class DemoJasyptApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoJasyptApplication.class, args);
		AppProperties bean = context.getBean(AppProperties.class);

		// Se pintan tanto la variable en texto claro y la que está encritpada.
		log.info("Mensaje en texto claro: {}", bean.getMiMensajeEnTextoClaro());
		log.info("Mensaje encriptado: {}", bean.getMiMensajeEncriptado());
	}
}
