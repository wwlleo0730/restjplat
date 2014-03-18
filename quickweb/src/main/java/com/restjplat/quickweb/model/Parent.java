package com.restjplat.quickweb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="parent")
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
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "parent")
	public List<Children> getClist() {
		return clist;
	}
	public void setClist(List<Children> clist) {
		this.clist = clist;
	}
	
	

}
