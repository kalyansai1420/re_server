package com.realestate.re.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.example.demo.config.JwtUtils;
// import com.example.demo.helper.UserNotFoundException;
// import com.example.demo.model.JwtRequest;
// import com.example.demo.model.JwtResponse;
// import com.example.demo.model.User;
// import com.example.demo.service.impl.UserDetailsServiceImpl;

import com.realestate.re.helper.UserNotFoundException;
import com.realestate.re.model.User;
import com.realestate.re.config.JwtUtils;
import com.realestate.re.model.JwtRequest;
import com.realestate.re.model.JwtResponse;
import com.realestate.re.service.impl.UserDetailsServiceImpl;



@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class AuthenticateController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private JwtUtils jwtUtils;

	@PostMapping("generate-token")
	public JwtResponse generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {

		try {

			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
			throw new UserNotFoundException("User Not Found ");
		}

		UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtils.generateToken(userDetails);
		return new JwtResponse(token);
	}

	public void authenticate(String username, String password) throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new UserNotFoundException("USER DISABLED " + e.getMessage());
		} catch (BadCredentialsException e) {

			throw new UserNotFoundException("Invalid Credentials" + e.getMessage());
		}

	}

	// return details of current user
	@GetMapping("current-user")
	public User getCurrentUser(Principal principal) {

		return ((User) this.userDetailsService.loadUserByUsername(principal.getName()));
	}

}