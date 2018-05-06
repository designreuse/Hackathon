package it.reply.dynprice.dynamicpricing.frontend;

public class ChartData {
	
	private String[] labels;
	private Double[] data;
	
	private Double[] amazon;
	private Double[] alibaba;
	private Double[] adjusted;
	
    private double total_revenue;			// Business Indicator										(calculated: qnt_prod * price)
    private double profit_per_unit;			// Business Indicator										(calculated: price - costs_total_unit)
    private double fraction_of_profit;		// Business Indicator	
	
	public String[] getLabels() {
		return labels;
	}
	public void setLabels(String[] labels) {
		this.labels = labels;
	}
	public Double[] getData() {
		return data;
	}
	public void setData(Double[] data) {
		this.data = data;
	}
	public double getTotal_revenue() {
		return total_revenue;
	}
	public void setTotal_revenue(double total_revenue) {
		this.total_revenue = total_revenue;
	}
	public double getProfit_per_unit() {
		return profit_per_unit;
	}
	public void setProfit_per_unit(double profit_per_unit) {
		this.profit_per_unit = profit_per_unit;
	}
	public double getFraction_of_profit() {
		return fraction_of_profit;
	}
	public void setFraction_of_profit(double fraction_of_profit) {
		this.fraction_of_profit = fraction_of_profit;
	}
	public Double[] getAmazon() {
		return amazon;
	}
	public void setAmazon(Double[] amazon) {
		this.amazon = amazon;
	}
	public Double[] getAlibaba() {
		return alibaba;
	}
	public void setAlibaba(Double[] alibaba) {
		this.alibaba = alibaba;
	}
	public Double[] getAdjusted() {
		return adjusted;
	}
	public void setAdjusted(Double[] adjusted) {
		this.adjusted = adjusted;
	}
	
	

}
