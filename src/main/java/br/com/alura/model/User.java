package br.com.alura.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.hibernate.validator.constraints.br.CPF;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

@Entity
@UserDefinition
public class User extends PanacheEntityBase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@NotBlank(message = "Name can not be blank")
	public String name;

	@CPF
	@NotBlank(message = "CPF can not be blank")
	public String cpf;

	@Username
	@NotNull(message = "Username can not be null")
	@NotBlank(message = "Username can not be blank")
	public String username;

	@Password
	@NotNull(message = "Password can not be null")
	@NotBlank(message = "Password can not be blank")
	public String password;

	@Roles
	public String role;

	public static Response add(User user) {
		user.role = "user";
		user.password = BcryptUtil.bcryptHash(user.password);
		user.persist();
		return Response.status(Status.CREATED).build();
	}
}
