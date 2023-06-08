package com.realestate.re.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.realestate.re.helper.ResourceFoundException;
import com.realestate.re.helper.ResourceNotFoundException;
import com.realestate.re.helper.UserFoundException;

// import com.example.demo.helper.UserFoundException;
// import com.example.demo.model.User;
// import com.example.demo.model.UserRole;
// import com.example.demo.repo.RoleRepository;
// import com.example.demo.repo.UserRepository;
// import com.example.demo.service.UserService;

import com.realestate.re.model.User;
import com.realestate.re.model.UserRole;
import com.realestate.re.payload.UserDto;
import com.realestate.re.repo.RoleRepository;
import com.realestate.re.repo.UserRepository;
import com.realestate.re.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User local = this.userRepository.findByUsername(user.getUsername());
		if (local != null) {
			System.out.print("User already present");
			throw new ResourceFoundException("User already exists");
		} else {
			// user create
			for (UserRole ur : userRoles) {
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
		return local;
		
		// Optional<User> usernameEntry = this.userRepository.findByUsername(user.getUsername());
		// Optional<User> emailEntry = this.userRepository.findByEmail(user.getEmail());

		// if (usernameEntry.isPresent()) {
		// 	throw new ResourceFoundException("Username already exists try new username");
		// }
		// if (emailEntry.isPresent()) {
		// 	throw new ResourceFoundException("Email already exists try new email");
		// } else {
		// 	// user create
		// 	for (UserRole ur : userRoles) {
		// 		roleRepository.save(ur.getRole());
		// 	}
		// 	user.getUserRoles().addAll(userRoles);
		// 	this.userRepository.save(user);
		// }

		// return 
		

		
	}

	//updating user
	@Override
	public User updateUser(User user) {
		// Find the existing user by ID
		User existingUser = userRepository.findById(user.getuId())
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", user.getuId()));

		// Update the user's properties
		existingUser.setUsername(user.getUsername());
		existingUser.setEmail(user.getEmail());
		existingUser.setPhonenumber(user.getPhonenumber());
		String newPassword = user.getPassword();
		if (newPassword != null && !newPassword.isEmpty()) {
			// Use BCryptPasswordEncoder to encode the new password
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(newPassword);
			existingUser.setPassword(encodedPassword);
		}

		existingUser.setUserRoles(user.getUserRoles());

		// Save the updated user
		return userRepository.save(existingUser);
	}

	@Override
	public User getUser(Long uId) {

		// User user = this.userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", " Name ", username));
		// User user = this.userRepository.findByUsername(
		// 		username).orElseThrow(
		// 		() -> new ResourceNotFoundException("User", " Name ", username));
		User user = this.userRepository.findById(uId).orElseThrow(
				() -> new ResourceNotFoundException("User", " Id ", uId));

		

		return user;
	}

	@Override
	public User getUserById(Long uId) {

		User user=this.userRepository.findById(uId).orElseThrow(
			() -> new ResourceNotFoundException("User", " Id ", uId)
		);
		return user;

	}

	@Override
	public Set<User> getAllUsers() {
		
		return new HashSet<>(this.userRepository.findAll());

	}

	@Override
	public void deleteUser(Long uId) {

		User user = this.userRepository.findById(uId).orElseThrow(
				() -> new ResourceNotFoundException("User", " Id ", uId));
		this.userRepository.delete(user);
		
	}

	


	public User dtoToUser(UserDto userDto) {
		User user = new User();
		user.setuId(userDto.getuId());
		user.setUsername(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		return user;
	}

	public UserDto userToDto(User user) {
		
		UserDto userDto = new UserDto();
		userDto.setuId(user.getuId());
		userDto.setUsername(user.getUsername());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		return userDto;
	}

	

}
