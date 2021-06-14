package com.porter.services;

import java.util.List;

import com.porter.models.StoryType;

public interface StoryTypeServices {

	public StoryType createStoryType();
	
	public List<StoryType> getAllStoryTypes();
	
	public StoryType getStoryTypeById(Integer i);
	
	public StoryType updateStoryType(Integer i);
	
	public boolean removeStoryType();
	
}
