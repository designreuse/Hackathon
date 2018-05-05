package it.reply.dynprice.dynamicpricing.frontend;



import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import it.reply.dynprice.dynamicpricing.controller.PriceCalcController;
import it.reply.dynprice.dynamicpricing.persistence.dao.PriceDao;
import it.reply.dynprice.dynamicpricing.persistence.model.PriceEntity;
import it.reply.dynprice.dynamicpricing.persistence.model.PriceVariables;







@RestController
public class ChartController {
	
	private static final Logger logger = LoggerFactory.getLogger(ChartController.class);
	
	@Autowired
	private PriceDao priceDao;
	
	@Autowired
	PriceCalcController priceCalcController;
	
	@RequestMapping(value = "/chart/data", method = RequestMethod.GET, produces = "application/json")
	public String test() {
		
		List<PriceEntity> priceDataList = this.priceDao.findAll();
		
		ChartData dummyChartData = new ChartData();
		
		priceDataList.sort(new PriceDataComparator());
		
		List<Double> dataList = new ArrayList<Double>();
		List<String> labelsList = new ArrayList<String>();
		
		for(PriceEntity priceEntity : priceDataList) {
			
			dataList.add(priceEntity.getPrice());
			labelsList.add(priceEntity.getUpdated().toString());			
		}
		
		String[] labelsArr = new String[labelsList.size()];
		labelsArr = labelsList.toArray(labelsArr);
		
		Double[] dataArr = new Double[dataList.size()];
		dataArr = dataList.toArray(dataArr);
		
		dummyChartData.setData(dataArr);
		dummyChartData.setLabels(labelsArr);
		
		
		Gson gson = new Gson();
		
		return gson.toJson(dummyChartData);
		
	}
	
	
	@RequestMapping(value = "/chart/update", method = RequestMethod.POST, produces = "application/json")
	public void update(@RequestBody String body) {
		
		logger.info(body);
		
		Gson gson = new Gson(); 
		
		AlgorithmInputData inputData = gson.fromJson(body, AlgorithmInputData.class);
		
		PriceVariables priceVariables = new PriceVariables();
		
		priceVariables.setMargin(inputData.getImargin());
		priceVariables.setCosts_dir_unit(inputData.getIcostu());
		priceVariables.setQnt_prod(inputData.getIastock());
		
		this.priceCalcController.calc_main(priceVariables);
		
		//ChartData dummyChartData = new ChartData();
		
		//Gson gson = new Gson();
		
		//return gson.toJson(dummyChartData);
		
	}

}
