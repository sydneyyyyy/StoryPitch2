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
	
	public List<Story> getAllAsstPendingStories(String genre, String status, String approval);
	
	public List<Story> getAllPendingHighPriorityStories(String genre, Boolean isHighPriority, String status);

	// UpdateStory
	public boolean updateStory(Story sChange);

	// RemoveStory
	public boolean removeStory(Story s);

}
