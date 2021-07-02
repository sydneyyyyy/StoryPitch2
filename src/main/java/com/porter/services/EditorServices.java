package com.porter.services;

import java.util.List;

import com.porter.models.Editor;

public interface EditorServices {
	
	
	public Editor createEditor();

	public List<Editor> getAllEditors();

	public Editor getEditorById(Integer i);
	
	public Editor getEditorByUsername(String username);
	
//	public Editor getEditorByGenreTitle(String genre, String title);

	public boolean updateEditor(Editor eChange);

	public boolean removeEditor(Editor e);

}
