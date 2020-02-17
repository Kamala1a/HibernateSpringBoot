package com.jpa.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.service.BookstoreService;

@RestController
public class BookStoreController {

	@Autowired
	BookstoreService bookStoreService;
	
	
	@GetMapping("/createAuthors/")
	public void createAuthors() throws IOException {
		bookStoreService.createAuthors();
	}
	
	@GetMapping("/fetchAuthorsByAgeGreaterThanEqual/{age}")
	public void fetchAuthorsByAgeGreaterThanEqual(@PathVariable int age) {
		bookStoreService.fetchAuthorsByAgeGreaterThanEqual(age);
	}
	
	@GetMapping("/fetchAuthorsWithAvatarsByAgeGreaterThanEqual/{age}")
	public void fetchAuthorsWithAvatarsByAgeGreaterThanEqual(@PathVariable int age) {
		bookStoreService.fetchAuthorsWithAvatarsByAgeGreaterThanEqual(age);
	}
	
}
