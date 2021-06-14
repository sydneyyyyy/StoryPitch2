package com.porter.daos;

import java.util.List;
import com.porter.models.Story;

public interface StoryDAO {

	// Create Story
	public Story createStory();

	// GetAllStories
	public List<Story> getAllStories();

	// GetAllStoriesByAuthor
	public List<Story> getAllStoriesByAuthor(String authorName);

	// UpdateStory
	public Story updateStory(Integer i);

	// RemoveStory
	public boolean removeStory(Integer i);

}
