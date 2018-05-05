package it.reply.dynprice.dynamicpricing.persistence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RulesVariables {
	
	final private static String[] opt_fld_I = {"ALWAYS", "NEVER"};
	
	final private static String[] opt_fld_II = 
		{"SET MARGIN", 
		"SET PRICE", 
		"RANK AT POSITION", 
		"SET PRICE RELATIVE TO", 
		"SET ELASTICITY"};
	
	final private static String[] opt_fld_III = 
		{"COMPETITOR NR. (HIGH TO LOW)", 
		"COMPETITOR NR. (LOW TO HIGH)", 
		"MEDIAN PRICE", 
		"AVERAGE PRICE", 
		"MOST OCCURING PRICE", 
		"CUMMULATIVE SHARE OF MARKET"};
	
	
	final private static String[] opt_fld_V = {">", ">=", "=", "<=", "<"};
	final private static String[] opt_fld_VI= {"+", "-"};
	final private static String[] opt_fld_VIII = {"%", "€", "$"};
	
	/*
	 * The user will have to select the fields in the shown order.
	 * Depending on the input in fld_II, the remaining fields will be disabled or enabled (shown by #):
	 * 	 ____________________________________________________________________________________________
	 * 	|	 value in fld_II	|  fld_III  |  fld_IV  |  fld_V  |  fld_VI  |  fld_VII  |  fld_VIII  |
	 *  |-----------------------|-----------|----------|---------|----------|-----------|------------|
	 *  |      SET MARGIN       | 	        |          |    #	 |          |     #     |     #      |
	 *  |       SET PRICE       | 	        |          |    # 	 |			|     #     |     #      |
	 *  |    RANK AT POSITION   | 	        |    #     |		 |          |           |			 |
	 *  | SET PRICE RELATIVE TO | 	 #      |    #     |	#	 |    #     |     #     |	  #		 |
	 *  |   SET ELASTICITY TO   | 	        |          |	#	 |			|     #     |            | 
	 *  |_______________________|___________|__________|_________|__________|___________|____________|
	 *  
	 *  --> Always enabled: 	fields I and II
	 *  --> changeable: 		fields III, IV, V, VI, VII and VIII
	 *  
	 */
	
	
	private int rank;
	private String fld_I;		// always, never?
	private String fld_II;		// what value?
	private String fld_III;		// what to compare to?
	private int fld_IV;			// rank number (input field)
	private String fld_V;		// operator
	private String fld_VI;		// +/-?
	private int fld_VII;		// value (input field)
	private String fld_VIII;	// unit
	
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getFld_I() {
		return fld_I;
	}
	public void setFld_I(String fld_I) {
		this.fld_I = fld_I;
	}
	public String getFld_II() {
		return fld_II;
	}
	public void setFld_II(String fld_II) {
		this.fld_II = fld_II;
	}
	public String getFld_III() {
		return fld_III;
	}
	public void setFld_III(String fld_III) {
		this.fld_III = fld_III;
	}
	public int getFld_IV() {
		return fld_IV;
	}
	public void setFld_IV(int fld_IV) {
		this.fld_IV = fld_IV;
	}
	public String getFld_V() {
		return fld_V;
	}
	public void setFld_V(String fld_V) {
		this.fld_V = fld_V;
	}
	public String getFld_VI() {
		return fld_VI;
	}
	public void setFld_VI(String fld_VI) {
		this.fld_VI = fld_VI;
	}
	public int getFld_VII() {
		return fld_VII;
	}
	public void setFld_VII(int fld_VII) {
		this.fld_VII = fld_VII;
	}
	public String getFld_VIII() {
		return fld_VIII;
	}
	public void setFld_VIII(String fld_VIII) {
		this.fld_VIII = fld_VIII;
	}
	
	
}
