package br.com.alura.service;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.com.alura.enuns.Status;
import br.com.alura.exception.RecursoNaoEncontradoException;
import br.com.alura.model.Bitcoin;
import br.com.alura.model.Ordem;
import br.com.alura.repository.OrdemRepository;

@ApplicationScoped
public class OrdemService {

	@Inject
	OrdemRepository ordemRepository;

	@Inject
	UsuarioService usuarioService;

	@Inject
	@RestClient
	BitcoinService bitcoinService;

	@Transactional
	public void adicionar(Ordem ordem, SecurityContext securityContext) {
		usuarioService.validar(ordem.getUsuarioId(), securityContext);
		ordem.setData(LocalDate.now());
		ordem.setStatus(br.com.alura.enuns.Status.ENVIADA);
		ordemRepository.persist(ordem);
	}

	public List<Ordem> listar() {
		return ordemRepository.listAll();
	}

	public void cancelar(Long id, SecurityContext securityContext) {
		Ordem ordem = ordemRepository.findByIdOptional(id).orElseThrow(() -> new RecursoNaoEncontradoException());
		usuarioService.validar(ordem.getUsuarioId(), securityContext);
		ordemRepository.alterar(ordem.getId(), Status.CANCELADA);
	}

	public void processar(Long id) {
		Ordem ordem = ordemRepository.findByIdOptional(id).orElseThrow(() -> new RecursoNaoEncontradoException());
		ordemRepository.alterar(ordem.getId(), Status.PROCESSADA);
		bitcoinService.enviar(new Bitcoin(ordem.getPreco(), ordem.getTipo().name(), LocalDate.now()));
	}
}
