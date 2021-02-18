package br.com.alura.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import br.com.alura.dto.OrdemDTO;
import br.com.alura.enuns.Tipo;
import br.com.alura.model.Ordem;
import br.com.alura.service.OrdemService;

@Path("/ordens")
public class OrdemResource {

	@Inject
	OrdemService ordemService;

	@POST
	@RolesAllowed("user")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response adicionar(@Valid OrdemDTO ordemDTO, @Context SecurityContext securityContext) {
		ordemService.adicionar(transformarParaObjeto(ordemDTO), securityContext);
		return Response.status(Status.CREATED).build();
	}

	@GET
	@RolesAllowed("admin")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		List<Ordem> ordens = ordemService.listar();
		return Response.ok(ordens.stream().map(this::transformarParaDTO).collect(Collectors.toList()))
				.build();
	}

	@PUT
	@Path("/{id}")
	@RolesAllowed("user")
	public Response cancelar(@PathParam("id") Long id, @Context SecurityContext securityContext) {
		ordemService.cancelar(id, securityContext);
		return Response.ok().status(Status.OK).build();
	}

	@PUT
	@Path("/{id}/processar")
	@RolesAllowed("admin")
	public Response processar(@PathParam("id") Long id) {
		ordemService.processar(id);
		return Response.ok().status(Status.OK).build();
	}

	private Ordem transformarParaObjeto(OrdemDTO ordemDTO) {
		return new Ordem(ordemDTO.getPreco(), Tipo.valueOf(ordemDTO.getTipo().toUpperCase()), ordemDTO.getUsuarioId());
	}

	private OrdemDTO transformarParaDTO(Ordem ordem) {
		return new OrdemDTO(ordem.getPreco(), ordem.getTipo().name(), ordem.getData(), ordem.getStatus().name(),
				ordem.getUsuarioId());
	}
}
