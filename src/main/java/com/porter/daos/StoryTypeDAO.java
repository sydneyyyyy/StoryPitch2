package com.porter.daos;

import java.util.List;
import com.porter.models.StoryType;


public interface StoryTypeDAO {

	public StoryType createStoryType(StoryType st);

	public List<StoryType> getAllStoryTypes();

	public StoryType getStoryTypeById(Integer i);
	
	public StoryType getStoryTypeByName(String storyType);

	public boolean updateStoryType(StoryType stChange);

	public boolean removeStoryType(StoryType st);

}
