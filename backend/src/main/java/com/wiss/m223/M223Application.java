package com.wiss.m223;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class M223Application {

	public static void main(String[] args) {
		SpringApplication.run(M223Application.class, args);
	}


	/**
	 * Konfiguriert CORS-Einstellungen für die gesamte Anwendung, um Anfragen vom Frontend zu akzeptieren.
	 * @return WebMvcConfigurer mit konfigurierten CORS-Einstellungen.
	 */

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// Erlaubt CORS-Anfragen für alle Endpunkte von der angegebenen Origin (Frontend)
				registry.addMapping("/**").allowedOrigins("http://localhost:5173");
			}
		};
	}
}
