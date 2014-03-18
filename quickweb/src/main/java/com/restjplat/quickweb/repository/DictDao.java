package com.restjplat.quickweb.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import com.restjplat.quickweb.model.Dict;

@Repository
public interface DictDao extends JpaRepository<Dict, Integer>,JpaSpecificationExecutor<Dict>{
	
	// spring-data-jpa默认继承实现的一些方法，实现类为
	// SimpleJpaRepository。
	// 该类中的方法不能通过@QueryHint来实现查询缓存。
	//@QueryHints({ @QueryHint(name = "javax.persistence.query.timeout", value ="1100000") })
	List<Dict> findAll();
	
	@Query("from Dict")
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Dict> findAllCached();
	
	@Query("select t from Dict t where t.name = ?1")
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Dict findDictByName(String name);
}
