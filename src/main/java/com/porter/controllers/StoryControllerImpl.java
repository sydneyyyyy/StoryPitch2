package com.porter.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.porter.models.Author;
import com.porter.models.Editor;
import com.porter.models.Story;
import com.porter.models.StoryType;
import com.porter.services.AuthorServices;
import com.porter.services.AuthorServicesImpl;
import com.porter.services.EditorServices;
import com.porter.services.EditorServicesImpl;
import com.porter.services.StoryServices;
import com.porter.services.StoryServicesImpl;
import com.porter.services.StoryTypeServices;
import com.porter.services.StoryTypeServicesImpl;

public class StoryControllerImpl implements StoryController {

	private StoryServices ss = new StoryServicesImpl();
	private StoryTypeServices sts = new StoryTypeServicesImpl();
	private AuthorServices as = new AuthorServicesImpl();
	private EditorServices es = new EditorServicesImpl();
	private static Gson gson = new Gson();
	StoryType st = new StoryType();
	
	
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
			s.setPitchStatus("on-hold");
			ss.updateStory(s);
		}
		
		response.getWriter().append(gson.toJson(s));
		return s;
	}
	
	@Override
	public void senUpdateStory(HttpServletRequest request, HttpServletResponse response, Story sChange, Story s) throws IOException {
		String newTitle = sChange.getTitle();
		String newDate = sChange.getReleaseDate();
		String  newTag = sChange.getTagLine();
		s.setTitle(newTitle);
		s.setReleaseDate(newDate);
		s.setTagLine(newTag);
		ss.updateStory(s);
		System.out.println(s);
	}

	@Override
	public void getAllPendingStories(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String status = "pending";
		LocalDate currDate = LocalDate.now();
		List<Story> stories = ss.getAllPendingStories(status);
		System.out.println(stories);
		for (Story s : stories) {
			System.out.println(s);
			String dateString = s.getDateSubmitted();
			LocalDate date = LocalDate.parse(dateString);
			LocalDate highDate = date.plusDays(100); 
			System.out.println(highDate);
			System.out.println(date);
			if (currDate.compareTo(highDate) > 0) {
				System.out.println("Current date is more than 100 days");
				s.setIsHighPriority(true);
				System.out.println(s);
				ss.updateStory(s);
			} else {
				System.out.println("Current date is less than 100 days");
			}

		}
		response.getWriter().append(gson.toJson(stories));

	}

	@Override
	public Story getStoryById(HttpServletRequest request, HttpServletResponse response, Story s) throws IOException {
		s = gson.fromJson(request.getReader(), Story.class);
		int storyId = s.getId();
		System.out.println(storyId);
		s = ss.getStoryById(storyId);
		return s;
	}
	
	@Override
	public List<Story> getAllStoriesByAuthor(HttpServletRequest request, HttpServletResponse response, Author a) throws IOException {
//		String status = "pending";
//		String status2 = "on-hold";
		String authorName = a.getAuthorName();
		System.out.println(authorName);
		List<Story> stories = ss.getAllStoriesByAuthor(authorName);
		System.out.println(stories);
		return stories;
	}
	
	@Override
	public List<Story> getAllHoldStoriesByAuthor(HttpServletRequest request, HttpServletResponse response, Author a)
			throws IOException {
		String submitted = "on-hold";
		String authorName = a.getAuthorName();
		System.out.println(authorName);
		List<Story> stories = ss.getAllPendingStoriesByAuthor(authorName, submitted);
		System.out.println(stories);
		response.getWriter().append(gson.toJson(stories));
		return stories;
	}
	
	@Override
	public List<Story> getAllApprovedStoriesByAuthor(HttpServletRequest request, HttpServletResponse response, Author a)
			throws IOException {
		String submitted = "approved";
		String authorName = a.getAuthorName();
		System.out.println(authorName);
		List<Story> stories = ss.getAllPendingStoriesByAuthor(authorName, submitted);
		System.out.println(stories);
		response.getWriter().append(gson.toJson(stories));
		return stories;
	}
	
	@Override
	public List<Story> getAllAsstPendingStories(HttpServletRequest request, HttpServletResponse response, String genre)
			throws IOException {
		String status = "pending";
		String ae_approval = "pending";
		List<Story> stories = ss.getAllAsstPendingStories(genre, status, ae_approval);
		System.out.println(stories);
		response.getWriter().append(gson.toJson(stories));
		return stories;
	}
	
	@Override
	public List<Story> getAllAsstPriorityStories(HttpServletRequest request, HttpServletResponse response, String genre)
			throws IOException {
		String status = "pending";
		String ae_approval = "pending";
		Boolean priority = true;
		List<Story> stories = ss.getAllAsstPriorityStories(genre, status, priority, ae_approval);
		System.out.println(stories);
		response.getWriter().append(gson.toJson(stories));
		return stories;
	}
	
	@Override
	public List<Story> getAllGenPendingStories(HttpServletRequest request, HttpServletResponse response, Editor e) throws IOException {
		String status = "pending";
		String ae_approval = "approved";
		String ge_approval = "pending";
		List<Story> stories = ss.getAllPendingStories(status, ae_approval, ge_approval);
		System.out.println(stories);
		response.getWriter().append(gson.toJson(stories));
		return stories;
	}
	
	public List<Story> getAllGenPriorityStories(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String status = "pending";
		String ae_approval = "approved";
		String ge_approval = "pending";
		Boolean priority = true;
		List<Story> stories = ss.getAllGenPriorityStories(status, priority, ae_approval, ge_approval);
		System.out.println(stories);
		response.getWriter().append(gson.toJson(stories));
		return stories;
	}
	
	@Override
	public List<Story> getAllSenPendingStories(HttpServletRequest request, HttpServletResponse response, String genre)
			throws IOException {
		String status = "pending";
		Boolean priority = false;
		String ae_approval = "approved";
		String ge_approval = "approved";
		List<Story> stories = ss.getAllSenPendingStories(genre, status, priority, ae_approval, ge_approval);
		System.out.println(stories);
		response.getWriter().append(gson.toJson(stories));
		return stories;
	}

	@Override
	public List<Story> getAllSenPriorityStories(HttpServletRequest request, HttpServletResponse response, String genre)
			throws IOException {
		String status = "pending";
		Boolean priority = true;
		String ae_approval = "approved";
		String ge_approval = "approved";
		String se_approval = "pending";
		List<Story> stories = ss.getAllSenPriorityStories(genre, priority, status, ae_approval, ge_approval, se_approval);
		System.out.println(stories);
		response.getWriter().append(gson.toJson(stories));
		return stories;
	}

	@Override
	public void updateStories(HttpServletRequest request, HttpServletResponse response, Editor e, Story s) throws IOException {
		System.out.println(s);
		String general = "General";
		String asst = "Assistant";
		String sen = "Senior";
		String edRes = "approved";
		String author = s.getAuthorName();
		String story = s.getStoryType();
		if (e.getJobTitle().equalsIgnoreCase(general)) {
			System.out.println("Gen");
			s.setGe_approval(edRes);
			ss.updateStory(s);
		} else if (e.getJobTitle().equalsIgnoreCase(asst)){
			System.out.println("Asst");
			s.setAe_approval(edRes);
			ss.updateStory(s);
			System.out.println(s);
		} else if (e.getJobTitle().equalsIgnoreCase(sen)) {
			System.out.println("Senior");
			s.setSe_approval(edRes);
			s.setPitchStatus("approved");
			ss.updateStory(s);
			System.out.println(s);
			Author a = as.getAuthorByName(author);
			StoryType st = sts.getStoryTypeByName(story);
			int auPoints = a.getPoints();
			int stPoints = st.getPoints();
			int newPoints = stPoints + auPoints;
			a.setPoints(newPoints);
			as.updateAuthor(a);
			
		}
	}
	
	
	@Override
	public List<Story> getPendingDrafts(HttpServletRequest request, HttpServletResponse response, Story s, Editor e)
			throws IOException {
		System.out.println("Getting all pending drafts");
		if (e.getJobTitle().equalsIgnoreCase("Assistant")) {
			System.out.println("i'm an assistant");
			List<Story> stories = ss.getAllPendingDrafts(e.getGenre(), "pending", "pending", "pending");
			System.out.println(stories);
			response.getWriter().append(gson.toJson(stories));
		} else if (e.getJobTitle().equalsIgnoreCase("General")) {
			System.out.println("I'm a general");
			List<Story> stories = ss.getAllPendingDrafts(e.getGenre(), "approved", "pending", "pending");
			System.out.println(stories);
			response.getWriter().append(gson.toJson(stories));
		} else if (e.getJobTitle().equalsIgnoreCase("Senior")) {
			System.out.println("I'm a senior");
			List<Story> stories = ss.getAllPendingDrafts(e.getGenre(), "approved", "approved", "pending");
			System.out.println(stories);
			response.getWriter().append(gson.toJson(stories));
		}
		return null;
	}

	@Override
	public void approveDraft(HttpServletRequest request, HttpServletResponse response, Story s, Editor e)
			throws IOException {
		if (e.getJobTitle().equalsIgnoreCase("Assistant")) {
			System.out.println("Story is not null");
			s.setAeDraft_Approval("approved");
			ss.updateStory(s);
		} else if (e.getJobTitle().equalsIgnoreCase("General")) {
			System.out.println("I'm a general");
			System.out.println("Story is not null");
			s.setGeDraft_Approval("approved");
			ss.updateStory(s);
		} else if (e.getJobTitle().equalsIgnoreCase("Senior")) {
			System.out.println("I'm a senior");
			System.out.println("Story is not null!");
			s.setSeDraft_Approval("approved");
			s.setDraftStatus("approved");
			ss.updateStory(s);
		}
		
	}

	@Override
	public void submitDraft(HttpServletRequest request, HttpServletResponse response, Story sChange, Story s)
			throws IOException {
		String st = s.getStoryType();
		System.out.println(st);
		if (st.equalsIgnoreCase("Novel") || st.equalsIgnoreCase("Novella")) {
			System.out.println("this is novel");
			String aDraft = "pending";
			String gDraft = "pending";
			String sDraft = "pending";
			s.setAeDraft_Approval(aDraft);
			s.setGeDraft_Approval(gDraft);
			s.setSeDraft_Approval(sDraft);
			s.setDraftStatus("pending");
			ss.updateStory(s);
		} else if (st.equalsIgnoreCase("Story-Stories")) {
			System.out.println("this is short stories");
			String aDraft = "approved";
			String gDraft = "pending";
			String sDraft = "pending";
			s.setAeDraft_Approval(aDraft);
			s.setGeDraft_Approval(gDraft);
			s.setSeDraft_Approval(sDraft);
			s.setDraftStatus("pending");
			ss.updateStory(s);
		} else if (st.equalsIgnoreCase("Article")) {
			System.out.println("this is an article");
			String aDraft = "approved";
			String gDraft = "approved";
			String sDraft = "pending";
			s.setAeDraft_Approval(aDraft);
			s.setGeDraft_Approval(gDraft);
			s.setSeDraft_Approval(sDraft);
			s.setDraftStatus("pending");
			ss.updateStory(s);
		}
		
		String draft = sChange.getStoryDraft();
		System.out.println(draft);
		s.setStoryDraft(draft);
		s.setDraftStatus("pending");
		ss.updateStory(s);
		

	}

	@Override
	public void rejectStory(HttpServletRequest request, HttpServletResponse response, Editor e, Story s)
			throws IOException {
		
		if (s.getPitchStatus().equalsIgnoreCase("approved")) {
			System.out.println("deleting draft...");
//			ss.removeStory(s);
			s.setDraftStatus("rejected");
			ss.updateStory(s);
		} else {
			String author = s.getAuthorName();
			String story = s.getStoryType();
			StoryType st = sts.getStoryTypeByName(story);
			Author a = as.getAuthorByName(author);
			int points = st.getPoints();
			ss.removeStory(s);
			int newPoints = a.getPoints() + points;
			a.setPoints(newPoints);
			as.updateAuthor(a);
		}
		
		
	}
	
	@Override
	public Story resubmitStory(HttpServletRequest request, HttpServletResponse response, Story s) throws IOException {
		String submitted = "pending";
		s.setPitchStatus(submitted);
		System.out.println(s);
		String author = s.getAuthorName();
		Author a = as.getAuthorByName(author);
		System.out.println(a);
		StoryType st = sts.getStoryTypeByName(s.getStoryType());
		int points = st.getPoints();
		if (a.getPoints() >= points) {
			System.out.println("Congrats, you re-submitted a story pitch!");
			ss.updateStory(s);
			int newPoints = a.getPoints() - points;
			System.out.println(newPoints);
			a.setPoints(newPoints);
			a.getPoints();
			System.out.println(a);
			as.updateAuthor(a);
		} else {
			System.out.println("You do not have enough points for this re-submission! Story Pitch remains on hold");
		}
		response.getWriter().append(gson.toJson(s));
		return s;
	}

	@Override
	public void deleteStories(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

	}

	

	



	

	

	

	



	

	

	
	

	

	

}
