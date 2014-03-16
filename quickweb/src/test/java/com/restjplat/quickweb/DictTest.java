package com.restjplat.quickweb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.restjplat.quickweb.model.Dict;
import com.restjplat.quickweb.repository.DictDao;
import com.restjplat.quickweb.service.DictService;

public class DictTest extends SpringTransactionalContextTests{
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DictDao dao;
	
	@Autowired
	private DictService daoService;
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	
	@Test
	public void mainTest(){
		
		this.JPACacheNamedCacheTest();
	}
	
	/**
	 * In JPA object identity is maintained within a transaction, 
	 * and (normally) within the same EntityManager. 
	 * The exception is in a JEE managed EntityManager, 
	 * object identity is only maintained inside of a transaction.
	 * 
	 * 跨session的时候，在一级缓存中JPA保存的是两份对象
	 */
	private void jpaCache(){
		
		EntityManager em = emf.createEntityManager();
		
		Dict d1 = em.find(Dict.class, 1); //find id为1的对象
		Dict d2 = em.find(Dict.class, 1); //find id为1的对象
		logger.info((d1==d2)+""); //true
		
		/***************************/
		
		EntityManager em1 = emf.createEntityManager();
		Dict d3 = em1.find(Dict.class, 1); //find id为1的对象
		EntityManager em2 = emf.createEntityManager();
		Dict d4 = em2.find(Dict.class, 1); //find id为1的对象
		
		logger.info((d3==d4)+""); //false
		
	}
	
	/**
	 * 测试一级缓存
	 */
	private void firstCacheTest(){
	
		EntityManager em1 = emf.createEntityManager();
		Dict d1 = em1.find(Dict.class, 1); //find id为1的对象
		Dict d2 = em1.find(Dict.class, 1); //find id为1的对象
		logger.info(d1.getName());
		logger.info(d2.getName());
		em1.close();
		
		/*******
		 * 不开启二级缓存
		 * 
		 *输出： 一条 sql 语句
		 *
		 *证明一级缓存的存活周期为seesion内部
		 * 
		 * **********/
	}
	
	/**
	 * 测试一级缓存是否存在
	 */
	private void firstCacheTest1(){
	
		EntityManager em1 = emf.createEntityManager();
		Dict d1 = em1.find(Dict.class, 1); //find id为1的对象
		logger.info(d1.getName());
		em1.close();
		
		EntityManager em2 = emf.createEntityManager();
		Dict d2 = em2.find(Dict.class, 1); //find id为1的对象
		logger.info(d2.getName());
		em2.close();
		
		/*******
		 * 不开启二级缓存
		 * 
		 *输出： 两条 sql 语句
		 *
		 *证明一级缓存的存活周期为seesion内部
		 * 
		 * **********/
	}
	
	/********************
	 * 二级缓存测试
	 * 
	 * 实体内注释 @cacheable
	 * 
	 * **************************/
	
	private void secondCachetest(){
		
		EntityManager em1 = emf.createEntityManager();
		Dict d1 = em1.find(Dict.class, 1); //find id为1的对象
		logger.info(d1.getName());
		em1.close();
		
		EntityManager em2 = emf.createEntityManager();
		Dict d2 = em2.find(Dict.class, 1); //find id为1的对象
		logger.info(d2.getName());
		em2.close();
	}
	
	
	private void SpringCacheTest(){
		List<Dict> list1 = daoService.getAllDictsWithSpringCache();
		List<Dict> list2 = daoService.getAllDictsWithSpringCache();
		logger.info(list1.toString());
		logger.info(list2.toString());
	}
	
	private void JPACacheTest(){
		List<Dict> list1 = daoService.getAllDictsWithJPACache();
		List<Dict> list2 = daoService.getAllDictsWithJPACache();
		//logger.info(list1.toString());
		//logger.info(list2.toString());
	}
	
	private void JPACacheNamedCacheTest(){
		Dict d1 = daoService.getDictsWithJPACache("a");
		Dict d2 = daoService.getDictsWithJPACache("a");
		logger.info(d1.getName());
		logger.info(d2.getName());
	}

}
