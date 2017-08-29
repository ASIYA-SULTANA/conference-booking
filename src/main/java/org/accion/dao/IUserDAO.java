package org.accion.dao;

import java.util.List;

import org.accion.entity.User;

public interface IUserDAO {

	 List<User> getAllUsers();
	    User getUserByName(String userName);
	    void createUser(User user);
	    void updateUser(User user);
	    void deleteUser(String userName);
	   
}
