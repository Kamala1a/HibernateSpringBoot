package com.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.dto.AuthorDto;
import com.jpa.entity.Author;
import com.jpa.repository.AuthorRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Service
public class BookstoreService {

	@Autowired
	private  AuthorRepository authorRepository;
	
	@Transactional
	public void createAuthors() throws IOException {
		Author mt = new Author();
		 mt.setId(1L);
	        mt.setName("Martin Ticher");
	        mt.setAge(43);
	        mt.setGenre("Horror");
	        mt.setAvatar(Files.readAllBytes(new File("D:\\avatars\\mt.png").toPath()));

	        Author cd = new Author();
	        cd.setId(2L);
	        cd.setName("Carla Donnoti");
	        cd.setAge(31);
	        cd.setGenre("Science Fiction");
	        cd.setAvatar(Files.readAllBytes(new File("D:\\avatars\\cd.png").toPath()));

	        Author re = new Author();
	        re.setId(3L);
	        re.setName("Rennata Elibol");
	        re.setAge(46);
	        re.setGenre("Fantasy");
	        re.setAvatar(Files.readAllBytes(new File("D:\\avatars\\re.png").toPath()));

	        authorRepository.save(mt);
	        authorRepository.save(cd);
	        authorRepository.save(re);
	}
	
	
	public List<Author> fetchAuthorsByAgeGreaterThanEqual(int age) {
		List<Author> authors = authorRepository.findByAgeGreaterThanEqual(age);
		authors.forEach(author -> System.out.println(author.getName()));
		return authors;
	}
	
	public List<AuthorDto> fetchAuthorsWithAvatarsByAgeGreaterThanEqual(int age) {
		List<AuthorDto> authors = authorRepository.findDtoByAgeGreaterThanEqual(age);
		authors.forEach(author -> System.out.println(author.getName()));
		authors.forEach(author -> System.out.println(author.getAvatar()));
		return authors;
	}
}
