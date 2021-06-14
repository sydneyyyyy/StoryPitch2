package com.porter.services;

import java.util.List;

import com.porter.models.Editor;

public interface EditorServices {
	
	
	public Editor createEditor();

	// getAllEditors
	public List<Editor> getAllEditors();

	// getAllEditorsByGenre - Editors table.genreId.genreName?
	public List<Editor> getAllEditorsByGenre(Integer i);

	// updateEditor
	public Editor updateEditor(Integer i);

	// removeEditor
	public boolean removeEditor(Integer i);

}
