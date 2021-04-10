package com.loicimo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterAdm implements Filter {
	
	public static final String ACCES_CONNECT_ADM = "path";
	
    public void init( FilterConfig config ) throws ServletException {
    }

    public void doFilter( ServletRequest req, ServletResponse res, FilterChain chain ) throws IOException,
    ServletException {
		/* Cast des objets request et response */
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		if (true) {
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