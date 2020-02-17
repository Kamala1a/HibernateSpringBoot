package com.jpa.service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.jpa.entity.Author;

public class AuthorSpecs {

	private static final int AGE = 45;
	
	public static Specification<Author> isAgeGt45() { 
		return (Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) 
				-> criteriaBuilder.greaterThan(root.get("age"), AGE);
				
	}
	
}
