package com.realestate.re.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realestate.re.helper.ResourceNotFoundException;

// import com.example.demo.helper.UserFoundException;
// import com.example.demo.model.Role;
// import com.example.demo.model.User;
// import com.example.demo.model.UserRole;
// import com.example.demo.service.UserService;

import com.realestate.re.helper.UserFoundException;
import com.realestate.re.model.Role;
import com.realestate.re.model.User;
import com.realestate.re.model.UserRole;
import com.realestate.re.payload.ApiResponse;
import com.realestate.re.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserService userService;

	@GetMapping("/test")
	public String test() {
		return "Welcome to beckend api of re";
	}

	// creating User
	@PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {

		user.setPassword(this.bCryptPasswordEncoder.encode(user.getPassword()));

		Set<UserRole> roles = new HashSet<>();
		Role role = new Role();
		role.setRoleId(45L);
		role.setRoleName("Normal");

		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role);

		roles.add(userRole);

		return this.userService.createUser(user, roles);
	}

	

	//working code
	@PutMapping("/")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		User updatedUser = this.userService.updateUser(user);
		return ResponseEntity.ok(updatedUser);
	}

	



	@GetMapping("/{uId}")
	public User getUser(@PathVariable("uId") Long uId) {

		return this.userService.getUser(uId);
	}

	// delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Long userId) {
		this.userService.deleteUser(userId);
		return new ResponseEntity(new ApiResponse("User deleted Successfully", true), HttpStatus.OK);
	}

	// get all users
	@GetMapping("/")
	public ResponseEntity<Set<User>> getAllUsers() {
		return ResponseEntity.ok(this.userService.getAllUsers());
	}

	// update user
	@ExceptionHandler(UserFoundException.class)
	public ResponseEntity<?> exceptionHandler(UserFoundException ex) {
		return ResponseEntity.ok(ex.getMessage());
	}

}
