package br.com.alura.dao;

import javax.enterprise.context.ApplicationScoped;

import br.com.alura.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> { }
