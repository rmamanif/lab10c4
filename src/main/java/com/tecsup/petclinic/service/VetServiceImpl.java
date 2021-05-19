package com.tecsup.petclinic.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.domain.Vet;
import com.tecsup.petclinic.domain.VetRepository;



@Service
public class VetServiceImpl implements VetService {
	
	private static final Logger logger = LoggerFactory.getLogger(VetServiceImpl.class);

	@Autowired
	VetRepository vetRepository;

	@Override
	public Vet createVet(Vet vet) {
		return vetRepository.save(vet);
	}

	@Override
	public Iterable<Vet> findAll() {
		return vetRepository.findAll();
	}
}




