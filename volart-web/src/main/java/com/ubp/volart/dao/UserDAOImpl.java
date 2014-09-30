package com.ubp.volart.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ubp.volart.model.VolartUser;

@Repository
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertUser(VolartUser user) {
		entityManager.persist(user);
	}

	@SuppressWarnings("unchecked")
	@Override
	public VolartUser findByUserName(String username) {

		List<VolartUser> users = new ArrayList<VolartUser>();
		users = entityManager
				.createQuery("from VolartUser where username=:login")
				.setParameter("login", username).getResultList();

		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<VolartUser> findAllUsers() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<VolartUser> cq = builder.createQuery(VolartUser.class);
		Root<VolartUser> root = cq.from(VolartUser.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

}