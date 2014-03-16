package com.restjplat.quickweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.restjplat.quickweb.model.Dict;

public interface DictDao extends JpaRepository<Dict, Integer>,JpaSpecificationExecutor<Dict>{

}
