package org.accion.service;

import java.util.List;

import org.accion.dao.IUserDAO;
import org.accion.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
	@Autowired
	private IUserDAO userDAO;
	@Override
	public User getUserByName(String userName) {
		User user = userDAO.getUserByName(userName);
		return user;
	}	
	@Override
	public List<User> getAllUsers(){
		return userDAO.getAllUsers();
	}
	@Override
	public void createUser(User user){
    	           userDAO.createUser(user);
    	         
               }

	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}
	@Override
	public void deleteUser(String userName) {
		userDAO.deleteUser(userName);
	}
	

}
