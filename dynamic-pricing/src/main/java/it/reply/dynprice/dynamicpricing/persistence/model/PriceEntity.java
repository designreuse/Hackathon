package it.reply.dynprice.dynamicpricing.persistence.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PriceEntity {
	
	private Long id;
	private Double price;
	private Date updated;
	
    private Double total_revenue;			// Business Indicator										(calculated: qnt_prod * price)
    private Double profit_per_unit;			// Business Indicator										(calculated: price - costs_total_unit)
    private Double fraction_of_profit;		// Business Indicator	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTotal_revenue() {
		return total_revenue;
	}

	public void setTotal_revenue(Double total_revenue) {
		this.total_revenue = total_revenue;
	}

	public Double getFraction_of_profit() {
		return fraction_of_profit;
	}

	public void setFraction_of_profit(Double fraction_of_profit) {
		this.fraction_of_profit = fraction_of_profit;
	}

	public Double getProfit_per_unit() {
		return profit_per_unit;
	}

	public void setProfit_per_unit(Double profit_per_unit) {
		this.profit_per_unit = profit_per_unit;
	}
	
	
	
	

}
