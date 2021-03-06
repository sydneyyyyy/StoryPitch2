package com.porter.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.porter.models.Editor;
import com.porter.utils.JDBCConnection;

public class EditorDAOImpl implements EditorDAO {

	private Connection conn = JDBCConnection.getConnection();
	
	@Override
	public Editor createEditor(Editor e) {
		
		String sql = "call create_editor (?, ?, ?, ?, ?);";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, e.getEditorName());
			ps.setString(2, e.getUsername());
			ps.setString(3, e.getPassword());
			ps.setString(4, e.getGenre());
			ps.setString(5, e.getJobTitle());
			
			boolean success = ps.execute();
			if (success) {
				ResultSet rs = ps.getResultSet();
				
				if (rs.next()) {
					e.setId(rs.getInt("id"));
					return e;
				}
			}
		} catch (SQLException error) {
			error.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Editor> getAllEditors() {
		
		List<Editor> editors = new ArrayList<Editor>();
		
		String sql = "select * from editors order by id;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Editor e = new Editor();
				e.setId(rs.getInt("id"));
				e.setEditorName(rs.getString("editorName"));
				e.setUsername(rs.getString("username"));
				e.setPassword(rs.getString("password"));
				e.setGenre(rs.getString("genre"));
				e.setJobTitle(rs.getString("jobTitle"));
				editors.add(e);
				
			}
			
			return editors;
			
		} catch (SQLException error) {
			error.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Editor getEditorById(Integer i) {
		
		String sql = "select * from editors where id = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Editor e = new Editor();
				e.setId(rs.getInt("id"));
				e.setEditorName(rs.getString("editorName"));
				e.setUsername(rs.getString("username"));
				e.setPassword(rs.getString("password"));
				e.setGenre(rs.getString("genre"));
				e.setJobTitle(rs.getString("jobTitle"));
				return e;
			}
		} catch (SQLException error) {
			error.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateEditor(Editor eChange) {
		
		String sql = "update editors set editorName = ?, username = ?, password = ?, genreId = ?, jobTitle = ? where id = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, eChange.getEditorName());
			ps.setString(2, eChange.getUsername());
			ps.setString(3, eChange.getPassword());
			ps.setString(4, eChange.getGenre());
			ps.setString(5, eChange.getJobTitle());
			
			boolean success = ps.execute();
			return success;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean removeEditor(Editor e) {
		
		String sql = "delete editors where id = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, e.getId());
			
			boolean success = ps.execute();
			return success;
			
		} catch (SQLException error) {
			error.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Editor getEditorByUsername(String username) {
		
		String sql = "select * from editors where username = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Editor e = new Editor();
				e.setId(rs.getInt("id"));
				e.setEditorName(rs.getString("editorName"));
				e.setUsername(rs.getString("username"));
				e.setPassword(rs.getString("password"));
				e.setGenre(rs.getString("genre"));
				e.setJobTitle(rs.getString("jobTitle"));
				return e;
			}
		} catch (SQLException error) {
			error.printStackTrace();
		}
		return null;
	}

	@Override
	public Editor getEditorByGenreTitle(String genre, String title) {
		String sql = "select * from editors where genre = ? AND jobtitle = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, genre);
			ps.setString(2, title);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Editor e = new Editor();
				e.setId(rs.getInt("id"));
				e.setEditorName(rs.getString("editorName"));
				e.setUsername(rs.getString("username"));
				e.setPassword(rs.getString("password"));
				e.setGenre(rs.getString("genre"));
				e.setJobTitle(rs.getString("jobTitle"));
				return e;
			}
		} catch (SQLException error) {
			error.printStackTrace();
		}
		return null;
	}

}
