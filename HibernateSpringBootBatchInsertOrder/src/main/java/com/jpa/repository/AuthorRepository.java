package com.jpa.repository;

import org.springframework.stereotype.Repository;

import com.jpa.entity.Author1;

@Repository
public interface AuthorRepository extends BatchRepository<Author1, Long>{

}