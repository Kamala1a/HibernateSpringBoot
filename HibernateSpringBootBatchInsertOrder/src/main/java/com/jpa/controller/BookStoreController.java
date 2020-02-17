package com.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.service.BookstoreService;

@RestController
public class BookStoreController {

	@Autowired
	private BookstoreService bookStoreService;
	
	@GetMapping("/batch")
	private String batch() {
		return "Success";
	}
	
}
