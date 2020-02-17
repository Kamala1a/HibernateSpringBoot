package com.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.service.BookStoreService;

@RestController
public class BookStoreController {
	
	@Autowired
	private BookStoreService bookStoreService;

	@GetMapping("saveInBatch")
	public String saveInBatch() {
		bookStoreService.batchAuthors();
		return "Success";
	}
	
}