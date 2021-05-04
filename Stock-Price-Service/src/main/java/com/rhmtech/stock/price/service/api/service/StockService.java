package com.rhmtech.stock.price.service.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rhmtech.stock.price.service.api.entities.StockPrice;
import com.rhmtech.stock.price.service.api.repository.StockRepository;

@Service
public class StockService {
	@Autowired
	private StockRepository repository;

	public StockPrice AddNewStock(StockPrice stock) {
		return repository.save(stock);
	}

	public StockPrice getPriceByName(String cname) {

		StockPrice findByCompanyName = repository.findByCompanyName(cname);

		if (findByCompanyName == null) {
			return new StockPrice(0, "Not found", 0.0);
		} else {
			return findByCompanyName;
		}

	}

}
