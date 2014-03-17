package com.restjplat.quickweb.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name ="children")
public class Children extends IdEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
