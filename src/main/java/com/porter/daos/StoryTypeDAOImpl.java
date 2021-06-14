package com.porter.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.porter.models.StoryType;
import com.porter.utils.JDBCConnection;


public class StoryTypeDAOImpl implements StoryTypeDAO {

	private Connection conn = JDBCConnection.getConnection();

	@Override
	public StoryType createStoryType(StoryType st) {

		String sql = "call create_storyType(default, ?, ?);";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, st.getStoryType());
			ps.setInt(2, st.getPoints());

			boolean success = ps.execute();

			if (success) {
				ResultSet rs = ps.getResultSet();

				if (rs.next()) {
					st.setId(rs.getInt("id"));
					return st;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<StoryType> getAllStoryTypes() {

		List<StoryType> sTypes = new ArrayList<StoryType>();

		String sql = "select * from stories order by id;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				StoryType st = new StoryType();
				st.setId(rs.getInt("id"));
				st.setStoryType(rs.getString("storyType"));
				st.setPoints(rs.getInt("points"));

				sTypes.add(st);

			}

			return sTypes;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public StoryType getStoryTypeById(Integer i) {

		String sql = "select * from storyTypes where id = ?;";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, i);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				StoryType st = new StoryType();
				st.setId(rs.getInt("id"));
				st.setStoryType(rs.getString("storyType"));
				st.setPoints(rs.getInt("points"));

				return st;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean updateStoryType(StoryType stChange) {

		String sql = "update storyTypes set storyType = ?, points = ? where id = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, stChange.getStoryType());
			ps.setInt(2, stChange.getPoints());

			boolean success = ps.execute();
			return success;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeStoryType(StoryType st) {
		
		String sql = "delete storyTypes where id = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, st.getId());

			boolean success = ps.execute();
			return success;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
