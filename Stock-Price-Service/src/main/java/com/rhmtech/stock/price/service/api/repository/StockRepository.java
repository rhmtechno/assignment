package com.rhmtech.stock.price.service.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rhmtech.stock.price.service.api.entities.StockPrice;
@Repository
public interface StockRepository extends JpaRepository<StockPrice, Long> {

	StockPrice findByCompanyName(String cname);

}
