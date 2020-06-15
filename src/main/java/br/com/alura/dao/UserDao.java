package br.com.alura.dao;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.List;
import br.com.alura.model.User;

@ApplicationScoped
public class UserDao {

	@Inject
	EntityManager em;

	@Transactional
	public void save(User user) {
		em.persist(user);
	}

	public List<User> getAll() {
		return em.createQuery("select u from User u", User.class).getResultList();
	}
}
