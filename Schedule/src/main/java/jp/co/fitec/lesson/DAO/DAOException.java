package jp.co.fitec.lesson.DAO;

public class DAOException extends Exception {

	private static final long serialVersionUID = -5507235546454413008L;

	private String errorMessage;
	
	public DAOException(Exception e) {
		
		super(e);
		
		errorMessage = "System error has occured. " +
                       "Please contact with your system administrator.";
	}

	@Override
	public String getMessage() {
		return errorMessage;
	}
}
