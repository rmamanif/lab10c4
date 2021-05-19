package com.tecsup.petclinic.service;

import java.util.List;

import com.tecsup.petclinic.domain.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;

public interface VetService {
	
	/**
	 * 
	 * @param owner
	 * @return
	 */
	Vet createVet(Vet vet);
	
	/**
	 * 
	 * @param vet
	 * @return
	 */
	Vet updateVet(Vet vet);
	
	/**
	 * 
	 * @param id
	 * @throws VetNotFoundException
	 */
	void deleteVet(long id) throws VetNotFoundException;
	
	/**
	 * 
	 * @param id
	 * @throws VetNotFoundException
	 */
	Vet findByVetId(long id) throws VetNotFoundException;
	
	
	/**
	 * 
	 * @param id, firstName
	 * 
	 * throws VetNotFoundException
	 * 
	 */
	List<Vet> findByIdAndFirstName(long iD, String firstName);
	
	/**
	 * 
	 * @return
	 */
	Iterable<Vet> findAll();
	
}
