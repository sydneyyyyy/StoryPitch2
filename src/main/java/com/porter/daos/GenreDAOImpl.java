package com.porter.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.porter.models.Genre;
import com.porter.utils.JDBCConnection;

public class GenreDAOImpl implements GenreDAO {

	private Connection conn = JDBCConnection.getConnection();
	
	@Override
	public Genre createGenre(Genre g) {
		
		String sql = "call create_genre(?);";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, g.getGenreName());
			
			boolean success = ps.execute();
			
			if (success) {
				ResultSet rs = ps.getResultSet();
				
				if (rs.next()) {
					g.setId(rs.getInt("id"));
					return g;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Genre> getAllGenre() {
		
		List<Genre> genres = new ArrayList<Genre>();
		
		String sql = "select * from genre order by id;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Genre g = new Genre();
				g.setId(rs.getInt("id"));
				g.setGenreName(rs.getString("genreName"));
				genres.add(g);
			}
			
			return genres;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Genre getGenreById(Integer i) {
		
		String sql = "select * from genre where id = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Genre g = new Genre();
				g.setId(rs.getInt("id"));
				g.setGenreName(rs.getString("genreName"));
				
				return g;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Genre getGenreByGenreName(String genreName) {
		
		String sql = "select * from genre where genreName = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, genreName);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Genre g = new Genre();
				g.setId(rs.getInt("id"));
				g.setGenreName(rs.getString("genreName"));
				
				return g;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean updateGenre(Genre gChange) {
		
		String sql = "update genre set genreName = ? where id = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, gChange.getGenreName());
			
			boolean success = ps.execute();
			return success;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean deleteGenre(Genre g) {
		
		String sql = "delete genre where id = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, g.getId());
			
			boolean success = ps.execute();
			return success;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	

}
