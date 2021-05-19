package com.tecsup.petclinic.service;

import java.util.List;

import com.tecsup.petclinic.domain.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;

public interface VetService {
	
	Vet createVet(Vet vet);
	
	Iterable<Vet> findAll();
}
