package it.reply.dynprice.dynamicpricing.frontend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
public class ChartController {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	public String test() {
		
		ChartData dummyChartData = new ChartData();
		
		Gson gson = new Gson();
		
		return gson.toJson(dummyChartData);
		
	}

}
