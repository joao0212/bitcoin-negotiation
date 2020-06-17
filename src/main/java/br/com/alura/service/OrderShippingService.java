package br.com.alura.service;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.alura.model.OrderShipping;
import br.com.alura.model.User;

@ApplicationScoped
public class OrderShippingService {

	@Transactional
	public Response persist(OrderShipping orderShipping) {
		User findById = User.findById(orderShipping.userId);
		if (findById != null) {
			orderShipping.status = "Sent";
			orderShipping.persist();
			return Response.status(Status.CREATED).build();
		}
		return Response.status(Status.BAD_REQUEST.getStatusCode(), "Usuário não cadastrado").build();
	}
}
