package com.realestate.re.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.realestate.re.model.re.Address;

public interface AddressRepository extends JpaRepository<Address,Long>{
	
	
}
