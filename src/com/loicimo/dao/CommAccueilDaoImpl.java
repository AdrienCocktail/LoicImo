package com.loicimo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.loicimo.beans.CommAccueil;
import static com.loicimo.dao.DAOUtilitaire.*;

public class CommAccueilDaoImpl implements CommAccueilDao{
	private DAOFactory          daoFactory;
	
	private static final String SQL_SELECT_ALL = "SELECT * FROM commaccueil";
	private static final String SQL_DELET_ID = "DELETE FROM commaccueil WHERE ID = ?";

	CommAccueilDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

	public List<CommAccueil> read() throws DAOException{
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	    List<CommAccueil> commAccueil = new ArrayList<CommAccueil>();

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = connexion.prepareStatement( SQL_SELECT_ALL );
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while ( resultSet.next() ) {
	        	commAccueil.add(map( resultSet ));
            }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }

	    return commAccueil;
	}
	
	public void delet(String ID) throws DAOException{
		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initialisationRequetePreparee( connexion, SQL_DELET_ID, true, ID );
	        preparedStatement.executeUpdate();
	        
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	    }
	}
	
	private static CommAccueil map( ResultSet resultSet ) throws SQLException {
		CommAccueil commAccueil = new CommAccueil();
		commAccueil.setID( resultSet.getLong( "ID" ) );
		commAccueil.setFirstName( resultSet.getString( "firstName" ) );
		commAccueil.setLastName( resultSet.getString( "lastName" ) );
		commAccueil.setEmail( resultSet.getString( "email" ) );
		commAccueil.setMessage( resultSet.getString( "message" ) );
		/*commAccueil.setDate( resultSet.getString( "date" ) );*/
	    return commAccueil;
	}
}
