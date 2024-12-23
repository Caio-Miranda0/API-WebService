package com.caiomiranda.webservice.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caiomiranda.webservice.entities.User;
import com.caiomiranda.webservice.services.UserService;

// Indica que é um endpoint
@RestController
// Indica o caminho para acessar esse endpoint
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	// Mapeia o método findAll() para ser invocado quando da requisição get do HTTP.
	@GetMapping
	// ResponseEntity é uma classe do Spring usada para responder requisições http.
	// É um tipo genérico
	public ResponseEntity<List<User>> findAll() {
		List<User> users = userService.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	// Estou dizendo que aquele endpoint /users vai receber uma variável de ambiente pelo get HTTP
	@GetMapping("/{id}")
	// Para passar essa variável como argumento desse método, eu uso o @PathVariable, que captura o id passado na url.
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}
}
