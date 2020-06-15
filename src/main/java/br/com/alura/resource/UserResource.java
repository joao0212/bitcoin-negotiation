package br.com.alura.resource;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.alura.dao.UserDao;
import br.com.alura.model.User;

@Path("/user")
public class UserResource {

	@Inject
	UserDao dao;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(User user) {
		dao.save(user);
		return Response.status(201).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAll() {
		return dao.getAll();
	}
}
