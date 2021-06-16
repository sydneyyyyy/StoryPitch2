package com.porter.services;

import java.util.List;

import com.porter.models.Editor;

public interface EditorServices {
	
	
	public Editor createEditor(Editor e);

	// getAllEditors
	public List<Editor> getAllEditors();

	// getAllEditorsByGenre - Editors table.genreId.genreName?
	public Editor getEditorById(Integer i);

	// updateEditor
	public boolean updateEditor(Editor eChange);

	// removeEditor
	public boolean removeEditor(Editor e);

}
