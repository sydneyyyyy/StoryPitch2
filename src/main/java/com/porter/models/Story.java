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
	private String dateSubmitted;
	private String ae_approval = "pending";
	private String ge_approval = "pending";
	private String se_approval = "pending";

	public Story() {
		super();
	}


	public Story(Integer id, String authorName, String title, String releaseDate, String tagLine, String description,
			String submitted, boolean isHighPriority, String storyType, String genre, String dateSubmitted,
			String ae_approval, String ge_approval, String se_approval) {
		super();
		this.id = id;
		this.authorName = authorName;
		this.title = title;
		this.releaseDate = releaseDate;
		this.tagLine = tagLine;
		this.description = description;
		this.submitted = submitted;
		this.isHighPriority = isHighPriority;
		this.storyType = storyType;
		this.genre = genre;
		this.dateSubmitted = dateSubmitted;
		this.ae_approval = ae_approval;
		this.ge_approval = ge_approval;
		this.se_approval = se_approval;
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
	
	

	public String getDateSubmitted() {
		return dateSubmitted;
	}


	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}


	public String getAe_approval() {
		return ae_approval;
	}


	public void setAe_approval(String ae_approval) {
		this.ae_approval = ae_approval;
	}


	public String getGe_approval() {
		return ge_approval;
	}


	public void setGe_approval(String ge_approval) {
		this.ge_approval = ge_approval;
	}


	public String getSe_approval() {
		return se_approval;
	}


	public void setSe_approval(String se_approval) {
		this.se_approval = se_approval;
	}


	@Override
	public String toString() {
		return "Story [id=" + id + ", authorName=" + authorName + ", title=" + title + ", releaseDate=" + releaseDate
				+ ", tagLine=" + tagLine + ", description=" + description + ", submitted=" + submitted
				+ ", isHighPriority=" + isHighPriority + ", storyType=" + storyType + ", genre=" + genre
				+ ", dateSubmitted=" + dateSubmitted + ", ae_approval=" + ae_approval + ", ge_approval=" + ge_approval
				+ ", se_approval=" + se_approval + "]";
	}


	


	

	

}
