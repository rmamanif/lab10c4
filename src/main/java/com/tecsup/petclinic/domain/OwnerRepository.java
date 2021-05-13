package com.tecsup.petclinic.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository 
	extends CrudRepository<Owner, Long> {
	// Fetch pets by phone
	List<Owner> findByTelephone(String telephone);

	// Fetch pets by last_name
	List<Owner> findByLastName(String lastName);

	// Fetch pets by address
	List<Owner> findByAddress(String address);
	
}
