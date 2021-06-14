package com.porter.daos;

import java.util.List;
import com.porter.models.Genre;


public interface GenreDAO {

	public Genre createGenre();
	
	public List<Genre> getAllGenre();
	
	public Genre getGenreById(Integer i);
	
	public Genre getGenreByGenreName(String genreName);
	
	public Genre updateGenre(Integer i);
	
	public boolean deleteGenre();
	
}
