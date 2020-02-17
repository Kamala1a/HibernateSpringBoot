package com.jpa.n1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.n1.service.BookstoreService;

@RestController
public class BookStoreController {
	
	@Autowired
	BookstoreService bookStoreService;

	@GetMapping("/nplusOne")
	public String nplusOne() {
		bookStoreService.displayBooksCausingNPlus1();
		return "Success";
	}
	
	
	@GetMapping("/WOnplusOne")
	public String wonplusOne() {
		bookStoreService.displayBooksWithOutNPlus1();
		return "Success";
	}
	
	
	@GetMapping("/findByIdWON1/{id}")
	public String findByIdWON1(@PathVariable Long id) {
		bookStoreService.displayFindByIdWON1(id);
		return "success";
	}
	
	@GetMapping("/findByIdN1/{id}")
	public String findByIdN1(@PathVariable Long id) {
		bookStoreService.displayFindByIdN1(id);
		return "success";
	}
	
	@GetMapping("/findAllWithSpec1")
	public String findAllWithSpec1() {
		bookStoreService.findAllJoinFetchWithSpec();
		return "success";
	}
}