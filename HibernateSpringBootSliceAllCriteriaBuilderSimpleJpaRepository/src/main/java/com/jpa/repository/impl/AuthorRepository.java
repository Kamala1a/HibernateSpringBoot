package com.jpa.repository.impl;

import org.springframework.stereotype.Repository;

import com.jpa.entity.Author;

@Repository
public class AuthorRepository extends SlicePagingRepositoryImplementation<Author>{

	protected AuthorRepository() {
		super(Author.class);
	}

}
