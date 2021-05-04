package com.rhmtech.ui.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.rhmtech.ui.api.dto.StockPrice;
import com.rhmtech.ui.api.dto.UiDto;

@Controller
public class UiController {
	@Autowired
	private RestTemplate template;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@PostMapping("/docalc")
	public String doCalc(UiDto dto,Model model) {
		StockPrice restCall = restCall(dto.getCname(),dto.getQuan());
		model.addAttribute("totalprice", restCall.getPrice());
		model.addAttribute("cname", restCall.getCompanyName());
		return "result";
	}

	private StockPrice restCall(String cname,String quan) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Content-Type", "application/json");
		HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
		ResponseEntity<StockPrice> exchange = template.exchange("http://localhost:4444/api/calculation/calculate/"+cname+"/"+quan+"", HttpMethod.GET, entity, StockPrice.class);
		StockPrice body = exchange.getBody();
		return body;
	}

}
