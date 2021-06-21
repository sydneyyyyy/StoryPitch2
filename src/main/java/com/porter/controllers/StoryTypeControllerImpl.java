package com.porter.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.porter.models.Story;
import com.porter.models.StoryType;
import com.porter.services.StoryTypeServices;
import com.porter.services.StoryTypeServicesImpl;

public class StoryTypeControllerImpl implements StoryTypeController {

	StoryType st = new StoryType();
	private StoryTypeServices sts = new StoryTypeServicesImpl();
	private static Gson gson = new Gson();
	
	@Override
	public StoryType getStoryTypeByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Story s = gson.fromJson(request.getReader(), Story.class);
		String st = s.getStoryType();
		StoryType sty = sts.getStoryTypeByName(st);
		System.out.println(sty);
		response.getWriter().append(gson.toJson(sty));
		return sty;
		

	}

}
