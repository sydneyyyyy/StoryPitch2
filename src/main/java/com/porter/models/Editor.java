package com.porter.models;

public class Editor {

	private Integer id;
	private String editorName;
	private String username;
	private String password;
	private String genre;
	private String jobTitle;
	
	public Editor() {
		super();
	}

	public Editor(Integer id, String editorName, String username, String password, String genre, String jobTitle) {
		super();
		this.id = id;
		this.editorName = editorName;
		this.username = username;
		this.password = password;
		this.genre = genre;
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

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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
				+ ", genre=" + genre + ", jobTitle=" + jobTitle + "]";
	}
	
	
}
