package com.porter.services;

import java.util.List;
import com.porter.models.Genre;


public interface GenreServices {

	public Genre createGenre(Genre g);
	
	public List<Genre> getAllGenre();
	
	public Genre getGenreById(Integer i);
	
	public Genre getGenreByGenreName(String genreName);
	
	public boolean updateGenre(Genre gChange);
	
	public boolean deleteGenre(Genre g);
	
	
}
