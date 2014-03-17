package com.restjplat.quickweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.restjplat.quickweb.model.Dict;
import com.restjplat.quickweb.repository.DictDao;

@Service
public class DictService {

	@Autowired
	private DictDao dictDao;
	
	public Dict findDictById(int id){
		return dictDao.findOne(id);
	}
	
	@Cacheable(value = "sysCache")
	public List<Dict> getAllDictsWithSpringCache(){
		System.out.println("in getAllDictsWithSpringCache");
		return dictDao.findAll();
	}
	
	public List<Dict> getAllDictsWithJPACache(){
		System.out.println("in getAllDictsWithJPACache");
		return dictDao.findAllCached();
	}
	
	public Dict getDictsWithJPACache(String name){
		System.out.println("in getDictsWithJPACache");
		return dictDao.findDictByName(name);
	}
	
	
}
