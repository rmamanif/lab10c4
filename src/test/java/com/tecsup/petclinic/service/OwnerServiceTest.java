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

import com.tecsup.petclinic.domain.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class OwnerServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(OwnerServiceTest.class);

	//@Autowired
   //	private OwnerService ownerService;

	/**
	 * 
	 */
	/*
	@Test
	public void testFindOwnerById() {

		long ID = 1;
		String NAME = "Jaime";
		Owner owner = null;
		
		try {
			
			owner = ownerService.findById(ID);
			
		} catch (OwnertNotFoundException e) {
			fail(e.getMessage());
		}
		logger.info("" + owner);

		assertEquals(NAME, owner.getName());

	}
	*/
	
	@Autowired 
	private OwnerService ownerService;
	
	@Test
	public void testFindOwnerById() {
		long id=1;
		String NAME = "George";
		Owner owner = null;
		try {
			owner = ownerService.findById(id);
		}catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}
		logger.info(""+owner);
		assertEquals(NAME, owner.getFirst_name());
	}
	
	@Test
	public void testFindOwnerByLastName() {
		String FIND_NAME="Franklin";
		int SIZE_EXPECTED=1;
		List<Owner> owners= ownerService.findByLastName(FIND_NAME);
		assertEquals(SIZE_EXPECTED, owners.size());
	}
	
	@Test
    public void testCreateOwner() {
        String OWNER_FIRST_NAME = "Jorge";
        String LAST_NAME = "Carpena";
        String ADDRESS = "Av. 123";
        String CITY = "Lima";
        String TELEPHONE = "987654321";
        Owner owner = new Owner(0, OWNER_FIRST_NAME,LAST_NAME,ADDRESS,CITY,TELEPHONE);
        owner = ownerService.createOwner(owner);
        logger.info("" + owner);
        assertThat(owner.getId()).isNotNull();
        assertEquals(OWNER_FIRST_NAME, owner.getFirst_name());
        assertEquals(LAST_NAME, owner.getLast_name());
        assertEquals(ADDRESS, owner.getAddress());
        assertEquals(CITY, owner.getCity());
        assertEquals(TELEPHONE, owner.getTelephone());
    }
	
	@Test
	public void testUpdateOwner() {
		
		String OWNER_FNAME="Jeff";
		String OWNER_LNAME="BLACK";
		long create_id=-1;
		
		String UP_OWNER_FNAME="Alejandro";
		String UP_OWNER_LNAME="Verde";
		
		Owner owner =new Owner(OWNER_FNAME,OWNER_LNAME);
		
		//Crea un registro
		logger.info(">"+owner);
		Owner readOwner=ownerService.createOwner(owner);
		logger.info(">>"+readOwner);
		
		create_id=readOwner.getId();
		
		//Prepara la data para actualizar
		readOwner.setFirst_name(UP_OWNER_FNAME);
		readOwner.setLast_name(UP_OWNER_LNAME);
		
		//Ejecuta la actualización
		Owner upgradeOwner= ownerService.updateOwner(readOwner);
		logger.info(">>>>"+upgradeOwner);
		
		assertThat(create_id).isNotNull();
		assertEquals(create_id,upgradeOwner.getId());
		assertEquals(UP_OWNER_FNAME,upgradeOwner.getFirst_name());
		assertEquals(UP_OWNER_LNAME,upgradeOwner.getLast_name());
		
	}
	
	@Test
	public void testDeleteOwner() {
		String OWNER_FNAME = "Jose";
		String OWNER_LNAME = "De los rios";
		Owner owner = new Owner(OWNER_FNAME,OWNER_LNAME);
		owner=ownerService.createOwner(owner);
		logger.info("Dueño: "+owner);
		logger.info("Nombre: "+owner.getFirst_name()+" "+owner.getLast_name());
		try {
			ownerService.deleteOwner(owner.getId());
			
		}catch (OwnerNotFoundException e) {
			fail(e.getMessage());
		}
		
		try{
			ownerService.findById(owner.getId());
			assertTrue(false);
		}catch (OwnerNotFoundException e) {
			assertTrue(true);
		}
		
		
	}
	
}
