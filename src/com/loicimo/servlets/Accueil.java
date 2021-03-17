package com.loicimo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Accueil extends HttpServlet{
	
	public static final String VUE = "/WEB-INF/accueil.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}
}
