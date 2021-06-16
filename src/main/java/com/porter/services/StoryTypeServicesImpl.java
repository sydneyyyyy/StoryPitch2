package com.porter.services;

import java.util.List;

import com.porter.daos.StoryTypeDAO;
import com.porter.daos.StoryTypeDAOImpl;
import com.porter.models.StoryType;

public class StoryTypeServicesImpl implements StoryTypeServices {

	private StoryTypeDAO stdao = new StoryTypeDAOImpl();

	@Override
	public StoryType createStoryType(StoryType st) {
		return stdao.createStoryType(st);
	}

	@Override
	public List<StoryType> getAllStoryTypes() {
		return stdao.getAllStoryTypes();
	}

	@Override
	public StoryType getStoryTypeById(Integer i) {
		return stdao.getStoryTypeById(i);
	}

	@Override
	public boolean updateStoryType(StoryType st) {
		return stdao.updateStoryType(st);
	}

	@Override
	public boolean removeStoryType(StoryType st) {
		return stdao.removeStoryType(st);
	}
	
	

}
