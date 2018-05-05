package it.reply.dynprice.dynamicpricing.persistence.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.reply.dynprice.dynamicpricing.persistence.dao.PriceODao;

@Service
public class PriceCalc {
	
	@Autowired
	private PriceODao priceODao;
	
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
	
	public double calc_CostsDir() {
		double temp_sum = 0;
		List<PriceO> priceOList = priceODao.findAll();
		
		for (PriceO i : priceOList) {
			temp_sum += i.getCosts_dir_all();
		}
		return temp_sum;//Total Prod Cost
	}
}
