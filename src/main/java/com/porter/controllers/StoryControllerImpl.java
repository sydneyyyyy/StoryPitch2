package com.porter.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.porter.models.Author;
import com.porter.models.Story;
import com.porter.models.StoryType;
import com.porter.services.StoryServices;
import com.porter.services.StoryServicesImpl;

public class StoryControllerImpl implements StoryController {

	private StoryServices ss = new StoryServicesImpl();
	private static Gson gson = new Gson();
	
	
	Author a = new Author();
	
	@Override
	public void createStory(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Story s = gson.fromJson(request.getReader(), Story.class);
		ss.createStory(s);
		response.getWriter().append(gson.toJson(s));

	}

	@Override
	public void getAllStories(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Story> stories = ss.getAllStories();
		System.out.println(stories);
		response.getWriter().append(gson.toJson(stories));

	}

	@Override
	public List<Story> getAllStoriesByAuthor(HttpServletRequest request, HttpServletResponse response, String name) throws IOException {
		List<Story> stories = ss.getAllStoriesByAuthor(name);
		System.out.println(stories);
		response.getWriter().append(gson.toJson(stories));
		return stories;

	}

	@Override
	public void getAllStoriesByGenre(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAllStoriesByStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Story getStoryById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStories(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStories(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

	}

}
