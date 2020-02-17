package com.jpa.repository.impl;

import org.springframework.stereotype.Repository;

import com.jpa.entity.Author;

@Repository
public class AuthorRepository extends SlicePagingRepositoryImplementation<Author>{

	public AuthorRepository() {
		super(Author.class);
		// TODO Auto-generated constructor stub
	}

}
