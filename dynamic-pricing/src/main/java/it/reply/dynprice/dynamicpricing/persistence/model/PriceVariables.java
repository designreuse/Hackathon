package it.reply.dynprice.dynamicpricing.persistence.model;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PriceVariables {


    private Long id;                        // product ID 												(input / generated ???)
    private String prod_name;                // product name 											(input)
    private double qnt_prod;                // quantity of units produced of this item 					(input)
    private double costs_dir_unit;            // direct production costs of one single unit of this item 	(input)
    private double costs_dir_all;            // total direct production costs of all units of this item 	(calculated: qnt_prod * costs_dir_unit)
    private double costs_op_unit;            // share of operational costs broken down for one unit 		(calculated: costs_op_to_dir * costs_dir_unit)
    private double costs_total_unit;        // total costs of one unit 									(calculated: costs_dir_unit + costs_op_unit)
    private double margin;                    // margin to add to the costs 								(input)
    private double price;                    // selling price 											(calculated: costs_total_unit * (1 + margin))

    private static double costs_op;            // total operational costs of the company 					(input)
    private static double costs_dir;        // total direct production costs 							(calculated: sum(PriceO_instances.costs_dir_all))
    private static double costs_op_to_dir;    // share of operational costs per 1€ of production costs 	(calculated: costs_op / costs_dir)

    /*
     * We got to think of the time frames:
     *
     * Are we going to gather the data per month? or per year?
     * Every of the following values needs to be adapted to that time frame:
     *   -> qnt_prod
     *   -> costs_op
     *
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public double getQnt_prod() {
        return qnt_prod;
    }

    public void setQnt_prod(int qnt_prod) {
        this.qnt_prod = qnt_prod;
    }

    public double getCosts_dir_unit() {
        return costs_dir_unit;
    }

    public void setCosts_dir_unit(double costs_dir_unit) {
        this.costs_dir_unit = costs_dir_unit;
    }

    public double getCosts_dir_all() {
        return costs_dir_all;
    }

    public void setCosts_dir_all(double costs_dir_all) {
        this.costs_dir_all = costs_dir_all;
    }

    public double getCosts_op_unit() {
        return costs_op_unit;
    }

    public void setCosts_op_unit(double costs_op_unit) {
        this.costs_op_unit = costs_op_unit;
    }

    public double getCosts_total_unit() {
        return costs_total_unit;
    }

    public void setCosts_total_unit(double costs_total_unit) {
        this.costs_total_unit = costs_total_unit;
    }

    public double getMargin() {
        return margin;
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static double getCosts_op() {
        return costs_op;
    }

    public static void setCosts_op(double costs_op) {
        PriceVariables.costs_op = costs_op;
    }

    public static double getCosts_dir() {
        return costs_dir;
    }

    public static void setCosts_dir(double costs_dir) {
        PriceVariables.costs_dir = costs_dir;
    }

    public static double getCosts_op_to_dir() {
        return costs_op_to_dir;
    }

    public static void setCosts_op_to_dir(double costs_op_to_dir) {
        PriceVariables.costs_op_to_dir = costs_op_to_dir;
    }

    public void setId(Long id) {
        this.id = id;
    }
}




