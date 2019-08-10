package com.myGroup.votingsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="candidates")
public class Candidate {
	
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
	
	@Column(name="candidate_name")
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
	
	@Column(name="numberOfVotes")
	private Integer numberOfVotes;
	
	public Integer getNumberOfVotes() {
		return numberOfVotes;
	}

	public void setNumberOfVotes(Integer numberOfVotes) {
		this.numberOfVotes = numberOfVotes;
	}

	/**
	 * @param id
	 * @param name
	 */
	public Candidate(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Candidate() {
		super();
	}
	
	
}
