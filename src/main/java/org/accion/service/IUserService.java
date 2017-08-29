package org.accion.service;
import java.util.List;

import org.accion.entity.*;

public interface IUserService {
	 List<User> getAllUsers();
     User getUserByName(String userName);
     void createUser(User user);
     void updateUser(User user);
     void deleteUser(String userName);
}
