package com.loicimo.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.loicimo.beans.Admin;

public class ConnectAdmForm {
	
	private static final String CHAMP_PSEUDO = "pseudo";
	private static final String CHAMP_PASS = "password";

	private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();
    
    public String getResultat() {
        return resultat;
    }
    
    public Map<String, String> getErreurs() {
        return erreurs;
    }
	
	public Admin connecterAdmin ( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String pseudo = getValeurChamp( request, CHAMP_PSEUDO );
        String password = getValeurChamp( request, CHAMP_PASS );
		
        Admin admin = new Admin();
        
        /* Validation du champ email. */
        try {
            validationPseudo( pseudo );
        } catch ( Exception e ) {
            setErreur( CHAMP_PSEUDO, e.getMessage() );
        }
        admin.setPseudo( pseudo );

        /* Validation du champ mot de passe. */
        try {
        	validationPassword( password );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }
        admin.setPassword( password );
        
        if ( !erreurs.isEmpty() ) {
            resultat = "Échec de la connexion.";
        }
        
		return admin;
	}
	
	private void validationPseudo ( String pseudo ) throws Exception {
		if (pseudo == null) {
			pseudo = "null";
		}
		if ( !pseudo.equals("admin") ) {
            throw new Exception( "pseudo incorrect." );
        }
	}
	
	private void validationPassword ( String password ) throws Exception {
       
		if (password == null) {
			password = "null";
		}
		if ( !password.equals("useme123") || password == null) {
            throw new Exception( "Mot de passe incorrect." );
        }
	}
	
	private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
	
	/*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}
