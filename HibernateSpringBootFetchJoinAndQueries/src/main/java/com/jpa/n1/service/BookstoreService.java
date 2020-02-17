package com.jpa.n1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.n1.entity.Book;
import static com.jpa.n1.specs.BookSpecs.isPriceGt35;
import com.jpa.n1.repository.BookRepositoryFetchModeJoin;
import com.jpa.n1.repository.BookRepositoryJoinFetch;

@Service
public class BookstoreService {

	@Autowired
	BookRepositoryFetchModeJoin bookRepositoryFetchModeJoin;

	@Autowired
	BookRepositoryJoinFetch bookRepositoryJoinFetch;
	
	public void displayBooksCausingNPlus1() { // N + 1 Problem
		Long startTime = System.currentTimeMillis();
		List<Book> books = bookRepositoryFetchModeJoin.findAll();
		Long endTime = System.currentTimeMillis();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> " + (endTime - startTime));
		displayBooks(books);
	}
	
	public void displayBooksWithOutNPlus1() {
		Long startTime = System.currentTimeMillis();
		List<Book> books = bookRepositoryJoinFetch.findAll();
		Long endTime = System.currentTimeMillis();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>> " + (endTime - startTime));
		displayBooks(books);
	}
	
	public void displayBooks(List<Book> books) {
		for(Book book : books) {
			System.out.println(book);
            System.out.println(book.getAuthor());
            System.out.println(book.getAuthor().getPublisher() + "\n");
		}
	}
	
	public void displayBooks(Optional<Book> book) {
		
		System.out.println(book.get().getAuthor().getPublisher().getCompany());
	}

	public void displayFindByIdWON1(Long id) {
		Optional<Book> book = bookRepositoryJoinFetch.findById(id);
		displayBooks(book);
	}

	public void displayFindByIdN1(Long id) {
		Optional<Book> book = bookRepositoryFetchModeJoin.findById(id);
		displayBooks(book);
	}
	
	public void findAllJoinFetchWithSpec() {
		List<Book> books = bookRepositoryFetchModeJoin.findAll(isPriceGt35());
		displayBooks(books);
	}
}
