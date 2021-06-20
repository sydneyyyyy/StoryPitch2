package com.porter.servlets;


import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



// main servlet calls other servlets or seperate servlet for specific for different services (not necessary)

public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public MapServlet ms = new MapServlet();
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-Type", "application/json");
		ms.mapping(request, response);

		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Content-Type", "application/json");
		ms.mapping(request, response);
		
	}
}


/*
 * Notes - in class Demonstration
 * 
 * should use the other methods as well
 * 
 * */
 