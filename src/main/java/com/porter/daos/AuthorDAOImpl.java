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
		
		String sql = "call create_author(?, ?, ?, ?);";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, a.getAuthorName());
			ps.setString(2, a.getUsername());
			ps.setString(3, a.getPassword());
			ps.setInt(4, a.getPoints());
			
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
				a.setPoints(rs.getInt("availablePoints"));
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
				a.setPoints(rs.getInt("availablePoints"));
				
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Author updateAuthor(Author aChange) {
		
		String sql = "update authors set name = ?, username = ?, password = ?, availablePoints = ? where id = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, aChange.getAuthorName());
			ps.setString(2, aChange.getUsername());
			ps.setString(3, aChange.getPassword());
			ps.setInt(4, aChange.getPoints());
			ps.setInt(5, aChange.getId());
			
			ps.execute();
			return aChange;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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

	@Override
	public Author getAuthorByUsername(String username) {
		
		String sql = "select * from authors where username = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Author a = new Author();
				a.setId(rs.getInt("id"));
				a.setAuthorName(rs.getString("name"));
				a.setUsername(rs.getString("username"));
				a.setPassword(rs.getString("password"));
				a.setPoints(rs.getInt("availablePoints"));
				
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Author getAuthorByName(String name) {
		String sql = "select * from authors where name = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Author a = new Author();
				a.setId(rs.getInt("id"));
				a.setAuthorName(rs.getString("name"));
				a.setUsername(rs.getString("username"));
				a.setPassword(rs.getString("password"));
				a.setPoints(rs.getInt("availablePoints"));
				
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
