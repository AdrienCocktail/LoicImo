package com.loicimo.dao;

import com.loicimo.beans.CommAccueil;

public interface CommAccueilDao {

	CommAccueil read( String message) throws DAOException;
}
