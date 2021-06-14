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
	private Integer storyTypeId; // make a list?
	private Integer genreId; // make a list?
	private String tagLine;
	private String desciption;
	private String submitted;
	private boolean isHighPriority;

	public Story() {
		super();
	}

	public Story(Integer id, String authorName, String releaseDate, String title, Integer storyTypeId, Integer genreId, String tagLine,
			String desciption, String submitted, boolean isHighPriority) {
		super();
		this.id = id;
		this.authorName = authorName;
		this.releaseDate = releaseDate;
		this.title = title;
		this.storyTypeId = storyTypeId;
		this.genreId = genreId;
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

	public Integer getStoryTypeId() {
		return storyTypeId;
	}

	public void setStoryTypeId(Integer storyTypeId) {
		this.storyTypeId = storyTypeId;
	}

	public Integer getGenreId() {
		return genreId;
	}

	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
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

	public void setIsHighPriority(boolean isHighPriority) {
		this.isHighPriority = isHighPriority;
	}


	@Override
	public String toString() {
		return "Story [id=" + id + ", authorName=" + authorName + ", releaseDate=" + releaseDate + ", title=" + title
				+ ", storyType=" + storyTypeId + ", genre=" + genreId + ", tagLine=" + tagLine + ", desciption="
				+ desciption + ", submitted=" + submitted + ", isHighPriority=" + isHighPriority + "]";
	}

	

}
