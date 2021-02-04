package com.almaraze.vault.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase de procesamiento de propiedades. En este caso, se invocan con
 * el prefijo {@code example.properties}.
 * <p>Se establece {@code @RefreshScope} para que el {@code @Bean} creado esté dentro de los
 * componentes que se pueden refrescar en <b>runtime</b></p>
 * @author almaraze
 *
 */
@RefreshScope
@ConfigurationProperties(prefix = "example.properties")
@Getter
@Setter
public class ExampleProperties {

	/**
	 * Documentación de foo
	 */
	private String foo; // property: example.properties.foo
	
	/**
	 * Documentación de bar
	 */
	private String bar; // property: example.properties.bar
	
	/**
	 * Documentación de fooBar
	 */
	private String fooBar; //property: example.properties.foo-bar
}
