package com.porter.models;

public class Story {

	// instance variables
	// Constructors
	// Getters and Setters
	// toString()

	private Integer id;
	private String authorName;
	private String title;
	private String releaseDate;
	private String tagLine;
	private String description;
	private String submitted = "pending";
	private boolean isHighPriority = false;
	private String storyType; 
	private String genre; 

	public Story() {
		super();
	}

	public Story(Integer id, String authorName, String releaseDate, String title, String storyType, String genre, String tagLine,
			String description, String submitted, boolean isHighPriority) {
		super();
		this.id = id;
		this.authorName = authorName;
		this.releaseDate = releaseDate;
		this.title = title;
		this.storyType = storyType;
		this.genre = genre;
		this.tagLine = tagLine;
		this.description = description;
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
	
	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public void setIsHighPriority(boolean isHighPriority) {
		this.isHighPriority = isHighPriority;
	}

	@Override
	public String toString() {
		return "Story [id=" + id + ", authorName=" + authorName + ", title=" + title + ", releaseDate=" + releaseDate
				+ ", tagLine=" + tagLine + ", description=" + description + ", submitted=" + submitted
				+ ", isHighPriority=" + isHighPriority + ", storyType=" + storyType + ", genre=" + genre + "]";
	}


	

	

}
