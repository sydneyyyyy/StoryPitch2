package com.porter.services;

import java.util.List;

import com.porter.models.Story;

public interface StoryServices {

	public Story createStory(Story s);

	public List<Story> getAllStories();

	public List<Story> getAllStoriesByAuthor(String authorName);
	
	public List<Story> getAllPendingStoriesByAuthor(String authorName, String submitted);
	
	public List<Story> getAllPendingStories(String status, String ae_approval, String ge_approval);
	
	public List<Story> getAllAsstPendingStories(String genre, String status, String approval);
	
	public List<Story> getAllSenPendingStories(String genre, String status, String ae_approval, String ge_approval);
	
	public Story getStoryById(Integer i);

	public boolean updateStory(Story sChange);

	public boolean removeStory(Story s);

}
