package br.com.alura.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
public class OrderShipping extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(name = "user_id")
	@NotBlank(message = "User ID can not be blank")
	public Long userId;
	@NotBlank(message = "TID can not be blank")
	public Integer tid;
	public String status;
}
