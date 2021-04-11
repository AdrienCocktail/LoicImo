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
import javax.servlet.http.HttpSession;

import com.loicimo.beans.Admin;
import com.loicimo.beans.CommAccueil;
import com.loicimo.dao.CommAccueilDao;
import com.loicimo.dao.DAOFactory;
import com.loicimo.forms.ConnectAdmForm;

public class ConnectAdm extends HttpServlet{
	
    public static final String ATT_ADMIN         = "admin";
    public static final String ATT_ADMIN_FORM    = "adminForm";
    public static final String ATT_SESSION_ADMIN = "sessionAdmin";

	public static final String VUE_ADMIN = "/admin";
	public static final String VUE_CONNECT_ADMIN = "/WEB-INF/connectAdm.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		
		this.getServletContext().getRequestDispatcher( VUE_CONNECT_ADMIN ).forward( request, response );
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) 
	throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
		ConnectAdmForm adminForm = new ConnectAdmForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Admin admin = adminForm.connecterAdmin( request );

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
        
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_ADMIN_FORM, adminForm );
        request.setAttribute( ATT_ADMIN, admin );

        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Admin à la session, sinon suppression du bean de la session.
         */
        if ( adminForm.getErreurs().isEmpty() ) {
            session.setAttribute( ATT_SESSION_ADMIN, admin );
            response.sendRedirect( request.getContextPath() + VUE_ADMIN );
            
        } else {
            session.setAttribute( ATT_SESSION_ADMIN, null );
            this.getServletContext().getRequestDispatcher( VUE_CONNECT_ADMIN ).forward( request, response );
        }
    }
}
