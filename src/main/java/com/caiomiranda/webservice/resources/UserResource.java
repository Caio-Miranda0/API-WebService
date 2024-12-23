package com.caiomiranda.webservice.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caiomiranda.webservice.entities.User;

// Indica que é um endpoint
@RestController
// Indica o caminho para acessar esse endpoint
@RequestMapping(value = "/users")
public class UserResource {
	
	// Mapeia o método findAll() para ser invocado quando da requisição get do HTTP.
	@GetMapping
	// ResponseEntity é uma classe do Spring usada para responder requisições http.
	// É um tipo genérico
	public ResponseEntity<User> findAll() {
		return ResponseEntity.ok().body(new User(1L,"Caio", "caio@gmail.com","9999999","123abc"));
	}
}
