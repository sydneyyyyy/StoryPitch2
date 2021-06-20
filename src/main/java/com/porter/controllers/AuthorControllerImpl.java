package com.porter.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.porter.models.Author;
import com.porter.services.AuthorServices;
import com.porter.services.AuthorServicesImpl;



public class AuthorControllerImpl implements AuthorController {

	
	private AuthorServices as = new AuthorServicesImpl();
	private static Gson gson = new Gson();
	
	
	@Override
	public void createAuthor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Author a = gson.fromJson(request.getReader(), Author.class);
		as.createAuthor(a);
		response.getWriter().append(gson.toJson(a));

	}

	@Override
	public void getAllAuthors(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		List<Author> authors = as.getAllAuthors();
		response.getWriter().append(gson.toJson(authors));
	}

	@Override
	public Author getAuthorById(HttpServletRequest request, HttpServletResponse response) throws IOException {

		Author a = gson.fromJson(request.getReader(), Author.class);
		String username = a.getUsername();
		String password = a.getPassword();
		Author author = as.getAuthorByUsername(username);
		
		if (author.getPassword().equals(password)) {
			return author;
		} else {
			return null;
		}
		
	}

	@Override
	public void updateAuthor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Author a = gson.fromJson(request.getReader(), Author.class);
		as.updateAuthor(a);
		response.getWriter().append(gson.toJson(a));
		
		
	}

	@Override
	public void deleteAuthor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Author a = gson.fromJson(request.getReader(), Author.class);
		as.removeAuthor(a);
		response.getWriter().append(gson.toJson(a));
		
	}

	

}
