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

import com.restjplat.quickweb.model.Children;
import com.restjplat.quickweb.model.Dict;
import com.restjplat.quickweb.model.Parent;
import com.restjplat.quickweb.repository.DictDao;
import com.restjplat.quickweb.repository.ParentDao;
import com.restjplat.quickweb.service.DictService;

public class DictTest extends SpringTransactionalContextTests{
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private DictDao dao;
	
	@Autowired
	private ParentDao parentDao;
	
	@Autowired
	private DictService daoService;
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	
	@Test
	public void mainTest(){
		
		this.firstCacheTest();
		this.secondCachetest();
		this.QueryCacheTest();
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
	
	
	private void SimpleJpaRepositoryCacheTest(){
		dao.findAllCached();
		dao.findAllCached();
	}
	
	
	private void QueryCacheTest(){
		//无效的spring-data-jpa实现的接口方法
		//输出两条sql语句
		dao.findAll();
		dao.findAll();
		System.out.println("================test 1 finish======================");
		//自己实现的dao方法可以被查询缓存
		//输出一条sql语句
		dao.findAllCached();
		dao.findAllCached();
		System.out.println("================test 2 finish======================");
		//自己实现的dao方法可以被查询缓存
		//输出一条sql语句
		dao.findDictByName("a");
		dao.findDictByName("a");
		System.out.println("================test 3 finish======================");
	}
	
	private void cellectionCacheTest(){
		EntityManager em1 = emf.createEntityManager();
		Parent p1 = em1.find(Parent.class, 1);
		List<Children> c1 = p1.getClist();
		em1.close();
		System.out.println(p1.getName()+" ");
		for (Children children : c1) {
			System.out.print(children.getName()+",");
		}
		System.out.println();
		EntityManager em2 = emf.createEntityManager();
		Parent p2 = em2.find(Parent.class, 1);
		List<Children> c2 = p2.getClist();
		em2.close();
		System.out.println(p2.getName()+" ");
		for (Children children : c2) {
			System.out.print(children.getName()+",");
		}
		System.out.println();
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
