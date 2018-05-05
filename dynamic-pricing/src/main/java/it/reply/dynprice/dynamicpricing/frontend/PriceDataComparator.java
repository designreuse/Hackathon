package it.reply.dynprice.dynamicpricing.frontend;

import java.util.Comparator;

import it.reply.dynprice.dynamicpricing.persistence.model.PriceEntity;

public class PriceDataComparator implements Comparator<PriceEntity> {
	

		  @Override
		  public int compare(PriceEntity x, PriceEntity y) {
			   return x.getId() < y.getId() ? -1
				         : x.getId() > y.getId() ? 1
				         : 0;
		  }

		

}
