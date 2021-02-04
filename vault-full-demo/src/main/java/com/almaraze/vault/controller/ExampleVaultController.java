package com.almaraze.vault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.almaraze.vault.config.ExampleProperties;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ExampleVaultController {

	@Autowired
	private ExampleProperties exampleProperties;
	
	/**
	 * PATH para la consulta de las propiedades !!PERSONALIZADAS!! de la aplicación
	 * @return ResponseEntity<ExampleProperties>
	 */
	@GetMapping("/get-properties")
	public ResponseEntity<ExampleProperties> getProperties() {
		log.debug(exampleProperties.toString());
		
		// Se retornan las propiedades desde el bean ExampleProperties
		return ResponseEntity.ok(exampleProperties);
	}
}
