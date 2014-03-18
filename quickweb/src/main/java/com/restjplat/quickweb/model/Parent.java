package com.restjplat.quickweb.model;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name ="parent")
@Cacheable
public class Parent extends IdEntity {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private List<Children> clist;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "parent")
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	public List<Children> getClist() {
		return clist;
	}
	public void setClist(List<Children> clist) {
		this.clist = clist;
	}
}
