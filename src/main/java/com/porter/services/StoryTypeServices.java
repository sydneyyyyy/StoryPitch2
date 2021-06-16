package com.porter.services;

import java.util.List;

import com.porter.models.StoryType;

public interface StoryTypeServices {

	public StoryType createStoryType(StoryType st);
	
	public List<StoryType> getAllStoryTypes();
	
	public StoryType getStoryTypeById(Integer i);
	
	public boolean updateStoryType(StoryType st);
	
	public boolean removeStoryType(StoryType st);
	
}
