package it.reply.dynprice.dynamicpricing.persistence.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import it.reply.dynprice.dynamicpricing.persistence.model.PriceO;



@Transactional
public interface PriceODao extends CrudRepository<PriceO, Long> {
	
	List<PriceO> findAll();



}

