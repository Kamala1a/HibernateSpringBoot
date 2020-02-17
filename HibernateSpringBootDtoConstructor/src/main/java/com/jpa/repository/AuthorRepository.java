package com.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.dto.AuthorDto;
import com.jpa.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

	@Transactional(readOnly = true)
	List<AuthorDto> findByGenre(String genre);
	
}
