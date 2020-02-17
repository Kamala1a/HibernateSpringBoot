package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.dto.AuthorDto;
import com.jpa.repository.AuthorRepository;

@Service
public class BookStoreService {

	@Autowired
	private AuthorRepository authorRepository;
	
	public List<AuthorDto> fetchAuthors() {
		return authorRepository.fetchAuthors();
	}
}