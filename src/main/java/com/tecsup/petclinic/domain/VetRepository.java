package com.tecsup.petclinic.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository 
	extends CrudRepository<Vet, Long> {
	
		List<Vet> findByFirstName(String firstName);

		List<Vet> findByLastName(String lastName);
		
}
