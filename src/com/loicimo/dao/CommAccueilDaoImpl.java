package com.loicimo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.loicimo.beans.CommAccueil;
import static com.loicimo.dao.DAOUtilitaire.*;

public class CommAccueilDaoImpl implements CommAccueilDao{
	private DAOFactory          daoFactory;
	
	private static final String SQL_SELECT_PAR_EMAIL = "SELECT nom FROM Utilisateur WHERE email = ?";

	CommAccueilDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

	public CommAccueil read( String email) throws DAOException{
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    CommAccueil commAccueil = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_PAR_EMAIL, false, email );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        if ( resultSet.next() ) {
	        	commAccueil = map( resultSet );
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }

	    return commAccueil;
	}
	
	private static CommAccueil map( ResultSet resultSet ) throws SQLException {
		CommAccueil commAccueil = new CommAccueil();
		commAccueil.setFirstName( resultSet.getString( "nom" ) );
	    return commAccueil;
	}
}
