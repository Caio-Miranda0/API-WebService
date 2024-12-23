package com.caiomiranda.webservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiomiranda.webservice.entities.User;

// Interfaces não implementam interfaces, mas herdam de interfaces.
// JpaRepository é uma interface com default methods.
// Como ela trabalha com Generics, quando eu passo o tipo da entidade que vira minha tabela e o tipo da PK
// a interface vai configurar os seus default methods para os tipos de dados que informei.
// Essa é a camada que manipula o meu banco de dados.
public interface UserRepository extends JpaRepository<User, Long>{
}
