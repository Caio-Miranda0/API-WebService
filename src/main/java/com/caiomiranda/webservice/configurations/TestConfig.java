package com.caiomiranda.webservice.configurations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.caiomiranda.webservice.entities.User;
import com.caiomiranda.webservice.repositories.UserRepository;

// Eu informo que essa classe é do tipo Configuration.
@Configuration
// Estou configurando o perfil --> ver application.properties
@Profile("test")
public class TestConfig implements CommandLineRunner {

	// Por enquanto, vou usar essa classe para popular o meu banco de dados (data
	// seeding).
	// Por isso, essa classe tem uma dependência com Repository, reponsável por
	// manipular meu DB.
	// Essa anotação faz a injeção de dependência -> cria um construtor recebendo um
	// UserRepository de fora.
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		List<User> users = List.of(new User(null, "Larissa", "larissa@gmail.com", "99999", "123"),
				new User(null, "Pamela", "pamela@gmail.com", "99121219", "abc123"));

		userRepository.saveAll(users);
	}

}
