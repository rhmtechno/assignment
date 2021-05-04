package com.rhmtech.stock.calculation.service.api.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rhmtech.stock.calculation.service.api.model.StockPrice;

@FeignClient(name = "STOCK-PRICE-SERVICE")
public interface PriceClient {
	@GetMapping(value = "/price/stockprice/{cname}")
	public ResponseEntity<StockPrice> invockePrice(@PathVariable("cname") String cname);

}
