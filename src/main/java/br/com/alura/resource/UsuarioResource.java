package br.com.alura.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.alura.dto.UsuarioDTO;
import br.com.alura.model.Usuario;
import br.com.alura.service.UsuarioService;

@Path("/usuarios")
public class UsuarioResource {

	@Inject
	UsuarioService usuarioService;

	@POST
	@Transactional
	@Consumes(MediaType.APPLICATION_JSON)
	public Response adicionar(@Valid UsuarioDTO usuarioDTO) {
		usuarioService.adicionar(this.transformarParaObjeto(usuarioDTO));
		return Response.status(Status.CREATED).build();
	}

	@GET
	@RolesAllowed("admin")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listar() {
		List<Usuario> usuarios = usuarioService.listar();
		return Response
				.ok(usuarios.stream().map(usuario -> this.transformarParaDTO(usuario)).collect(Collectors.toList()))
				.build();
	}

	private Usuario transformarParaObjeto(UsuarioDTO usuarioDTO) {
		return new Usuario(usuarioDTO.getNome(), usuarioDTO.getCpf(), usuarioDTO.getUsername(),
				usuarioDTO.getPassword());
	}

	private UsuarioDTO transformarParaDTO(Usuario usuario) {
		return new UsuarioDTO(usuario.getNome(), usuario.getCpf(), usuario.getUsername(), usuario.getRole());
	}
}
