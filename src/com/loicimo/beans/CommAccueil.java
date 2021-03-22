package com.loicimo.beans;

public class CommAccueil {
	
		private Long ID;
	 	private String firstName;
	    private String lastName;
	    private String email;
	    private String message;
	    private String date;
	    
	    public void setID( Long ID ) {
	        this.ID = ID;
	    }

	    public Long getID() {
	        return ID;
	    }
	    
	    public void setFirstName( String firstName ) {
	        this.firstName = firstName;
	    }

	    public String getFirstName() {
	        return firstName;
	    }
	    
	    public void setLastName( String lastName ) {
	        this.lastName = lastName;
	    }

	    public String getLastName() {
	        return lastName;
	    }
	    
	    public void setEmail( String email ) {
	        this.email = email;
	    }

	    public String getEmail() {
	        return email;
	    }
	    
	    public void setMessage( String message ) {
	        this.message = message;
	    }

	    public String getMessage() {
	        return message;
	    }
	    
	    public void setDate( String date ) {
	        this.date = date;
	    }

	    public String getDate() {
	        return date;
	    }
}
