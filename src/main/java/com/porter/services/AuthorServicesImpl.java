package com.porter.services;

import java.util.List;

import com.porter.daos.AuthorDAO;
import com.porter.daos.AuthorDAOImpl;
import com.porter.models.Author;

public class AuthorServicesImpl implements AuthorServices {

	
	private AuthorDAO adao = new AuthorDAOImpl();
	
	
	@Override
	public Author createAuthor(Author a) {			
		return adao.createAuthor(a);
	}

	@Override
	public List<Author> getAllAuthors() {
		return adao.getAllAuthors();
	}

	@Override
	public Author getAuthorById(Integer i) {
		return adao.getAuthorById(i);
	}

	@Override
	public boolean updateAuthor(Author aChange) {
		return adao.updateAuthor(aChange);
	}

	@Override
	public boolean removeAuthor(Author a) {
		return adao.removeAuthor(a);
	}

	@Override
	public Author getAuthorByUsername(String username) {
		return adao.getAuthorByUsername(username);
	}

}
