package com.porter.services;

import java.util.List;
import com.porter.models.Author;


public interface AuthorServices {

	// CRUD Methods
	
	public Author createAuthor(Author a);
	
	
	public List<Author> getAllAuthors();
	
	
	public Author getAuthorById(Integer i);
	
	
	public Author getAuthorByUsername(String username);
	
	
	public boolean updateAuthor(Author aChange);
	
	
	public boolean removeAuthor(Author a);
}
