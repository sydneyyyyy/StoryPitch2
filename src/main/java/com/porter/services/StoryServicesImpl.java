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
	public List<Story> getAllPendingStories(String status) {
		return sdao.getAllPendingStories(status);
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

	@Override
	public List<Story> getAllAsstPendingStories(String genre, String status, String ae_approval) {
		return sdao.getAllAsstPendingStories(genre, status, ae_approval);
	}
	
	@Override
	public List<Story> getAllAsstPriorityStories(String genre, String status, Boolean priority, String ae_approval) {
		return sdao.getAllAsstPriorityStories(genre, status, priority, ae_approval);
	}

	@Override
	public List<Story> getAllPendingStories(String status, String ae_approval, String ge_approval) {
		return sdao.getAllPendingStories(status, ae_approval, ge_approval);
	}

	@Override
	public List<Story> getAllSenPendingStories(String genre, String status, Boolean priority, String ae_approval, String ge_approval) {
		return sdao.getAllSenPendingStories(genre, status, priority, ae_approval, ge_approval);
	}

	@Override
	public List<Story> getAllPendingStoriesByAuthor(String authorName, String submitted) {
		return sdao.getAllPendingStoriesByAuthor(authorName, submitted);
	}

	@Override
	public List<Story> getAllGenPriorityStories(String status, Boolean priority, String ae_approval, String ge_approval) {
		return sdao.getAllGenPriorityStories(status, priority, ae_approval, ge_approval);
	}

	@Override
	public List<Story> getAllSenPriorityStories(String genre, Boolean priority, String status, String ae_approval, String ge_approval,
			String se_approval) {
		return sdao.getAllSenPriorityStories(genre, status, priority, ae_approval, ge_approval, se_approval);
	}

	@Override
	public List<Story> getAllPendingDrafts(String genre, String aeDraft_approval, String geDraft_approval, String seDraft_approval) {
		return sdao.getAllPendingDrafts(genre, aeDraft_approval, geDraft_approval, seDraft_approval);
	}

	

	
	

}
