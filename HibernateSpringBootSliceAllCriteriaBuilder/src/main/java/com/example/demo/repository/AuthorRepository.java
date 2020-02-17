package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Author;
import com.example.demo.repository.impl.SlicePagingRepositoryImplementation;

@Repository
public class AuthorRepository extends SlicePagingRepositoryImplementation<Author>{

	public AuthorRepository() {
		super(Author.class);
	}
	
}
