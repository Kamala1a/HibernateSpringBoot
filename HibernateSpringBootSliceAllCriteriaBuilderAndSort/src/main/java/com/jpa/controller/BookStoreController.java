package com.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jpa.entity.Author;
import com.jpa.service.BookStoreService;

@RestController
public class BookStoreController {

	@Autowired
	private BookStoreService bookStoreService;
	
	@GetMapping("/authors/{page}/{size}")
	public Slice<Author> fetchAuthors(@PathVariable int page, @PathVariable int size) {
		Slice<Author> authors = bookStoreService.fetchNextSlice(page, size);
		return authors;
	}
	
}
