package com.porter.services;

import java.util.List;

import com.porter.daos.EditorDAO;
import com.porter.daos.EditorDAOImpl;
import com.porter.models.Editor;

public class EditorServicesImpl implements EditorServices {

	private EditorDAO edao = new EditorDAOImpl();
	
	@Override
	public Editor createEditor() {
		Editor newEditor = new Editor();
		return edao.createEditor(newEditor);
	}

	@Override
	public List<Editor> getAllEditors() {
		return edao.getAllEditors();
	}

	@Override
	public Editor getEditorById(Integer i) {
		return edao.getEditorById(i);
	}
	
	@Override
	public Editor getEditorByUsername(String username) {
		return edao.getEditorByUsername(username);
	}

	@Override
	public boolean updateEditor(Editor eChange) {
		return edao.updateEditor(eChange);
	}

	@Override
	public boolean removeEditor(Editor e) {
		return edao.removeEditor(e);
	}

//	@Override
//	public Editor getEditorByGenreTitle(String genre, String title) {
//		return edao.getEditorByGenreTitle(genre, title);
//	}



}
