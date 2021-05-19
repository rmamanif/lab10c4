package com.tecsup.petclinic.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

@Entity(name = "vets")
public class Vet {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	@Column( name = "first_name")
	private String firstName;
	
	@Column( name = "last_name")
	private String lastName;
	
	public Vet() {
		super();
	}
	
	public Vet(long id, String first_name, String last_name) {
		super();
		this.id = id;
		this.firstName = first_name;
		this.lastName = last_name;
	}
	
	public Vet(String first_name, String last_name) {
		super();
		this.firstName = first_name;
		this.lastName = last_name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return firstName;
	}

	public void setFirst_name(String first_name) {
		this.firstName = first_name;
	}

	public String getLast_name() {
		return lastName;
	}

	public void setLast_name(String last_name) {
		this.lastName = last_name;
	}

	@Override
	public String toString() {
		return "Vet [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
