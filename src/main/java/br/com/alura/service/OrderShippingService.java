package br.com.alura.service;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.jboss.logging.Logger;

import br.com.alura.model.OrderShipping;
import br.com.alura.model.User;

@ApplicationScoped
public class OrderShippingService {

	private static final Logger LOG = Logger.getLogger(OrderShippingService.class);

	@Transactional
	public Response persist(OrderShipping orderShipping) {
		User findById = User.findById(orderShipping.userId);
		if (findById != null) {
			orderShipping.status = "Sent";
			orderShipping.persist();
			return Response.status(Status.CREATED).build();
		}
		LOG.warn("Não foi possível enviar a ordem. Usuário não cadastrado.");
		return Response.status(Status.BAD_REQUEST.getStatusCode(), "Usuário não cadastrado").build();
	}
}
