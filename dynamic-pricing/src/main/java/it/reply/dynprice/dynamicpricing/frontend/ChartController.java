package it.reply.dynprice.dynamicpricing.frontend;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;





@RestController
public class ChartController {
	
	private static final Logger logger = LoggerFactory.getLogger(ChartController.class);
	
	@RequestMapping(value = "/chart/data", method = RequestMethod.GET, produces = "application/json")
	public String test() {
		
		ChartData dummyChartData = new ChartData();
		
		Gson gson = new Gson();
		
		return gson.toJson(dummyChartData);
		
	}
	
	
	@RequestMapping(value = "/chart/update", method = RequestMethod.POST, produces = "application/json")
	public void update(@RequestBody String body) {
		
		logger.info(body);
		
		//ChartData dummyChartData = new ChartData();
		
		//Gson gson = new Gson();
		
		//return gson.toJson(dummyChartData);
		
	}

}
