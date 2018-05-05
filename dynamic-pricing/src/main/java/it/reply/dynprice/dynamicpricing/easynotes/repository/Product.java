package it.reply.dynprice.dynamicpricing.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.reply.dynprice.dynamicpricing.persistence.model.PriceEnitity;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface Product extends JpaRepository<PriceEnitity, Long> {

}
