package com.loicimo.dao;

import java.util.List;

import com.loicimo.beans.CommAccueil;

public interface CommAccueilDao {

	List<CommAccueil> read() throws DAOException;
	
	void delet(String ID) throws DAOException;
	
	void update(String firstName, String lastName, String email, String message) throws DAOException;
}
