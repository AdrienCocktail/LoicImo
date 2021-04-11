package com.loicimo.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loicimo.beans.CommAccueil;
import com.loicimo.dao.CommAccueilDao;
import com.loicimo.dao.DAOFactory;

public class Admin extends HttpServlet {

    public static final String ATT_COMMENT = "Comment";
	public static final String VUE = "/META-INF/restreint/admin.jsp";
    public static final String CONF_DAO_FACTORY = "daofactory";
	
	private CommAccueilDao     commAccueilDao;
	
	 public void init() throws ServletException {
	        /* Récupération d'une instance de notre DAO Utilisateur */
	        this.commAccueilDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getCommAccueilDao();
	 }
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		
		List<CommAccueil> listcommAccueil = commAccueilDao.read();
		Map<Long,CommAccueil> mapCommAccueil = new HashMap<Long, CommAccueil>();
		for (CommAccueil commAccueil : listcommAccueil) {
			mapCommAccueil.put( commAccueil.getID(), commAccueil);
		}
		
        request.setAttribute( ATT_COMMENT, mapCommAccueil );
		
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}
}
