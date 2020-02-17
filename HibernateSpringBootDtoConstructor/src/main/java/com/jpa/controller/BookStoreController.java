package com.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.dto.AuthorDto;
import com.jpa.service.BookStoreService;

@RestController
public class BookStoreController {

	@Autowired
	private BookStoreService bookStoreService;
	
	@GetMapping("/fetchByGenre/{genre}") 
	public List<AuthorDto> fetchByGenre(@PathVariable String genre) {
		List<AuthorDto> authors = bookStoreService.fetchByGenre(genre);
		return authors;
	}
	
}
