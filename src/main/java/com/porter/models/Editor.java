package com.porter.models;

public class Editor {

	private Integer id;
	private String editorName;
	private String username;
	private String password;
	private Integer genreId;
	private String jobTitle;
	
	public Editor() {
		super();
	}

	public Editor(Integer id, String editorName, String username, String password, Integer genreId, String jobTitle) {
		super();
		this.id = id;
		this.editorName = editorName;
		this.username = username;
		this.password = password;
		this.genreId = genreId;
		this.jobTitle = jobTitle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEditorName() {
		return editorName;
	}

	public void setEditorName(String editorName) {
		this.editorName = editorName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGenreId() {
		return genreId;
	}

	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Override
	public String toString() {
		return "Editor [id=" + id + ", editorName=" + editorName + ", username=" + username + ", password=" + password
				+ ", genreId=" + genreId + ", jobTitle=" + jobTitle + "]";
	}
	
	
}
