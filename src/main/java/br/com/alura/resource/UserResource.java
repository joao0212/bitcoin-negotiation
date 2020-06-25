package br.com.alura.resource;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.alura.model.User;

@Path("/users")
public class UserResource {

	@POST
	@PermitAll
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public Response persist(@Valid User user) {
		return User.add(user);
	}

	@GET
	@RolesAllowed("user")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> listAll() {
		return User.listAll();
	}
}
