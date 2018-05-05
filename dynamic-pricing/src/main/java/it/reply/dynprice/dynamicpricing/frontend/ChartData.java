package it.reply.dynprice.dynamicpricing.frontend;

public class ChartData {
	
	private String[] labels = {"13.00", "14.00", "15.00", "16.00", "17.00", "18.00"};
	private Double[] data = {10.0, 20.0, 30.0, 40.0, 50.0, 60.0};
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
	
	

}
