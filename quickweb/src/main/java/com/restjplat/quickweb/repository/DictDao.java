package com.restjplat.quickweb.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.restjplat.quickweb.model.Dict;

public interface DictDao extends JpaRepository<Dict, Integer>,JpaSpecificationExecutor<Dict>{
	
	@Query("from Dict")
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Dict> findAllCached();
	
	/*@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Dict findByName(String name);*/
	
	@Query("select t from Dict t where t.name = ?1")
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Dict findDictByName(String name);
}
