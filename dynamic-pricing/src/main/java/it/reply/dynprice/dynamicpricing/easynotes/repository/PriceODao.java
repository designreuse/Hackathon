package it.reply.dynprice.dynamicpricing.easynotes.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import it.reply.dynprice.dynamicpricing.persistence.model.PriceVariables;




@Transactional
public interface PriceODao extends CrudRepository<PriceVariables, Long> {
	
	List<PriceVariables> findAll();



}

