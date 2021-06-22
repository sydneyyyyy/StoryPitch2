package com.porter.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.porter.models.Author;
import com.porter.models.Story;

public interface StoryController {

	public Story createStory(HttpServletRequest request, HttpServletResponse response, Author a) throws IOException;
	
	public void getAllStories(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public List<Story> getAllStoriesByAuthor(HttpServletRequest request, HttpServletResponse response, String name) throws IOException;
	
	public List<Story> getAllPendingStories(HttpServletRequest request, HttpServletResponse response, String genre) throws IOException;
	
//	public void getAllStoriesByStatus(HttpServletRequest request, HttpServletResponse response) throws IOException;
//	
	public Story getStoryById(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void updateStories(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void deleteStories(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
}