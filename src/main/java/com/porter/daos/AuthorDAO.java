package com.porter.daos;

import java.util.List;
import com.porter.models.Author;


public interface AuthorDAO {

	public Author createAuthor(Author a);

	public List<Author> getAllAuthors();

	public Author getAuthorById(Integer i);

	public boolean updateAuthor(Author aChange);

	public boolean removeAuthor(Author a);

}
