package com.caiomiranda.webservice.configurations;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.caiomiranda.webservice.entities.Order;
import com.caiomiranda.webservice.entities.User;
import com.caiomiranda.webservice.repositories.OrderRepository;
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

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(null, "Larissa", "larissa@gmail.com", "99999", "123");
		User user2 = new User(null, "Pamela", "pamela@gmail.com", "99121219", "abc123");
		userRepository.saveAll(List.of(user1, user2));

		Order order1 = new Order(null, Instant.parse("2024-12-23T23:56:00Z"), user1);
		Order order2 = new Order(null, Instant.parse("2024-12-23T19:00:00Z"), user2);
		Order order3 = new Order(null, Instant.parse("2024-12-23T08:00:00Z"), user1);

		orderRepository.saveAll(List.of(order1, order2, order3));
	}

}
