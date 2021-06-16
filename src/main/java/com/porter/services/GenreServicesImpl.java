package com.porter.services;

import java.util.List;

import com.porter.daos.GenreDAO;
import com.porter.daos.GenreDAOImpl;
import com.porter.models.Genre;

public class GenreServicesImpl implements GenreServices {

	private GenreDAO gdao = new GenreDAOImpl();

	@Override
	public Genre createGenre(Genre g) {
		return gdao.createGenre(g);
	}

	@Override
	public List<Genre> getAllGenre() {
		return gdao.getAllGenre();
	}

	@Override
	public Genre getGenreById(Integer i) {
		return gdao.getGenreById(i);
	}

	@Override
	public Genre getGenreByGenreName(String genreName) {
		return gdao.getGenreByGenreName(genreName);
	}

	@Override
	public boolean updateGenre(Genre gChange) {
		return gdao.updateGenre(gChange);
	}

	@Override
	public boolean deleteGenre(Genre g) {
		return gdao.deleteGenre(g);
	}
	
	
}
