package br.com.alura.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.SecurityContext;

import br.com.alura.exception.RecursoNaoEncontradoException;
import br.com.alura.exception.UsuariosDiferentesException;
import br.com.alura.model.Usuario;
import br.com.alura.repository.UsuarioRepository;
import io.quarkus.elytron.security.common.BcryptUtil;

@ApplicationScoped
public class UsuarioService {

	@Inject
	UsuarioRepository usuarioRepository;

	public void adicionar(Usuario usuario) {
		usuario.setRole("user");
		usuario.setPassword(BcryptUtil.bcryptHash(usuario.getPassword()));
		usuarioRepository.persist(usuario);
	}

	public List<Usuario> listar() {
		return usuarioRepository.listAll();
	}

	public void validar(Long usuarioId, SecurityContext securityContext) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findByIdOptional(usuarioId);
		Usuario usuario = usuarioOptional.orElseThrow(() -> new RecursoNaoEncontradoException());
		if (!usuario.getUsername().equals(securityContext.getUserPrincipal().getName())) {
			throw new UsuariosDiferentesException();
		}
	}

}
