package com.myCompany.votingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="citizens")
public class Citizen {
	
	@Id
	@Column(name="id")
	private Long id;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="citizen_name")
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param id
	 * @param name
	 */
	public Citizen(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	
}
