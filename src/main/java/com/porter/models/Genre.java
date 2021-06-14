package com.porter.models;

public class Genre {

	private Integer id;
	private String genreName;
	private Integer asstEditorId;
	private Integer seniorEditorId;
	
	public Genre() {
		super();
	}
	
	public Genre(Integer id, String genreName, Integer asstEditorId, Integer seniorEditorId) {
		super();
		this.id = id;
		this.genreName = genreName;
		this.asstEditorId = asstEditorId;
		this.seniorEditorId = seniorEditorId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public Integer getAsstEditorId() {
		return asstEditorId;
	}

	public void setAsstEditorId(Integer asstEditorId) {
		this.asstEditorId = asstEditorId;
	}

	public Integer getSeniorEditorId() {
		return seniorEditorId;
	}

	public void setSeniorEditorId(Integer seniorEditorId) {
		this.seniorEditorId = seniorEditorId;
	}

	@Override
	public String toString() {
		return "Genre [id=" + id + ", genreName=" + genreName + ", asstEditorId=" + asstEditorId + ", seniorEditorId="
				+ seniorEditorId + "]";
	}

	
	
	
}
