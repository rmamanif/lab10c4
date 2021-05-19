package com.tecsup.petclinic.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetRepository 
	extends CrudRepository<Vet, Long> {
	
	//Vets por Nombre e ID
	List<Vet> findByIdAndFirstName(long id, String firstName);
	
	
}
