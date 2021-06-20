package com.porter.models;

public class Author {

	
	// instance variables
	// Constructors
	// Getters and Setters
	// toString()
	
	private Integer id;
	private String name;
	private String username;
	private String password;
	private Integer points = 100;
	
	
	public Author() {
		super();
	}

	public Author(Integer id, String name, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
	}
	

	public Author(Integer id, String name, String username, String password, Integer points) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.password = password;
		this.points = points;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAuthorName() {
		return name;
	}

	public void setAuthorName(String name) {
		this.name = name;
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

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password + ", points="
				+ points + "]";
	}

	
}
