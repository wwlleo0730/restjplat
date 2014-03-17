package com.restjplat.quickweb;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.hibernate.stat.SecondLevelCacheStatistics;
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
		this.showCacheStatisticsInfo();
	}
	
	/**
	 * 测试一级缓存
	 */
	private void firstCacheTest(){	
		EntityManager em = emf.createEntityManager();
		Dict d1 = em.find(Dict.class, 1); //find id为1的对象
		Dict d2 = em.find(Dict.class, 1); //find id为1的对象
		logger.info((d1==d2)+""); //true
		em.close();
	
		EntityManager em1 = emf.createEntityManager();
		Dict d3 = em1.find(Dict.class, 1); //find id为1的对象
		EntityManager em2 = emf.createEntityManager();
		Dict d4 = em2.find(Dict.class, 1); //find id为1的对象
		logger.info((d3==d4)+""); //false
		em1.close();
		em2.close();
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
		System.out.println(d1.getName());
		em1.close();
		EntityManager em2 = emf.createEntityManager();
		Dict d2 = em2.find(Dict.class, 1); //find id为1的对象
		System.out.println(d2.getName());
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
	}
	
	private void JPACacheNamedCacheTest(){
		Dict d1 = daoService.getDictsWithJPACache("a");
		Dict d2 = daoService.getDictsWithJPACache("b");
	}
	
	
	/**
	 * 显示二级缓存和查询缓存的数据
	 */
	private void showCacheStatisticsInfo(){
		System.out.println("===================L2======================");
		SessionFactory sf = ((HibernateEntityManagerFactory)emf).getSessionFactory();
		String[] k = sf.getStatistics().getSecondLevelCacheRegionNames();
		for (String string : k) {
			SecondLevelCacheStatistics ss = 
					sf.getStatistics().getSecondLevelCacheStatistics(string);
			System.out.println(string+" : "+ss.getPutCount());
		}
		System.out.println("=================query cache=================");
		String[] querys = sf.getStatistics().getQueries();
		for (String string : querys) {
			System.out.println(string);
		}
	}

}
