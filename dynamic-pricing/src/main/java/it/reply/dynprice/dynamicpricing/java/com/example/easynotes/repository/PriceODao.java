package com.example.easynotes.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.example.easynotes.model.PriceVariables;
import org.springframework.data.repository.CrudRepository;




@Transactional
public interface PriceODao extends CrudRepository<PriceVariables, Long> {
	
	List<PriceVariables> findAll();



}

