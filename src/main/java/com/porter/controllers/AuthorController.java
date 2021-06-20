package com.porter.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.porter.models.Author;

public interface AuthorController {


	public void createAuthor(HttpServletRequest request, HttpServletResponse response) throws IOException;
		
	public void getAllAuthors(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public Author getAuthorById(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void updateAuthor(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void deleteAuthor(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	
	
}
