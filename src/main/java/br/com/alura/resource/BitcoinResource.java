package br.com.alura.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import br.com.alura.model.Bitcoin;
import br.com.alura.service.BitcoinService;

@Path("/bitcoins")
public class BitcoinResource {

	@Inject
	@RestClient
	BitcoinService bitcoinService;

	@GET()
	@PermitAll
	@Path("processados")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bitcoin> listar() {
		return bitcoinService.listar();
	}

	@GET
	@PermitAll
	@Path("processados/{tipo}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Bitcoin> listarPorTipo(@PathParam String tipo) {
		return this.listar().stream().filter(r -> r.getTipo().equals(tipo.toUpperCase())).collect(Collectors.toList());
	}
}