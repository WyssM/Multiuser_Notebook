// Ich habe einen Spring-Controller erstellt, um Anfragen auf den Pfad "/admin" zu verarbeiten.
package com.wiss.m223.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	// Diese Methode wird aufgerufen, wenn jemand den Pfad "/admin" per HTTP GET-Anfrage aufruft.
	@GetMapping("/admin")
	// Ich sende eine HTTP-Antwort zurück, die den Text "Hello Admin" enthält und den Status "200 OK" hat.
	public ResponseEntity<String> getGreeting() {
		return ResponseEntity.ok("Hello Admin");
	} 
	
}
