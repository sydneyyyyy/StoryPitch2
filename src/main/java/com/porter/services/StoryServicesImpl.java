package com.porter.services;

import java.util.List;

import com.porter.daos.StoryDAO;
import com.porter.daos.StoryDAOImpl;
import com.porter.models.Story;

public class StoryServicesImpl implements StoryServices {

	private StoryDAO sdao = new StoryDAOImpl();

	@Override
	public Story createStory(Story s) {
		return sdao.createStory(s);
	}

	@Override
	public List<Story> getAllStories() {
		return sdao.getAllStories();
	}

	@Override
	public List<Story> getAllStoriesByAuthor(String authorName) {
		return sdao.getAllStoriesByAuthor(authorName);
	}

	@Override
	public Story getStoryById(Integer i) {
		return sdao.getStoryById(i);
	}

	@Override
	public boolean updateStory(Story sChange) {
		return sdao.updateStory(sChange);
	}

	@Override
	public boolean removeStory(Story s) {
		return sdao.removeStory(s);
	}
	
	

}
