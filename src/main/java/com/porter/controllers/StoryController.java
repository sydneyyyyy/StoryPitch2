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
	
	public void getAllStories(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public List<Story> getAllStoriesByAuthor(HttpServletRequest request, HttpServletResponse response, String name) throws IOException;
	
	public Story getStoryById(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public List<Story> getAllPendingStories(HttpServletRequest request, HttpServletResponse response, Editor e) throws IOException;
	
//	public List<Story> getAllPendingHighPriorityStories(HttpServletRequest request, HttpServletResponse response, String genre) throws IOException;
//	
	public List<Story> getAllAsstPendingStories(HttpServletRequest request, HttpServletResponse response, String genre) throws IOException;
	
	
	public void updateStories(HttpServletRequest request, HttpServletResponse response, Editor e, Story s) throws IOException;
	
	public void deleteStories(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
}
