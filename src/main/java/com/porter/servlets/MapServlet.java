package com.porter.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.porter.controllers.AuthorController;
import com.porter.controllers.AuthorControllerImpl;
import com.porter.controllers.EditorController;
import com.porter.controllers.EditorControllerImpl;
import com.porter.models.Author;
import com.porter.models.Editor;
import com.porter.services.AuthorServices;
import com.porter.services.AuthorServicesImpl;
import com.porter.services.EditorServices;
import com.porter.services.EditorServicesImpl;

public class MapServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AuthorServices as = new AuthorServicesImpl();
	private AuthorController ac = new AuthorControllerImpl();
	private EditorServices es = new EditorServicesImpl();
	private EditorController ec = new EditorControllerImpl();
	
	private Gson gson = new Gson();
	
	public void mapping(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Author a = new Author();
		Editor e = new Editor();
//		System.out.println(a);
		HttpSession session = request.getSession();
		System.out.println(session);
		
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		switch (uri) {
		
			case "/StoryPitch-2/authors" : {
				System.out.println("Getting all authors...");
				List<Author> authors = as.getAllAuthors();
				System.out.println(authors);
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.getWriter().append(gson.toJson(authors));
				break;
			}
			
			case "/StoryPitch-2/addAuthor" : {
				System.out.println("Adding new author....");
				ac.createAuthor(request, response);
				System.out.println(a);
				break;
			}
			
			case "/StoryPitch-2/authors/id" : {
				System.out.println("Getting a specific Author...");
				Author author = ac.getAuthorById(request, response);
				System.out.println(author);
				
				break;
			}
			
			case "/StoryPitch-2/updateAuthor" : {
				System.out.println("Updating author...");
				ac.updateAuthor(request, response);
				System.out.println(a);
				break;
			}
			
			case "/StoryPitch-2/editors/id" : {
				System.out.println("Getting a specific editor...");
				Editor ed = ec.getEditorByUsername(request, response);
				System.out.println(ed);
			}
			
			
			default: {
				System.out.println("Reached the default case...");
				response.sendError(418, "BRB making tea...");
			}
		}	
		
	}
	
	
}
