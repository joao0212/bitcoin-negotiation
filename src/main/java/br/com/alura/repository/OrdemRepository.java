package br.com.alura.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import br.com.alura.enuns.Status;
import br.com.alura.model.Ordem;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class OrdemRepository implements PanacheRepository<Ordem> {

	@Transactional
	public void alterar(Long id, Status status) {
		update("status = ?1 where id = ?2", status, id);
	}
}
