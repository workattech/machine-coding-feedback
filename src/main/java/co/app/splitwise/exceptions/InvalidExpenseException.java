package co.app.splitwise.exceptions;

public class InvalidExpenseException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidExpenseException(String message) {
		super(message);
	}
}
