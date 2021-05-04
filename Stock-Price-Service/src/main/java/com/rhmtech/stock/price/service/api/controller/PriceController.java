package com.rhmtech.stock.price.service.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rhmtech.stock.price.service.api.entities.StockPrice;
import com.rhmtech.stock.price.service.api.service.StockService;

@RestController
@RequestMapping("/price")
public class PriceController {
	@Autowired
	private StockService service;

	@PostMapping("/add")
	public ResponseEntity<StockPrice> addnewStock(@RequestBody StockPrice stockPirce) {
		StockPrice addNewStock = service.AddNewStock(stockPirce);
		return new ResponseEntity<StockPrice>(addNewStock, HttpStatus.OK);

	}

	@GetMapping("/stockprice/{cname}")
	public ResponseEntity<StockPrice> findStockPrice(@PathVariable(name = "cname") String cname) {
		StockPrice stock = service.getPriceByName(cname);
		return new ResponseEntity<StockPrice>(stock, HttpStatus.OK);

	}

}
