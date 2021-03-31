package com.loicimo.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loicimo.beans.CommAccueil;
import com.loicimo.dao.CommAccueilDao;
import com.loicimo.dao.DAOFactory;

public class AdminDeletComm extends HttpServlet{
	
	public static final String VUE = "/admin";
    public static final String CONF_DAO_FACTORY = "daofactory";

	private CommAccueilDao     commAccueilDao;
	
	 public void init() throws ServletException {
	        /* Récupération d'une instance de notre DAO Utilisateur */
	        this.commAccueilDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getCommAccueilDao();
	 }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		commAccueilDao.delet(request.getParameter("ID"));
		
        response.sendRedirect( request.getContextPath() + VUE );
	}
}
