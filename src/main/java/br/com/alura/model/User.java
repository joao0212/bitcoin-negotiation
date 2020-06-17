package br.com.alura.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class User extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@NotBlank(message = "Name can not be blank")
	public String name;
	@CPF
	@NotBlank(message = "CPF can not be blank")
	public String cpf;
}
