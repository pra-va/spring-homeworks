package it.akademija.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.akademija.PagingData;
import it.akademija.model.User;

@Repository
public class DBUsersRepository implements UserData {
	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private PagingData pagingData;

	public DBUsersRepository() {
	}

	public DBUsersRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<User> getUsers() {
		return entityManager.createQuery("SELECT u from User u", User.class).setMaxResults(this.pagingData.getLimit())
				.getResultList();
	}

	@Override
	public void createUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public void deleteUser(String username) {
		User user = entityManager.createQuery("SELECT u from User u where username =:un", User.class)
				.setParameter("un", username).getSingleResult();
		if (entityManager.contains(user)) {
			entityManager.remove(user);
		} else {
			entityManager.remove(entityManager.merge(user));
		}
	}

}
