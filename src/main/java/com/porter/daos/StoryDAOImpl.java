package com.porter.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.porter.models.Story;
import com.porter.utils.JDBCConnection;


public class StoryDAOImpl implements StoryDAO {

	private Connection conn = JDBCConnection.getConnection();

	@Override
	public Story createStory(Story s) {

		String sql = "insert into stories values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) returning *;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, s.getAuthorName());
			ps.setString(2, s.getTitle());
			ps.setString(3, s.getReleaseDate());
			ps.setString(4, s.getTagLine());
			ps.setString(5, s.getDescription());
			ps.setString(6, s.getSubmitted());
			ps.setBoolean(7, s.getIsHighPriority());
			ps.setString(8, s.getStoryType());
			ps.setString(9, s.getGenre());
			ps.setString(10, s.getDateSubmitted());
			ps.setString(11, s.getAe_approval());
			ps.setString(12, s.getGe_approval());
			ps.setString(13, s.getSe_approval());
			
			boolean success = ps.execute();
			if (success) {
				ResultSet rs = ps.getResultSet();
				if (rs.next()) {
					s.setId(rs.getInt("id"));
					return s;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Story> getAllStories() {

		List<Story> stories = new ArrayList<Story>();

		String sql = "select * from stories order by id;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Story s = new Story();
				s.setId(rs.getInt("id"));
				s.setAuthorName(rs.getString("authorName"));
				s.setTitle(rs.getString("title"));
				s.setReleaseDate(rs.getString("releaseDate"));
				s.setTagLine(rs.getString("tagLine"));
				s.setDescription(rs.getString("description"));
				s.setSubmitted(rs.getString("submitted"));
				s.setIsHighPriority(rs.getBoolean("isHighPriority"));
				s.setStoryType(rs.getString("storyType"));
				s.setGenre(rs.getString("genre"));
				s.setDateSubmitted(rs.getString("dateSubmitted"));
				s.setAe_approval(rs.getString("ae_approval"));
				s.setGe_approval(rs.getString("ge_approval"));
				s.setSe_approval(rs.getString("se_approval"));
				
				
				
				stories.add(s);
				
			}

			return stories;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Story> getAllStoriesByAuthor(String authorName) {

		List<Story> stories = new ArrayList<Story>();

		String sql = "select * from stories where authorName = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, authorName);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Story s = new Story();
				s.setId(rs.getInt("id"));
				s.setAuthorName(rs.getString("authorName"));
				s.setTitle(rs.getString("title"));
				s.setReleaseDate(rs.getString("releaseDate"));
				s.setTagLine(rs.getString("tagLine"));
				s.setDescription(rs.getString("description"));
				s.setSubmitted(rs.getString("submitted"));
				s.setIsHighPriority(rs.getBoolean("isHighPriority"));
				s.setStoryType(rs.getString("storyType"));
				s.setGenre(rs.getString("genre"));
				s.setDateSubmitted(rs.getString("dateSubmitted"));
				s.setAe_approval(rs.getString("ae_approval"));
				s.setGe_approval(rs.getString("ge_approval"));
				s.setSe_approval(rs.getString("se_approval"));
				
				
				stories.add(s);
				
			}
			
			return stories;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	@Override
	public List<Story> getAllAsstPendingStories(String genre, String status, String ae_approval) {
		List<Story> stories = new ArrayList<Story>();
		String sql = "select * from stories where genre = ? AND submitted = ? AND ae_approval = ?;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, genre);
			ps.setString(2, status);
			ps.setString(3, ae_approval);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Story s = new Story();
				s.setId(rs.getInt("id"));
				s.setAuthorName(rs.getString("authorName"));
				s.setTitle(rs.getString("title"));
				s.setReleaseDate(rs.getString("releaseDate"));
				s.setTagLine(rs.getString("tagLine"));
				s.setDescription(rs.getString("description"));
				s.setSubmitted(rs.getString("submitted"));
				s.setIsHighPriority(rs.getBoolean("isHighPriority"));
				s.setStoryType(rs.getString("storyType"));
				s.setGenre(rs.getString("genre"));
				s.setDateSubmitted(rs.getString("dateSubmitted"));
				s.setAe_approval(rs.getString("ae_approval"));
				s.setGe_approval(rs.getString("ge_approval"));
				s.setSe_approval(rs.getString("se_approval"));
				
				stories.add(s);		
			}
			
			return stories;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Story> getAllPendingHighPriorityStories(String genre, Boolean isHighPriority, String submitted) {
		List<Story> stories = new ArrayList<Story>();
		String sql = "select * from stories where genre = ? AND isHighPriority = ? AND submitted = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, genre);
			ps.setBoolean(2, isHighPriority);
			ps.setString(3, submitted);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Story s = new Story();
				s.setId(rs.getInt("id"));
				s.setAuthorName(rs.getString("authorName"));
				s.setTitle(rs.getString("title"));
				s.setReleaseDate(rs.getString("releaseDate"));
				s.setTagLine(rs.getString("tagLine"));
				s.setDescription(rs.getString("description"));
				s.setSubmitted(rs.getString("submitted"));
				s.setIsHighPriority(rs.getBoolean("isHighPriority"));
				s.setStoryType(rs.getString("storyType"));
				s.setGenre(rs.getString("genre"));
				
				stories.add(s);		
			}
			return stories;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Story getStoryById(Integer i) {

		String sql = "select * from stories where id = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Story s = new Story();
				s.setId(rs.getInt("id"));
				s.setAuthorName(rs.getString("authorName"));
				s.setTitle(rs.getString("title"));
				s.setReleaseDate(rs.getString("releaseDate"));
				s.setTagLine(rs.getString("tagLine"));
				s.setDescription(rs.getString("description"));
				s.setSubmitted(rs.getString("submitted"));
				s.setIsHighPriority(rs.getBoolean("isHighPriority"));
				s.setStoryType(rs.getString("storyType"));
				s.setGenre(rs.getString("genre"));
				s.setDateSubmitted(rs.getString("dateSubmitted"));
				s.setAe_approval(rs.getString("ae_approval"));
				s.setGe_approval(rs.getString("ge_approval"));
				s.setSe_approval(rs.getString("se_approval"));
				
				
				
				return s;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean updateStory(Story sChange) {

		String sql = "update stories set authorName = ?, title = ?, releaseDate = ?, tagLine = ?, description = ?, submitted = ?, isHighPriority = ?,  storyType = ?, genre = ? where id = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, sChange.getAuthorName());
			ps.setString(2, sChange.getTitle());
			ps.setString(3, sChange.getReleaseDate());
			ps.setString(4, sChange.getTagLine());
			ps.setString(5, sChange.getDescription());
			ps.setString(6, sChange.getSubmitted());
			ps.setBoolean(7, sChange.getIsHighPriority());
			ps.setString(8, sChange.getStoryType());
			ps.setString(9, sChange.getGenre());
			ps.setInt(10, sChange.getId());

			boolean success = ps.execute();
			
			if (success) {
				return success;
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean removeStory(Story s) {
		
		String sql = "delete stories where id = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, s.getId());

			boolean success = ps.execute();
			
			if (success) {
				return success;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	



}
