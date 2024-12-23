package com.caiomiranda.webservice.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	// Marca o atributo ID como Primary Key da tabela.
	@Id
	// Define que o valor dessa PK será gerado automaticamente pelo DB usando a
	// estratégia IDENTITY.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
	// Ou seja, no modelo relacional de BD, um user pode ter vários orders.
	// O mappedBy identifica o nome do atributo na classe Order que representa a FK.
	@OneToMany(mappedBy = "client")
	private List<Order> orders = new ArrayList<>();
	
	// É obrigatório no spring usar o default construct, senão ele não vai dar conta de instanciar meus objetos.
	public User() {}
	
	// Eu posso até remover o personalizado, pois basicamente ele é usado para EU PRÓPRIO, em hardcode, fazer testes.
	// Ver a classe TestConfig!
	public User(Long id, String name, String email, String phone, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	// Pensando a longo prazo, quando eu quiser fazer um update do meu User no BD,
	// se eu não tiver o set de alguns atributos, não vou poder mudar os dados
	// persistidos.
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	// Hashcode é mais rápido, mas pode acontecer de dois objetos diferentes gerarem
	// um mesmo hash.
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	// Então usamos o equals como segunda alternativa de comparação: tipo uma
	// segunda prova.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
