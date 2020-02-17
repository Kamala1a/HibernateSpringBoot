package com.jpa.n1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.jpa.n1.entity.Book;

@Repository
public interface BookRepositoryFetchModeJoin extends JpaRepository<Book, Long>,
		JpaSpecificationExecutor<Book>{

}
