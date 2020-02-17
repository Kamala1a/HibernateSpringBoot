package com.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.dto.AuthorDto;
import com.jpa.repository.AuthorRepository;
import com.jpa.service.BookStoreService;

@RestController
public class AuthorController {
	
	@Autowired
	BookStoreService bookStoreService;

	@GetMapping("/fetchAuthors")
	public String fetchAuthors() {
		List<AuthorDto> authors = bookStoreService.fetchAuthors();
		for(AuthorDto author : authors) {
			System.out.println(author.getName());
		}
		return "index";
	}
	
}
