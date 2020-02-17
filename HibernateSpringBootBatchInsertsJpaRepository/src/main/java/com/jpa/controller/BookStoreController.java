package com.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.service.BookStoreService;

@RestController
public class BookStoreController {

	@Autowired
	BookStoreService bookStoreService;
	
	@GetMapping(value = "/batchAuthors")
	public String saveBatch() {
		bookStoreService.batchAuthors();
		return "Success";
	}
	
	@GetMapping(value = "/batchAuthors1")
	public String batchAuthors1() {
		bookStoreService.batchAuthors1();
		return "Success";
	}
	
	@GetMapping(value = "/saveInBatchUsingSessionPerTransaction")
	public String saveInBatchUsingSessionPerTransaction() {
		bookStoreService.saveInBatchUsingSessionPerTransaction();
		return "Success HI";
	}
	
}
