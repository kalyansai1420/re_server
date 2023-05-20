package com.realestate.re.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realestate.re.model.User;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByUsername(String username);

	// public User findByUId(Long uId);

	public Optional<User> findByEmail(String email);

	

}
