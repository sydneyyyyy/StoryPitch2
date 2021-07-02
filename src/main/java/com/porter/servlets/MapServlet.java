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
import com.porter.utils.AppLogger;

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
	private static Story s;

	private Gson gson = new Gson();

	public void mapping(HttpServletRequest request, HttpServletResponse response) throws IOException {

		session = request.getSession();
		System.out.println(session.getId());
		
		session.setAttribute("loggedInUser", a);
		System.out.println(session.getAttribute("loggedInUser"));
		
		session.setAttribute("loggedInEditor", e);
		System.out.println(session.getAttribute("loggedInEditor"));
		
		session.setAttribute("currentStory", s);
		System.out.println(session.getAttribute("currentStory"));

		String uri = request.getRequestURI();
		System.out.println(uri);

		switch (uri) {
		
			case "/StoryPitch-2/session" : {
				AppLogger.logger.info("Author saved to session.");
				a = (Author) session.getAttribute("loggedInUser");
				System.out.println(a);
				response.getWriter().append(gson.toJson(a));
				break;
			}
			
			case "/StoryPitch-2/edSession" : {
				AppLogger.logger.info("Editor saved to session.");
				e = (Editor) session.getAttribute("loggedInEditor");
				System.out.println(e);
				response.getWriter().append(gson.toJson(e));
				response.setHeader("Access-Control-Allow-Origin", "*");
				break;
			}
			
			case "/StoryPitch-2/storySession" : {
				AppLogger.logger.info("Story saved to session.");
				s = (Story) session.getAttribute("currentStory");
				System.out.println(s);
				response.getWriter().append(gson.toJson(s));
				break;
			}
			
			case "/StoryPitch-2/authors": {
				AppLogger.logger.info("Getting all authors");
				System.out.println("Getting all authors...");
				List<Author> authors = as.getAllAuthors();
				System.out.println(authors);
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.getWriter().append(gson.toJson(authors));
				break;
			}
			
			case "/StoryPitch-2/authors/stories": {
				AppLogger.logger.info("Getting all pending stories");
				System.out.println("Getting all pending stories...");
				a = (Author) session.getAttribute("loggedInUser");
				List<Story> stories = sc.getAllStoriesByAuthor(request, response, a);
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.getWriter().append(gson.toJson(stories));
				break;
			}
			
			case "/StoryPitch-2/authorSignup": {
				AppLogger.logger.info("Author signing up");
				System.out.println("Creating a new author...");
				ac.createAuthor(request, response);
				response.setHeader("Access-Control-Allow-Origin", "*");
				break;
			}
	
			case "/StoryPitch-2/authors/id": {
				AppLogger.logger.info("Author logging in.");
				System.out.println("Author logging in...");
				response.setHeader("Access-Control-Allow-Origin", "*");
				a = ac.getAuthorById(request, response);
				session.setAttribute("loggedInUser", a);
				System.out.println(a);
				response.getWriter().append(gson.toJson(s));
				break;
			}
			
			case "/StoryPitch-2/story/id": {
				System.out.println("Grabbing story...");
				s = sc.getStoryById(request, response, s);
				session.setAttribute("currentStory", s);
				System.out.println(s);
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.getWriter().append(gson.toJson(s));
				break;
			}
			
			case "/StoryPitch-2/editors/id": {
				AppLogger.logger.info("Editor logging in.");
				System.out.println("Editor Logging in...");
				e = ec.getEditorById(request, response);
				System.out.println(e);
				session.setAttribute("loggedInEditor", e);
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.getWriter().append(gson.toJson(e));
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
			
			case "/StoryPitch-2/authors/holdStories": {
				System.out.println("Getting Author's Pending Stories...");
				a = (Author) session.getAttribute("loggedInUser");
				sc.getAllHoldStoriesByAuthor(request, response, a);
				response.setHeader("Access-Control-Allow-Origin", "*");
				break;
			}
			
			case "/StoryPitch-2/authors/approvedStories": {
				System.out.println("Getting Author's approved stories...");
				a = (Author) session.getAttribute("loggedInUser");
				sc.getAllApprovedStoriesByAuthor(request, response, a);
				response.setHeader("Access-Control-Allow-Origin", "*");
				break;
			}
			
			case "/StoryPitch-2/uploadDraft": {
				System.out.println("Submitting draft...");
				Story sChange = gson.fromJson(request.getReader(), Story.class);
				s = (Story) session.getAttribute("currentStory");
				sc.submitDraft(request, response, sChange, s);
				response.setHeader("Access-Control-Allow-Origin", "*");
				break;
			}
			
			case "/StoryPitch-2/pendingDraft": {
				System.out.println("Getting pending drafts...");
				e = (Editor) session.getAttribute("loggedInEditor");
				sc.getPendingDrafts(request, response, s, e);
				response.setHeader("Access-Control-Allow-Origin", "*");
				break;
			}
			
			case "/StoryPitch-2/approveDraft": {
				System.out.println("Approving draft...");
				e = (Editor) session.getAttribute("loggedInEditor");
				sc.approveDraft(request, response, s, e);
				response.setHeader("Access-Control-Allow-Origin", "*");
				break;
			}
			
			// make case for showing editor the draft's waiting 
			// call sc.submitDraft sChange editor Draft to approved 
			
			case "/StoryPitch-2/pendingStories": {
				System.out.println("Getting all Pending stories...");
				e = (Editor) session.getAttribute("loggedInEditor");
				sc.getAllPendingStories(request, response);
				response.setHeader("Access-Control-Allow-Origin", "*");
				break;
			}
			
			case "/StoryPitch-2/asst/priorityStories": {
				System.out.println("Getting all priority stories...");
				e = (Editor) session.getAttribute("loggedInEditor");
				sc.getAllAsstPriorityStories(request, response, e.getGenre());
				response.setHeader("Access-Control-Allow-Origin", "*");
				break;
			}
			
			case "/StoryPitch-2/asst/stories": {
				System.out.println("Getting all Assistant Pending Stories...");
				e = (Editor) session.getAttribute("loggedInEditor");
				sc.getAllAsstPendingStories(request, response, e.getGenre());
				response.setHeader("Access-Control-Allow-Origin", "*");
				break;
			}
			
			case "/StoryPitch-2/gen/priorityStories": {
				System.out.println("Getting all General priority stories...");
				e = (Editor) session.getAttribute("loggedInEditor");
				sc.getAllGenPriorityStories(request, response);
				response.setHeader("Access-Control-Allow-Origin", "*");
				break;
			}
			
			case "/StoryPitch-2/gen/stories": {
				System.out.println("Getting all General Pending Stories");
				e = (Editor) session.getAttribute("loggedInEditor");
				sc.getAllGenPendingStories(request, response, e);
				response.setHeader("Access-Control-Allow-Origin", "*");
				break;
			}
			
			case "/StoryPitch-2/sen/stories": {
				System.out.println("Getting all Senior Pending Stories");
				e = (Editor) session.getAttribute("loggedInEditor");
				sc.getAllSenPendingStories(request, response, e.getGenre());
				response.setHeader("Access-Control-Allow-Origin", "*");
				break;
			}
			
			case "/StoryPitch-2/sen/priorityStories": {
				System.out.println("Getting all Senior priority stories...");
				e = (Editor) session.getAttribute("loggedInEditor");
				sc.getAllSenPriorityStories(request, response, e.getGenre());
				response.setHeader("Access-Control-Allow-Origin", "*");
				break;
			}
			
			case "/StoryPitch-2/currentStory": {
				System.out.println("Grabbing story...");
				s = sc.getStoryById(request, response, s);
				session.setAttribute("currentStory", s);
				System.out.println(s);
				response.getWriter().append(gson.toJson(s));
				break;
			}
			
			case "/StoryPitch-2/resubmit" : {
				System.out.println("Resubmitting story...");
				s = sc.getStoryById(request, response, s);
				session.setAttribute("currentStory", s);
				System.out.println(s);
				sc.resubmitStory(request, response, s);
				response.setHeader("Access-Control-Allow-Origin", "*");
				break;
			}
			
			case "/StoryPitch-2/approveStory": {
				System.out.println("Approving pitch...");
				e = (Editor) session.getAttribute("loggedInEditor");
				s = (Story) session.getAttribute("currentStory");
				sc.updateStories(request, response, e, s);
				response.setHeader("Access-Control-Allow-Origin", "*");
				break;
			}
			
			case "/StoryPitch-2/rejectStory": {
				System.out.println("Rejecting pitch...");
				e = (Editor) session.getAttribute("loggedInEditor");
				s = (Story) session.getAttribute("currentStory");
				sc.rejectStory(request, response, e, s);
				response.setHeader("Access-Control-Allow-Origin", "*");
				break;
			}
			
			case "/StoryPitch-2/submitChange": {
				System.out.println("submitting change...");
				Story sChange = gson.fromJson(request.getReader(), Story.class);
				System.out.println(sChange);
				s = (Story) session.getAttribute("currentStory");
				System.out.println(s);
				sc.senUpdateStory(request, response, sChange, s);
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
			
			case "/StoryPitch-2/logout": {
				System.out.println("Logging out...");
				AppLogger.logger.warn("Ending session.");
				session.invalidate();
				break;
			}
			
	
			default: {
				System.out.println("Reached the default case...");
				response.sendError(418, "BRB making tea...");
			}
		}

	}

}
