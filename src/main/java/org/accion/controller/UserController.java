package org.accion.controller;

import java.util.List;
import org.accion.entity.User;
import org.accion.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("user")
@CrossOrigin(origins = {"http://localhost:4200"})
public class UserController {
	@Autowired
	private IUserService userService;
	

	@GetMapping("getUserByName")
	public ResponseEntity<User> getUserByName(@RequestParam("userName") String userName) {
		User user = userService.getUserByName(userName);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@GetMapping("allUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> list = userService.getAllUsers();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
	@PostMapping("createUser")
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder builder) {
	  userService.createUser(user);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/createUser?userName={userName}").buildAndExpand(user.getUserName()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("updateUser")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
	userService.updateUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	@DeleteMapping("deleteUser")
	public ResponseEntity<Void> deleteUser(@RequestParam("userName") String userName) {
		userService.deleteUser(userName);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	

}
