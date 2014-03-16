package com.restjplat.quickweb.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.restjplat.quickweb.model.Dict;

public interface DictDao extends JpaRepository<Dict, Integer>,JpaSpecificationExecutor<Dict>{

	
	/**
	 * org.hibernate.timeout	Query timeout in seconds ( eg. new Integer(10) )
	   org.hibernate.fetchSize	Number of rows fetched by the JDBC driver per roundtrip ( eg. new Integer(50) )
       org.hibernate.comment	Add a comment to the SQL query, useful for the DBA ( e.g. new String("fetch all orders in 1 statement") )
       org.hibernate.cacheable	Whether or not a query is cacheable ( eg. new Boolean(true) ), defaults to false
       org.hibernate.cacheMode	Override the cache mode for this query ( eg. CacheMode.REFRESH )
       org.hibernate.cacheRegion	Cache region of this query ( eg. new String("regionName") )
       org.hibernate.readOnly	Entities retrieved by this query will be loaded in a read-only mode where Hibernate will never dirty-check them or make changes persistent ( eg. new Boolean(true) ), default to false
       org.hibernate.flushMode	Flush mode used for this query (useful to pass Hibernate specific flush modes, in particular MANUAL).
       org.hibernate.cacheMode	Cache mode used for this query
	 */
	
	@Query("from Dict")
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	List<Dict> findAllCached();
	
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	Dict findByName(String name);
}
