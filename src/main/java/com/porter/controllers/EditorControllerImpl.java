package com.porter.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.porter.models.Editor;
import com.porter.services.EditorServices;
import com.porter.services.EditorServicesImpl;

public class EditorControllerImpl implements EditorController {

	private EditorServices es = new EditorServicesImpl();
	private static Gson gson = new Gson();

	@Override
	public Editor createEditor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Editor e = es.createEditor();
		response.getWriter().append(gson.toJson(e));
		return e;
	}

	@Override
	public void getAllEditors(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Editor> editors = es.getAllEditors();
		response.getWriter().append(gson.toJson(editors));
	
	}

//	@Override
//	public Editor getEditorByUsername(HttpServletRequest request, HttpServletResponse response) throws IOException {
//
//	}

	@Override
	public Editor getEditorById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Editor e = gson.fromJson(request.getReader(), Editor.class);

		String username = e.getUsername();
		String password = e.getPassword();

		Editor editor = es.getEditorByUsername(username);

		if (editor.getPassword().equals(password)) {
			return editor;
		} else {
			return null;
		}
	
	}

	@Override
	public void updateEditor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Editor e = gson.fromJson(request.getReader(), Editor.class);
		es.updateEditor(e);
		response.getWriter().append(gson.toJson(e));
	}

	@Override
	public void removeEditor(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Editor e = gson.fromJson(request.getReader(), Editor.class);
		es.removeEditor(e);
		response.getWriter().append(gson.toJson(e));
		
	}

}
