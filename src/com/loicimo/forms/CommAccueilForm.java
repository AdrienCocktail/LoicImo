package com.loicimo.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.loicimo.beans.CommAccueil;

public class CommAccueilForm {
	
	private static final String CHAMP_PRENOM = "prenom";
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_COMMENTAIRE = "commentaire";
	private static final String CHAMP_EMAIL = "email";

	private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();
    
    public String getResultat() {
        return resultat;
    }
    
    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
    
    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    public void setErreurs(Map<String, String> erreurs) {
    	this.erreurs = erreurs;
    }
	
	public CommAccueil CommAccueilVal ( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String prenom = getValeurChamp( request, CHAMP_PRENOM );
        String nom = getValeurChamp( request, CHAMP_NOM );
        String commentaire = getValeurChamp( request, CHAMP_COMMENTAIRE );
        String email = getValeurChamp( request, CHAMP_EMAIL );
		
        CommAccueil commAccueil = new CommAccueil();
        
        /* Validation du champ Prenom. */
        try {
            validationPrenom( prenom );
        } catch ( Exception e ) {
            setErreur( CHAMP_PRENOM, e.getMessage() );
        }
        commAccueil.setFirstName( prenom );

        /* Validation du champ Nom. */
        try {
        	validationNom( nom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        commAccueil.setLastName( nom );
        
        /* Validation du champ Message. */
        try {
        	validationCommentaire( commentaire );
        } catch ( Exception e ) {
            setErreur( CHAMP_COMMENTAIRE, e.getMessage() );
        }
        commAccueil.setMessage( commentaire );
        
        /* Validation du champ Email. */
        try {
        	validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        commAccueil.setEmail( email );
        
        if ( erreurs.isEmpty() ) {
            resultat = "Message bien envoyé";
        }
        
		return commAccueil;
	}
	
	private void validationPrenom ( String prenom ) throws Exception {
		if (prenom == null) {
			prenom = "0";
		}
		if ( prenom.length() < 3 || prenom.length() > 10) {
            throw new Exception( "<br>Le prénom doit comporter au minimum 3 caractéres et au maximum 10 caractéres" );
        }
	}
	
	private void validationNom ( String nom ) throws Exception {
		if (nom == null) {
			nom = "0";
		}
		if ( nom.length() < 3 || nom.length() > 10) {
            throw new Exception( "<br>Le nom doit comporter au minimum 3 caractéres et au maximum 10 caractéres" );
        }
	}
	
	private void validationCommentaire ( String commentaire ) throws Exception {
		if (commentaire == null) {
			commentaire = "0";
		}
		if ( commentaire.length() < 3 || commentaire.length() > 250 ) {
            throw new Exception( "<br>Le commentaire doit comporter au minimum 3 caractéres et au maximum 250 caractéres" );
        }
	}
	
	private void validationEmail ( String email ) throws Exception {
		if (email == null) {
			email = "0";
		}
		if ( email.length() < 3 || email.length() > 45 ) {
            throw new Exception( "<br>L'email doit comporter au minimum 3 caractéres et au maximum 45 caractéres" );
        }
	}
	
	private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

	private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}
