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
import com.porter.services.AuthorServices;
import com.porter.services.AuthorServicesImpl;
import com.porter.services.StoryServices;
import com.porter.services.StoryServicesImpl;
import com.porter.services.StoryTypeServices;
import com.porter.services.StoryTypeServicesImpl;

public class StoryControllerImpl implements StoryController {

	private StoryServices ss = new StoryServicesImpl();
	private StoryTypeServices sts = new StoryTypeServicesImpl();
	private AuthorServices as = new AuthorServicesImpl();
	private static Gson gson = new Gson();
	StoryType st = new StoryType();
	
	
//	Author a = new Author();
	
	@Override
	public Story createStory(HttpServletRequest request, HttpServletResponse response, Author a) throws IOException {
		Story s = gson.fromJson(request.getReader(), Story.class);
		String storytype = s.getStoryType();
		System.out.println(storytype);
		StoryType stype = sts.getStoryTypeByName(storytype);
		int points = stype.getPoints();
		if (a.getPoints() >= points) {
			System.out.println("Congrats, you submitted a story pitch!");
			ss.createStory(s);
			int newPoints = a.getPoints() - points;
			System.out.println(newPoints);
			a.setPoints(newPoints);
			a.getPoints();
			System.out.println(a);
			as.updateAuthor(a);
		} else {
			System.out.println("You do not have enough points for this submission! Story Pitch placed on hold");
			ss.createStory(s);
			s.setSubmitted("on-hold");
			ss.updateStory(s);
		}
		
		
		response.getWriter().append(gson.toJson(s));
		return s;
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
	public List<Story> getAllPendingStories(HttpServletRequest request, HttpServletResponse response, String genre) throws IOException {
		String status = "pending";
		List<Story> stories = ss.getAllPendingStories(genre, status);
		System.out.println(stories);
		response.getWriter().append(gson.toJson(stories));
		return stories;
	}

//	@Override
//	public void getAllStoriesByStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String status = "pending";
//		List<Story> stories = ss.getAllStoriesByStatus(status,);
//		System.out.println(stories);
//		response.getWriter().append(gson.toJson(stories));
//
//	}

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
