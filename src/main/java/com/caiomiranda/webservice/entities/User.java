package com.caiomiranda.webservice.entities;

import java.io.Serializable;
import java.util.Objects;

// Serializable tem métodos default que convertem User em cadeias de bytes.
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;

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
