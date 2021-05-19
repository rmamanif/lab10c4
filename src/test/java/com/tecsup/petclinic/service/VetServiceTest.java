package com.tecsup.petclinic.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tecsup.petclinic.domain.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class VetServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(VetServiceTest.class);
	
	@Autowired
	private VetService vetService;
	
	/*
	 * 
	 */
	
	@Test
	public void testFindVetById() {
		long id=1;
		String NAME = "James";
		Vet vet = null;
		try {
			vet = vetService.findByVetId(id);
		}catch (VetNotFoundException e) {
			fail(e.getMessage());
		}
		logger.info("Veterinario: "+vet);
		assertEquals(NAME, vet.getFirstName());
	}
	
	
	@Test
	public void testDeleteVet() {
		String VET_FNAME = "Jose";
		String VET_LNAME = "De los rios";
		Vet vet = new Vet(VET_FNAME,VET_LNAME);
		vet=vetService.createVet(vet);
		logger.info("Veterinario: "+vet);
		try {
			vetService.deleteVet(vet.getId());
			
		}catch (VetNotFoundException e) {
			fail(e.getMessage());
		}
		
		try{
			vetService.findByVetId(vet.getId());
			assertTrue(false);
		}catch (VetNotFoundException e) {
			assertTrue(true);
		}
		
		
	}
	
	@Test
	public void testUpdateVet() {
		
		String VET_FNAME="Jeff";
		String VET_LNAME="BLACK";
		long create_id=-1;
		
		String UP_VET_FNAME="Alejandro";
		String UP_VET_LNAME="Verde";
		
		Vet vet =new Vet(VET_FNAME,VET_LNAME);
		
		//Crea un registro
		logger.info(">"+vet);
		Vet readVet=vetService.createVet(vet);
		logger.info(">>"+readVet);
		
		create_id=readVet.getId();
		
		//Prepara la data para actualizar
		readVet.setFirstName(UP_VET_FNAME);
		readVet.setLastName(UP_VET_LNAME);
		
		//Ejecuta la actualización
		Vet upgradeVet= vetService.updateVet(readVet);
		logger.info(">>>>"+upgradeVet);
		
		assertThat(create_id).isNotNull();
		assertEquals(create_id,upgradeVet.getId());
		assertEquals(UP_VET_FNAME,upgradeVet.getFirstName());
		assertEquals(UP_VET_LNAME,upgradeVet.getLastName());
		
	}
	
	 @Test
     public void testCreateVet() {
     String FIRST_NAME = "V";
     String LAST_NAME = "N";
     
     Vet vet = new Vet(0, FIRST_NAME,LAST_NAME);
     vet = vetService.createVet(vet);
     logger.info("" + vet);
     assertThat(vet.getId()).isNotNull();
     assertEquals(FIRST_NAME, vet.getFirstName());
     assertEquals(LAST_NAME, vet.getLastName());
	 }
	
	 @Test
		public void testFindOwnerByFirstNameAndId() {
			String FIND_NAME="James";
			long ID=1;
			int SIZE_EXPECTED=1;
			List<Vet> vets= vetService.findByIdAndFirstName(ID,FIND_NAME);
			assertEquals(SIZE_EXPECTED, vets.size());
		}
	 
	
	
}
