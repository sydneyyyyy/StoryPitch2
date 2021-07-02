package com.porter.models;

import java.time.LocalDate;

public class Story {

	LocalDate currDate = LocalDate.now();
	
	private Integer id;
	private String authorName;
	private String title;
	private String releaseDate;
	private String tagLine;
	private String description;
	private String pitchStatus = "pending";
	private boolean isHighPriority = false;
	private String storyType; 
	private String genre;
	private String dateSubmitted = currDate.toString();;
	private String ae_approval = "pending";
	private String ge_approval = "pending";
	private String se_approval = "pending";
	private String storyDraft = null;
	private String aeDraft_Approval = null;
	private String geDraft_Approval = null;
	private String seDraft_Approval = null;
	private String draftStatus = null;

	public Story() {
		super();
	}

	public Story(LocalDate currDate, Integer id, String authorName, String title, String releaseDate, String tagLine,
			String description, String pitchStatus, boolean isHighPriority, String storyType, String genre,
			String dateSubmitted, String ae_approval, String ge_approval, String se_approval, String storyDraft,
			String aeDraft_Approval, String geDraft_Approval, String seDraft_Approval, String draftStatus) {
		super();
		this.currDate = currDate;
		this.id = id;
		this.authorName = authorName;
		this.title = title;
		this.releaseDate = releaseDate;
		this.tagLine = tagLine;
		this.description = description;
		this.pitchStatus = pitchStatus;
		this.isHighPriority = isHighPriority;
		this.storyType = storyType;
		this.genre = genre;
		this.dateSubmitted = dateSubmitted;
		this.ae_approval = ae_approval;
		this.ge_approval = ge_approval;
		this.se_approval = se_approval;
		this.storyDraft = storyDraft;
		this.aeDraft_Approval = aeDraft_Approval;
		this.geDraft_Approval = geDraft_Approval;
		this.seDraft_Approval = seDraft_Approval;
		this.draftStatus = draftStatus;
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

	public String getPitchStatus() {
		return pitchStatus;
	}

	public void setPitchStatus(String pitchStatus) {
		this.pitchStatus = pitchStatus;
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
	
	public String getStoryDraft() {
		return storyDraft;
	}

	public void setStoryDraft(String storyDraft) {
		this.storyDraft = storyDraft;
	}

	public String getAeDraft_Approval() {
		return aeDraft_Approval;
	}

	public void setAeDraft_Approval(String aeDraft_Approval) {
		this.aeDraft_Approval = aeDraft_Approval;
	}

	public String getGeDraft_Approval() {
		return geDraft_Approval;
	}

	public void setGeDraft_Approval(String geDraft_Approval) {
		this.geDraft_Approval = geDraft_Approval;
	}

	public String getSeDraft_Approval() {
		return seDraft_Approval;
	}

	public void setSeDraft_Approval(String seDraft_Approval) {
		this.seDraft_Approval = seDraft_Approval;
	}
	
	public String getDraftStatus() {
		return draftStatus;
	}

	public void setDraftStatus(String draftStatus) {
		this.draftStatus = draftStatus;
	}

	@Override
	public String toString() {
		return "Story [id=" + id + ", authorName=" + authorName + ", title=" + title + ", releaseDate=" + releaseDate
				+ ", tagLine=" + tagLine + ", description=" + description + ", pitchStatus=" + pitchStatus
				+ ", isHighPriority=" + isHighPriority + ", storyType=" + storyType + ", genre=" + genre
				+ ", dateSubmitted=" + dateSubmitted + ", ae_approval=" + ae_approval + ", ge_approval=" + ge_approval
				+ ", se_approval=" + se_approval + ", storyDraft=" + storyDraft + ", aeDraft_Approval="
				+ aeDraft_Approval + ", geDraft_Approval=" + geDraft_Approval + ", seDraft_Approval=" + seDraft_Approval
				+ ", draftStatus=" + draftStatus + "]";
	}

	
	

}
