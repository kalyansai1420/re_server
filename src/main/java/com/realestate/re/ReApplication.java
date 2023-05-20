package com.realestate.re;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// import com.example.demo.helper.UserFoundException;
// import com.example.demo.model.Role;
// import com.example.demo.model.User;
// import com.example.demo.model.UserRole;
// import com.example.demo.service.UserService;

import com.realestate.re.helper.UserFoundException;
import com.realestate.re.model.Role;
import com.realestate.re.model.User;
import com.realestate.re.model.UserRole;
import com.realestate.re.service.UserService;


@SpringBootApplication
public class ReApplication implements CommandLineRunner {
	
	

	Logger log = LoggerFactory.getLogger(ReApplication.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ReApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		log.debug("Starting code");
		//  try {
		// log.debug("starting code");
		
		// // User user = new User();
		// // user.setUsername("sai");
		// // user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
		// // user.setEmail("abc@gmail.com");
		
		// // Role role1 = new Role();
		// // role1.setRoleId(44L);
		// // role1.setRoleName("Admin");
		
		// // Set<UserRole> userRoleSet = new HashSet<>();
		// // UserRole userRole = new UserRole();
		// // userRole.setRole(role1);
		// // userRole.setUser(user);
		
		// // userRoleSet.add(userRole);
		
		// // User user1 = this.userService.createUser(user, userRoleSet);
		// // 	log.debug(user1.getUsername());
		// }
		// catch (UserFoundException e) {
	    //     e.printStackTrace();
	    // }
		
	}
	
	

}
