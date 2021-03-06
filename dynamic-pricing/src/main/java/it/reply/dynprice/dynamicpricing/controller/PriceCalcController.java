package it.reply.dynprice.dynamicpricing.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.reply.dynprice.dynamicpricing.easynotes.repository.PriceEntityCompetitorDao;
import it.reply.dynprice.dynamicpricing.persistence.dao.PriceDao;
import it.reply.dynprice.dynamicpricing.persistence.model.PriceEntity;
import it.reply.dynprice.dynamicpricing.persistence.model.PriceEntityCompetitor;
import it.reply.dynprice.dynamicpricing.persistence.model.PriceVariables;


@Service
public class PriceCalcController {

    
    @Autowired
    PriceDao priceDao;
    
    @Autowired
    PriceEntityCompetitorDao priceEntityCompetitorDao;

    Date Test;
    
    public double calc_CostsDirAll(double qnt_prod, double costs_dir_unit) {
        return qnt_prod * costs_dir_unit;//Total Pro Cost of Item
    }

    public double calc_CostsOpUnit(double costs_op_to_dir, double costs_dir_unit) {
        return costs_op_to_dir * costs_dir_unit;//Op Cost of Unit
    }

    public double calc_CostsTotalUnit(double costs_dir_unit, double costs_op_unit) {
        return costs_dir_unit + costs_op_unit;//Total cost of Unit
    }

    public double calc_Price(double costs_total_unit, double margin) {
        return costs_total_unit * (1 + margin);//Price
    }

    public double calc_CostsOpToDir(double costs_op, double costs_total) {
        return costs_op / costs_total;//OP cost per Euro of Production
    }

    public double calc_TotalRevenue(double qnt_prod, double price) {
        return qnt_prod * price;//Total Revenue
    }

    public double calc_ProfitPerUnit(double price, double costs_total_unit) {
        return price - costs_total_unit;//Profit per unit
    }

    public double calc_FractionOfProfit(double profit_per_unit, double qnt_prod, double total_profit) {
        return profit_per_unit * qnt_prod / total_profit;//Profit compared to total profit of company
    }
    
    public void calc_Comp(PriceVariables amazon, PriceVariables alibaba, PriceVariables unieuro) {
    	//amazon.setPrice(amazon.getPrice()*(0.975 + Math.random() * 0.05));
    	//alibaba.setPrice(alibaba.getPrice()*(0.965 + Math.random() * 0.07));
    	//unieuro.setPrice(unieuro.getPrice()*(0.95 + Math.random() * 0.1));
    	
    	// double amazonPrice = alibaba.getPrice()*(0.975 + Math.random() * 0.05);
    	
    	double amazonPrice = 364*(0.975 + Math.random() * 0.05);
    	
    	PriceEntityCompetitor am = new PriceEntityCompetitor();
    	am.setName("Amazon");
    	am.setPrice(Math.round(amazonPrice * 100.0) / 100.0);
    	am.setUpdated(Test);
    	priceEntityCompetitorDao.save(am);

    	// double alibabaPrice = alibaba.getPrice()*(0.965 + Math.random() * 0.07);
    	
    	double alibabaPrice = 360*(0.965 + Math.random() * 0.07);
    	
    	PriceEntityCompetitor al = new PriceEntityCompetitor();
    	al.setName("Alibaba");
    	al.setPrice(Math.round(alibabaPrice * 100.0) / 100.0);
    	al.setUpdated(Test);
    	priceEntityCompetitorDao.save(al);
    	

    	double maxPrice = 400;
    	double minPrice = amazon.getCosts_total_unit()*1.1;
    	
    	if (Math.max(alibabaPrice, amazonPrice) < maxPrice) {
    		maxPrice = Math.max(alibabaPrice, amazonPrice);
    	}
    	
    	if (Math.min(alibabaPrice, amazonPrice) > minPrice) {
    		minPrice = Math.min(alibabaPrice, amazonPrice);
    	}
    	
    	if (amazon.getPrice() * 1.025 < maxPrice) {
    		maxPrice = amazon.getPrice() * 1.025;
    	}
    	
    	if (amazon.getPrice() * 0.975 > minPrice) {
    		minPrice = amazon.getPrice() * 0.975;
    	}
    	
    	double adjustedPrice = (minPrice + maxPrice) / 2; //Math.random()*(maxPrice-minPrice)+minPrice;
    	
    	
    	PriceEntityCompetitor un = new PriceEntityCompetitor();
    	un.setName("Adjusted");
    	un.setPrice(Math.round(adjustedPrice * 100.0) / 100.0);
    	un.setUpdated(Test);
    	priceEntityCompetitorDao.save(un);
    }
    
    
    public void calc_main(PriceVariables priceVariables) {
    	priceVariables.setCosts_op_to_dir(this.calc_CostsOpToDir(priceVariables.getCosts_op(), priceVariables.getCosts_dir()));
    	priceVariables.setCosts_dir_all(this.calc_CostsDirAll(priceVariables.getQnt_prod(), priceVariables.getCosts_dir_unit()));
    	priceVariables.setCosts_op_unit(this.calc_CostsOpUnit(priceVariables.getCosts_op_to_dir(), priceVariables.getCosts_dir_unit()));
    	priceVariables.setCosts_total_unit(this.calc_CostsTotalUnit(priceVariables.getCosts_dir_unit(), priceVariables.getCosts_op_unit()));
    	priceVariables.setPrice(this.calc_Price(priceVariables.getCosts_total_unit(), priceVariables.getMargin()));
    	priceVariables.setTotal_revenue(this.calc_TotalRevenue(priceVariables.getQnt_prod(), priceVariables.getPrice()));
    	priceVariables.setProfit_per_unit(this.calc_ProfitPerUnit(priceVariables.getPrice(), priceVariables.getCosts_total_unit()));
    	priceVariables.setFraction_of_profit(this.calc_FractionOfProfit(priceVariables.getProfit_per_unit(), priceVariables.getQnt_prod(), priceVariables.getTotal_profit()));
    	
    	PriceEntity pe = new PriceEntity();
    	
    	pe.setPrice(Math.round(priceVariables.getPrice() * 100.0) / 100.0);
    	Test = new Date();
    	pe.setUpdated(Test);
    	
    	pe.setProfit_per_unit(Math.round(priceVariables.getProfit_per_unit() * 100.0) / 100.0);
    	pe.setTotal_revenue(Math.round(priceVariables.getTotal_revenue() * 100.0) / 100.0);
    	pe.setFraction_of_profit(Math.round(priceVariables.getFraction_of_profit() * 1000.0) / 1000.0);
    	
    	priceDao.save(pe);	
    	
    	this.calc_Comp(priceVariables, priceVariables, priceVariables);
    }
    
}
