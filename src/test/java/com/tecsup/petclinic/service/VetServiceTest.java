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
	
	//Create_Vet
	@Test
    public void testCreateVet() {
        String FIRST_NAME = "Nuevo";
        String LAST_NAME = "Veterinario";
        
        Vet vet = new Vet(0, FIRST_NAME,LAST_NAME);
        vet = vetService.createVet(vet);
        logger.info("" + vet);
        assertThat(vet.getId()).isNotNull();
        assertEquals(FIRST_NAME, vet.getFirst_name());
        assertEquals(LAST_NAME, vet.getLast_name());
	}
	
	
}
