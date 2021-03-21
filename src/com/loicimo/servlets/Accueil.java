package com.loicimo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.loicimo.beans.CommAccueil;
import com.loicimo.dao.CommAccueilDao;
import com.loicimo.dao.DAOFactory;

public class Accueil extends HttpServlet{

    public static final String ATT_COMMENT = "Comment";
	public static final String VUE = "/WEB-INF/accueil.jsp";
    public static final String CONF_DAO_FACTORY = "daofactory";
    
    private CommAccueilDao     commAccueilDao;

    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.commAccueilDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getCommAccueilDao();
    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		
		CommAccueil commAccueil = new CommAccueil();
		commAccueil = commAccueilDao.read( "jadorejquery@unefois.be" );
		/*String name = "Adrien";*/
		
		/*Comment.setFirstName(Comment.);*/
        request.setAttribute( ATT_COMMENT, commAccueil );
		
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}
}
