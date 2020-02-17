package com.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.jpa.entity.Author;
import com.jpa.repository.impl.AuthorRepository;
import static com.jpa.service.AuthorSpecs.isAgeGt45;

@Service
public class BookstoreService {

	@Autowired
	private AuthorRepository authorRepository;
	
	public Slice<Author> fetchNextSlice(int page, int size) {
		return authorRepository.findAll(isAgeGt45(), PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "age")));
	}
	
}
