package br.com.alura.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import br.com.alura.model.Bitcoin;
import br.com.alura.service.BitcoinService;

@Path("/negotiations")
public class BitcoinResource {

	private static final Logger LOG = Logger.getLogger(BitcoinResource.class);

	@Inject
	@RestClient
	BitcoinService bitcoinService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bitcoin> getAll() {
		LOG.info("Chamando o método getAll(..)");
		return bitcoinService.getAll();
	}

	@GET
	@Path("/{type}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bitcoin> getByType(@PathParam String type) {
		LOG.info("Chamando o método getByType(" + type + ")");
		return this.getAll().stream().filter(r -> r.getType().equals(type)).collect(Collectors.toList());
	}
}