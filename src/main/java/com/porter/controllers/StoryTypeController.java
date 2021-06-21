package com.porter.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.porter.models.StoryType;

public interface StoryTypeController {
	
	public StoryType getStoryTypeByName(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
