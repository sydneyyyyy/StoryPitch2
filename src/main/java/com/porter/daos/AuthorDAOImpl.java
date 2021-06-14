package com.porter.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.porter.models.Author;
import com.porter.utils.JDBCConnection;

public class AuthorDAOImpl implements AuthorDAO {

	private Connection conn = JDBCConnection.getConnection();
	
	
	@Override
	public Author createAuthor(Author a) {
		
		String sql = "call create_author(default, ?, ?, ?);";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getAuthorName());
			ps.setString(2, a.getUsername());
			ps.setString(3, a.getPassword());
			
			boolean success = ps.execute();
			
			if (success) {
				ResultSet rs = ps.getResultSet();
				
				if (rs.next()) {
					a.setId(rs.getInt("id"));
					return a;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Author> getAllAuthors() {
		
		List<Author> authors = new ArrayList<Author>();
		
		String sql = "select * from authors order by id;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Author a = new Author();
				a.setId(rs.getInt("id"));
				a.setAuthorName(rs.getString("name"));
				a.setUsername(rs.getString("username"));
				a.setPassword(rs.getString("password"));
				authors.add(a);
				
			}
			
			return authors;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Author getAuthorById(Integer i) {
		
		String sql = "select * from authors where id = ?;";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Author a = new Author();
				a.setId(rs.getInt("id"));
				a.setAuthorName(rs.getString("name"));
				a.setUsername(rs.getString("username"));
				a.setPassword(rs.getString("password"));
				
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean updateAuthor(Author aChange) {
		
		String sql = "update authors set name = ?, username = ?, password = ? where id = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, aChange.getAuthorName());
			ps.setString(2, aChange.getUsername());
			ps.setString(3, aChange.getPassword());
			
			boolean success = ps.execute();
			return success;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeAuthor(Author a) {
		
		String sql = "delete authors where id = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, a.getId());
			
			boolean success = ps.execute();
			return success;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
