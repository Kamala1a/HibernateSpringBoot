package com.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.entity.Author1;
import com.jpa.entity.Book1;
import com.jpa.repository.AuthorRepository;
import com.jpa.repository.BatchRepositoryImpl;

@Service
public class BookstoreService {

	@Autowired
	private BatchRepositoryImpl authorRepository;

	
	public void batchAuthorsAndBooks() {
	
		List<Author1> authors = new ArrayList<Author1>();
		
		int pk = 0;
		
		for(int i = 0; i < 40; i++) {
		
			Author1 author = new Author1();
			author.setId((long) i + 1);
			author.setName("Name_"+i);
			author.setGenre("Genre_"+i);
			author.setAge(18 + i);
			
			for(int j = 0; j < 5; j++) {
				
				Book1 book = new Book1();
				book.setId(++pk);
				book.setTitle("Title: " + i);
				book.setIsbn("ISBN: " + i);
				
				author.addBook(book);
			}
			
			authors.add(author);
		}
	
		authorRepository.saveInBatch(authors);
	}
	
}