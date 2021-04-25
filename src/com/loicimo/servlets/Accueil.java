package com.loicimo.servlets;

import java.io.IOException;
import java.util.ArrayList;
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
import com.loicimo.forms.CommAccueilForm;

public class Accueil extends HttpServlet{

    public static final String ATT_COMMENT 			= "Comment";
	public static final String VUE 					= "/WEB-INF/accueil.jsp";
    public static final String CONF_DAO_FACTORY 	= "daofactory";
    
    public static final String ATT_COMMACCUEIL_FORM = "commAccueilForm";
    public static final String ATT_COMMACCUEIL 		= "commAccueil";
    
    public static final String PARAM_PRENOM 		="prenom";
    public static final String PARAM_NOM			="nom";
    public static final String PARAM_COMMENTAIRE 	="commentaire";
    public static final String PRARAM_EMAIL			="email";
    
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
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
			
			List<CommAccueil> listcommAccueil = commAccueilDao.read();
			Map<Long,CommAccueil> mapCommAccueil = new HashMap<Long, CommAccueil>();
			for (CommAccueil commAccueil : listcommAccueil) {
				mapCommAccueil.put( commAccueil.getID(), commAccueil);
			}
			
	        request.setAttribute( ATT_COMMENT, mapCommAccueil );
	        
	        CommAccueilForm commAccueilForm = new CommAccueilForm();
	        CommAccueil commAccueil = commAccueilForm.CommAccueilVal(request);
	        
	        request.setAttribute( ATT_COMMACCUEIL_FORM, commAccueilForm );
	        request.setAttribute( ATT_COMMACCUEIL, commAccueil );
	        
	        if(commAccueilForm.getErreurs().isEmpty()) {
		        commAccueilDao.update(request.getParameter(PARAM_PRENOM),
    					request.getParameter(PARAM_NOM),
    					request.getParameter(PARAM_COMMENTAIRE),
    					request.getParameter(PRARAM_EMAIL));
		        response.reset();
	        }
			
			this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
		}	
}
