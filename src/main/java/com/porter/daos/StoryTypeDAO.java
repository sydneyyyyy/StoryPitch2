package com.porter.daos;

import java.util.List;
import com.porter.models.StoryType;


public interface StoryTypeDAO {

	public StoryType createStoryType();

	public List<StoryType> getAllStoryTypes();

	public StoryType getStoryTypeById(Integer i);

	public StoryType updateStoryType(Integer i);

	public boolean removeStoryType();

}
