package com.loicimo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter( urlPatterns="/admin") 
public class FilterAdm implements Filter {
	
	public static final String ACCES_CONNECT_ADM = "/connectAdm";
    public static final String ATT_SESSION_ADMIN = "sessionAdmin";
	
    public void init( FilterConfig config ) throws ServletException {
    }

    public void doFilter( ServletRequest req, ServletResponse res, FilterChain chain ) throws IOException,
    ServletException {
		/* Cast des objets request et response */
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		/* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();
		
		if (session.getAttribute( ATT_SESSION_ADMIN ) == null) {
		    /* Redirection vers la page publique */
		    response.sendRedirect( request.getContextPath() + ACCES_CONNECT_ADM );
		} else {
		    /* Affichage de la page restreinte */
		    chain.doFilter( request, response );
		}
    }

    public void destroy() {
    }
}