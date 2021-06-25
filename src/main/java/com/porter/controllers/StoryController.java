package com.porter.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.porter.models.Author;
import com.porter.models.Editor;
import com.porter.models.Story;

public interface StoryController {

	public Story createStory(HttpServletRequest request, HttpServletResponse response, Author a) throws IOException;
	
	public void getAllPendingStories(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public List<Story> getAllAsstPriorityStories(HttpServletRequest request, HttpServletResponse response, String genre) throws IOException;
	
	public List<Story> getAllStoriesByAuthor(HttpServletRequest request, HttpServletResponse response, Author a) throws IOException;
	
	public List<Story> getAllHoldStoriesByAuthor(HttpServletRequest request, HttpServletResponse response, Author a) throws IOException;
	
	public List<Story> getAllApprovedStoriesByAuthor(HttpServletRequest request, HttpServletResponse response, Author a) throws IOException;
	
	public Story getStoryById(HttpServletRequest request, HttpServletResponse response, Story s) throws IOException;
	
	public List<Story> getAllGenPendingStories(HttpServletRequest request, HttpServletResponse response, Editor e) throws IOException;
	
	public List<Story> getAllGenPriorityStories(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public List<Story> getAllSenPendingStories(HttpServletRequest request, HttpServletResponse response, String genre) throws IOException;
	
	public List<Story> getAllSenPriorityStories(HttpServletRequest request, HttpServletResponse response, String genre) throws IOException;
	
	public List<Story> getAllAsstPendingStories(HttpServletRequest request, HttpServletResponse response, String genre) throws IOException;
	
	public Story resubmitStory(HttpServletRequest request, HttpServletResponse response, Story s) throws IOException;
	
	public void rejectStory(HttpServletRequest request, HttpServletResponse response, Editor e, Story s) throws IOException;
	
	public void updateStories(HttpServletRequest request, HttpServletResponse response, Editor e, Story s) throws IOException;
	
	public void senUpdateStory(HttpServletRequest request, HttpServletResponse response, Story sChange, Story s) throws IOException;
	
	public void deleteStories(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
}
