package jp.co.fitec.lesson.kaku.bookstore;

public class DAOException extends Exception {
	
	public DAOException(Exception e) {
		super("An exception occured in the DAO layer:", e);
	}
}
