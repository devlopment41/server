package com.db.dao;

/**
 * DAOException was created to provide an exception behavior for DAO layer
 * 
 * @author vitaly
 * @since 2.4.2 <br>
 *        based on JDK 1.7 <br>
 *        created at Dec 11, 2013
 */
public class DAOException extends RuntimeException {

	private static final long serialVersionUID = 4519450698183253931L;

	public DAOException(){}

	/**
	 * Constructor.
	 * @param message
	 * @param cause
	 */
	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor.
	 * @param message
	 */
	public DAOException(String message) {
		super(message);
	}

	/**
	 * Constructor.
	 * @param cause
	 */
	public DAOException(Throwable cause) {
		super(cause);
	}
	
	

}
