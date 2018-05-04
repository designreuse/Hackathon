package it.reply.dynprice.dynamicpricing.frontend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChartController {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	public String test() {
		
		return "{test}";
		
	}

}
