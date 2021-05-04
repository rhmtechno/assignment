package com.rhmtech.stock.calculation.service.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhmtech.stock.calculation.service.api.client.PriceClient;
import com.rhmtech.stock.calculation.service.api.model.StockPrice;

@RestController
@RequestMapping("/calc")
public class CalcutationController {
	@Autowired
	private PriceClient client;

	@GetMapping("/calculate/{cname}/{qty}")
	public ResponseEntity<StockPrice> doCalculate(@PathVariable(name = "cname") String cname,
			@PathVariable(name = "qty") double qty) {
		ResponseEntity<StockPrice> invockePrices = client.invockePrice(cname);
		StockPrice stockprice = invockePrices.getBody();
		double getprice = stockprice.getPrice();
		double price = qty * getprice;
		StockPrice dto = new StockPrice();
		dto.setId(stockprice.getId());
		dto.setCompanyName(stockprice.getCompanyName());
		dto.setPrice(price);
		return new ResponseEntity<StockPrice>(dto, HttpStatus.OK);
	}

}
