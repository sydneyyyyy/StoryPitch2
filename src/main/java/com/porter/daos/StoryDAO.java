package com.porter.daos;

import java.util.List;
import com.porter.models.Story;

public interface StoryDAO {

	public Story createStory(Story s);

	public List<Story> getAllPendingStories(String status);
	
	public List<Story> getAllStoriesByAuthor(String authorName);
	
	public List<Story> getAllPendingStoriesByAuthor(String authorName, String submitted);
	
	public Story getStoryById(Integer i);
	
	public List<Story> getAllPendingStories(String status, String ae_approval, String ge_approval);
	
	public List<Story> getAllAsstPendingStories(String genre, String status, String approval);
	
	public List<Story> getAllAsstPriorityStories(String genre, String status, Boolean priority, String ae_approval);
	
	public List<Story> getAllSenPendingStories(String genre, String status, String ae_approval, String ge_approval);
	
	public List<Story> getAllGenPriorityStories(String status, Boolean priority, String ae_approval, String ge_approval);
	
	public List<Story> getAllSenPriorityStories(String genre, String status, Boolean priority, String ae_approval, String ge_approval, String se_approval);

	public boolean updateStory(Story sChange);

	public boolean removeStory(Story s);

}
