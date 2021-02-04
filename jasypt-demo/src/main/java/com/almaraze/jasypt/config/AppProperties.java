package com.almaraze.jasypt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties(prefix = "app.variable")
public class AppProperties {

	/**
	 * Variable que no está cifrada
	 */
	private String miMensajeEnTextoClaro;

	/**
	 * Variable cifrada
	 */
	private String miMensajeEncriptado;
}
