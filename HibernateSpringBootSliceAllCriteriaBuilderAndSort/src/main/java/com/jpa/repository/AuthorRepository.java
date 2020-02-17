package com.jpa.repository;

import org.springframework.stereotype.Repository;

import com.jpa.entity.Author;
import com.jpa.repository.impl.SlicePagingRepositoryImplementation;

@Repository
public class AuthorRepository extends SlicePagingRepositoryImplementation<Author>{

	public AuthorRepository() {
		super(Author.class);
	}

}