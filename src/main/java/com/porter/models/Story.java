package com.porter.models;

public class Story {

	// instance variables
	// Constructors
	// Getters and Setters
	// toString()

	private Integer id;
	private String authorName;
	private String completeDate;
	private String title;
	private String storyType; // make a list?
	private String genre; // make a list?
	private String tagLine;
	private String desciption;
	private String submitted;
	private boolean isHighPriority;

	public Story() {
		super();
	}

	public Story(Integer id, String authorName, String completeDate, String title, String storyType, String genre, String tagLine,
			String desciption, String submitted, boolean isHighPriority) {
		super();
		this.id = id;
		this.authorName = authorName;
		this.completeDate = completeDate;
		this.title = title;
		this.storyType = storyType;
		this.genre = genre;
		this.tagLine = tagLine;
		this.desciption = desciption;
		this.submitted = submitted;
		this.isHighPriority = isHighPriority;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	public String getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStoryType() {
		return storyType;
	}

	public void setStoryType(String storyType) {
		this.storyType = storyType;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTagLine() {
		return tagLine;
	}

	public void setTagLine(String tagLine) {
		this.tagLine = tagLine;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public boolean getIsHighPriority() {
		return isHighPriority;
	}

	public void setPriority(boolean isHighPriority) {
		this.isHighPriority = isHighPriority;
	}


	@Override
	public String toString() {
		return "Story [id=" + id + ", authorName=" + authorName + ", completeDate=" + completeDate + ", title=" + title
				+ ", storyType=" + storyType + ", genre=" + genre + ", tagLine=" + tagLine + ", desciption="
				+ desciption + ", submitted=" + submitted + ", isHighPriority=" + isHighPriority + "]";
	}

	

}
