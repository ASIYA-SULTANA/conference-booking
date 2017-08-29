package org.accion.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.accion.entity.User;
import org.springframework.stereotype.Repository;

@Transactional
@Repository

public class UserDAO implements IUserDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public User getUserByName(String userName) {
		return entityManager.find(User.class, userName);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		
		return (List<User>) entityManager.createQuery("select userName,fullName,password from User").getResultList();
	}	
	@Override
	public void createUser(User user) {
		entityManager.persist(user);
	}
	@Override
	public void updateUser(User user) {
		User usr = getUserByName(user.getUserName());
		usr.setFullName(user.getFullName());
		usr.setPassword(user.getPassword());
		usr.setEmailId(user.getEmailId());
		entityManager.flush();
	}
	@Override
	public void deleteUser(String userName) {
		entityManager.remove(getUserByName(userName));
	}
	
	

}
