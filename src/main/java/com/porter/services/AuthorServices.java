package com.porter.services;

import java.util.List;
import com.porter.models.Author;


public interface AuthorServices {

	// CRUD Methods
	
	public Author createAuthor();
	
	
	public List<Author> getAllAuthors();
	
	
	public Author getAuthorById(Integer i);
	
	
	public Author updateAuthor(Integer i);
	
	
	public boolean removeAuthor();
}
