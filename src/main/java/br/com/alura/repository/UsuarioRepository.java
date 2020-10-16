package br.com.alura.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.alura.model.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario> {

}
