package com.tecsup.petclinic.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.domain.Vet;
import com.tecsup.petclinic.domain.VetRepository;
import com.tecsup.petclinic.exception.VetNotFoundException;

@Service
public class VetServiceImpl implements VetService {

	private static final Logger logger = LoggerFactory.getLogger(VetServiceImpl.class);
	
	@Autowired
	VetRepository vetRepository;
	
	
	/**
	 * 
	 * @param vet
	 * @return
	 */
	@Override
	public Vet createVet(Vet vet) {
		return vetRepository.save(vet);
	}

	
	/**
	 * 
	 * @param vet
	 * @return
	 */
	@Override
	public Vet updateVet(Vet vet) {
		return vetRepository.save(vet);
	}

	
	/**
	 * 
	 * @param id
	 * @throws VetNotFoundException
	 */
	@Override
	public void deleteVet(long id) throws VetNotFoundException {
		Vet vet= findByVetId(id);
		vetRepository.delete(vet);
	}

	
	/**
	 * 
	 * @param id
	 * @throws VetNotFoundException
	 */
	@Override
	public Vet findByVetId(long id) throws VetNotFoundException {
		Optional <Vet> vet=vetRepository.findById(id);
		if (!vet.isPresent())
			throw new VetNotFoundException("Veterinario inexistente!");
		return vet.get();
	}

	@Override
	public List<Vet> findByIdAndFirstName(long id, String firstName) {
		List<Vet> vets = vetRepository.findByIdAndFirstName(id, firstName);
		vets.stream().forEach(vet ->logger.info(""+vet));
		return vets;
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public Iterable<Vet> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
