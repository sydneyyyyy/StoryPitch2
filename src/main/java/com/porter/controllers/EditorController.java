package com.porter.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.porter.models.Editor;

public interface EditorController {
	
	public Editor createEditor(HttpServletRequest request, HttpServletResponse response) throws IOException;

	// getAllEditors
	public List<Editor> getAllEditors(HttpServletRequest request, HttpServletResponse response) throws IOException;

	public Editor getEditorByUsername(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public Editor getEditorById(HttpServletRequest request, HttpServletResponse response) throws IOException;

	// updateEditor
	public boolean updateEditor(HttpServletRequest request, HttpServletResponse response) throws IOException;

	// removeEditor
	public boolean removeEditor(HttpServletRequest request, HttpServletResponse response) throws IOException;
}