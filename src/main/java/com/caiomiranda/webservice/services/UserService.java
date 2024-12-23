package com.caiomiranda.webservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiomiranda.webservice.entities.User;
import com.caiomiranda.webservice.repositories.UserRepository;

// Essa anotação é para dizer que classe UserService é do tipo Service (Component)
// Se eu não usar essa anotação nessa classe, no momento em que ele for fazer injeção de dependência no meu UserResource (Controller), ele simplesmente não consegue.
@Service
public class UserService {
	
	// Faz a DI
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		// userRepository.findById(Long id) -> retorna um Optional<T> -> Generics : então eu passo o tipo que quero retornar, no caso User.
		Optional<User> user = userRepository.findById(id);
		// user.get(); -> Como Optional é generics, quando eu passo User, seu método get recebe User como tipo de dado de retorno e me retorna um objeto user.
		return user.get();
	}
}
