package com.almaraze.vault.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Clase de configuración 
 * IMPORTANTE: Aquí debe habilitar {@code EnableConfigurationProperties} para
 * que se procecen las propiedades establecidas en las clase con anotación {@code ConfigurationProperties}
 * ambas anotaciones van de la mano.
 * @author almaraze
 *
 */
@Configuration
@EnableConfigurationProperties({ ExampleProperties.class })
public class ExampleConfiguration {

	/**
	 * Declare custom beans
	 */
}
