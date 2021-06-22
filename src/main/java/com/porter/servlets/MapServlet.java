package com.porter.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.porter.controllers.AuthorController;
import com.porter.controllers.AuthorControllerImpl;
import com.porter.controllers.EditorController;
import com.porter.controllers.EditorControllerImpl;
import com.porter.controllers.StoryController;
import com.porter.controllers.StoryControllerImpl;
import com.porter.controllers.StoryTypeController;
import com.porter.controllers.StoryTypeControllerImpl;
import com.porter.models.Author;
import com.porter.models.Editor;
import com.porter.models.Story;
import com.porter.models.StoryType;
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
	private StoryController sc = new StoryControllerImpl();
	private StoryTypeController stc = new StoryTypeControllerImpl();
	private static HttpSession session;
	private static Author a;
	private static Editor e;
	private static StoryType st;

	private Gson gson = new Gson();

	public void mapping(HttpServletRequest request, HttpServletResponse response) throws IOException {

		session = request.getSession();
		System.out.println(session.getId());
		
		session.setAttribute("loggedInUser", a);
		System.out.println(session.getAttribute("loggedInUser"));
		
		session.setAttribute("loggedInEditor", e);
		System.out.println(session.getAttribute("loggedInEditor"));

		String uri = request.getRequestURI();
		System.out.println(uri);

		switch (uri) {
		
			case "/StoryPitch-2/session" : {
				a = (Author) session.getAttribute("loggedInUser");
				System.out.println(a);
				response.getWriter().append(gson.toJson(a));
				break;
			}
			
			case "/StoryPitch-2/edSession" : {
				e = (Editor) session.getAttribute("loggedInEditor");
				System.out.println(e);
				response.getWriter().append(gson.toJson(e));
				break;
			}
			
			case "/StoryPitch-2/authors": {
				System.out.println("Getting all authors...");
				List<Author> authors = as.getAllAuthors();
				System.out.println(authors);
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.getWriter().append(gson.toJson(authors));
				break;
			}
			
			case "/StoryPitch-2/authorSignup": {
				System.out.println("Creating a new author...");
				ac.createAuthor(request, response);
				response.setHeader("Access-Control-Allow-Origin", "*");
				break;
			}
	
			case "/StoryPitch-2/authors/id": {
				System.out.println("Author logging in...");
				response.setHeader("Access-Control-Allow-Origin", "*");
				a = ac.getAuthorById(request, response);
				session.setAttribute("loggedInUser", a);
				System.out.println(a);
				break;
			}
			
			case "/StoryPitch-2/editors/id": {
				System.out.println("Editor Logging in...");
				e = ec.getEditorById(request, response);
				System.out.println(e);
				session.setAttribute("loggedInEditor", e);
				response.setHeader("Access-Control-Allow-Origin", "*");
				break;
			}
	
			case "/StoryPitch-2/updateAuthor": {
				System.out.println("Updating author...");
				ac.updateAuthor(request, response);
				break;
			}
			
			case "/StoryPitch-2/editors" : {
				System.out.println("Getting all editors");
				List<Editor> editors = es.getAllEditors();
				System.out.println(editors);
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.getWriter().append(gson.toJson(editors));
				break;
			}
			
			case "/StoryPitch-2/authors/stories": {
				System.out.println("Getting Author's Stories...");
				a = (Author) session.getAttribute("loggedInUser");
				sc.getAllStoriesByAuthor(request, response, a.getAuthorName());
				break;
			}
			
			case "/StoryPitch-2/editors/stories": {
				System.out.println("Getting all Pending Stories...");
				e = (Editor) session.getAttribute("loggedInEditor");
				sc.getAllPendingStories(request, response, e.getGenre());
				response.setHeader("Access-Control-Allow-Origin", "*");
				break;
			}
			
			case "/StoryPitch-2/newStory": {
				System.out.println("Creating story...");
				a = (Author) session.getAttribute("loggedInUser");
				Story s = sc.createStory(request, response, a);
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.getWriter().append(gson.toJson(s));
				break;
			}
			
	
			default: {
				System.out.println("Reached the default case...");
				response.sendError(418, "BRB making tea...");
			}
		}

	}

}
