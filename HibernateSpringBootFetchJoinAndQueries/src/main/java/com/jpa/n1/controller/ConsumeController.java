package com.jpa.n1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ConsumeController {

	
	@RequestMapping("/testt")
	private String getEmployees()
	{
	    final String uri = "http://localhost:8080/fetchByGenre/Anthology";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	     
	    System.out.println(result);
	    
	    return "index";
	}
	
}
