package com.restjplat.quickweb.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.repository.NoRepositoryBean;

@Entity
@Table(name ="dict")
@Cacheable
public class Dict extends IdEntity{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String value;
	private String label;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

}
