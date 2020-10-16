package br.com.alura.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;

import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

@Entity
@UserDefinition
public class Usuario {

	public Usuario() { }

	public Usuario(@NotBlank(message = "Nome não pode estar em branco") String nome,
			@CPF @NotBlank(message = "CPF não pode estar em branco") String cpf,
			@NotNull(message = "Username não pode ser nulo") @NotBlank(message = "Username não pode estar em branco") String username,
			@NotNull(message = "Password não pode ser nulo") @NotBlank(message = "Password não pode estar em branco") String password) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.username = username;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Nome não pode estar em branco")
	private String nome;

	@CPF
	@NotBlank(message = "CPF não pode estar em branco")
	private String cpf;

	@Username
	@NotNull(message = "Username não pode ser nulo")
	@NotBlank(message = "Username não pode estar em branco")
	private String username;

	@Password
	@NotNull(message = "Password não pode ser nulo")
	@NotBlank(message = "Password não pode estar em branco")
	private String password;

	@Roles
	private String role;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getRole() {
		return role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
