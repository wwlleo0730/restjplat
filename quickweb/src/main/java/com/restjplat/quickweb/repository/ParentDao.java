package com.restjplat.quickweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.restjplat.quickweb.model.Dict;
import com.restjplat.quickweb.model.Parent;

@Repository
public interface ParentDao extends JpaRepository<Parent, Integer>,JpaSpecificationExecutor<Parent>{

}
