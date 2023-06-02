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

	
	
	public static void main(String[] args) {
		SpringApplication.run(ReApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		log.debug("Starting code");
		
	}
	
	

}
