package br.com.alura.resource;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.alura.model.OrderShipping;
import br.com.alura.service.OrderShippingService;

@Path("/orders")
public class OrderShippingResource {

	@Inject
	OrderShippingService service;

	@POST
	@RolesAllowed("user")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response persist(@Valid OrderShipping orderShipping) {
		return service.persist(orderShipping);
	}

	@GET
	@RolesAllowed("user")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrderShipping> listAll() {
		return OrderShipping.listAll();
	}
}
