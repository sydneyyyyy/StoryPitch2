package com.porter.models;

public class StoryType {

	private Integer id;
	private String storyType;
	private Integer points;
	
	public StoryType() {
		super();
	}

	public StoryType(Integer id, String storyType, Integer points) {
		super();
		this.id = id;
		this.storyType = storyType;
		this.points = points;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStoryType() {
		return storyType;
	}

	public void setStoryType(String storyType) {
		this.storyType = storyType;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "StoryType [id=" + id + ", storyType=" + storyType + ", points=" + points + "]";
	}
	
	
}
