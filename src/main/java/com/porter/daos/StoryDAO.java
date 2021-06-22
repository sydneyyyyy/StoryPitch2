package com.porter.daos;

import java.util.List;
import com.porter.models.Story;

public interface StoryDAO {

	// Create Story
	public Story createStory(Story s);

	// GetAllStories
	public List<Story> getAllStories();
	
	// GetAllStoriesByAuthor
	public List<Story> getAllStoriesByAuthor(String authorName);
	
	public Story getStoryById(Integer i);
	
	public List<Story> getAllPendingStories(String genre, String status);

	// UpdateStory
	public boolean updateStory(Story sChange);

	// RemoveStory
	public boolean removeStory(Story s);

}
