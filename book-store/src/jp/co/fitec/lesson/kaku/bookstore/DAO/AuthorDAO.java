package jp.co.fitec.lesson.kaku.bookstore.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jp.co.fitec.lesson.kaku.bookstore.ConnectionUtils;
import jp.co.fitec.lesson.kaku.bookstore.DAOException;
import jp.co.fitec.lesson.kaku.bookstore.DAO.CustomerDAO.UpdateType;
import jp.co.fitec.lesson.kaku.bookstore.entity.Author;

public class AuthorDAO {
	enum UpdateType{
		insert,update,delete
	}

	public List<Author> findAll() throws DAOException {
		return findany(null);
	}
	
	public Author findByauthorCode(String index) throws DAOException {
		return findany("" + index).get(0);
	}
	
	
	public int insert(Author author) throws DAOException {
		return doany(author,UpdateType.insert);
	}
	
	public int update(Author author) throws DAOException {
		return doany(author,UpdateType.update);
	}

	
	public int delete(Author author) throws DAOException {
		return doany(author,UpdateType.delete);
	}
	
	

	
	private List<Author> findany(String index) throws DAOException {
		
		List<Author> list = new ArrayList<>();
		String sql = "select * from author ";
		
		if(index != null){
			sql = sql + " where authorCode = " ;
		}
	
		try(Connection conn = ConnectionUtils.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)
			){
				while(rs.next()){
					list.add(new Author(rs.getString("authorCode"),rs.getString("authorName")));
				}
				return (list);
				
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		
		return null;
		
	}
	
	
	private int doany(Author author,UpdateType updateType) throws DAOException {
		String authorCode = author.getAuthorCode();
		String authorName =author.getAuthorName();
		
		String sql = null;
		
		switch(updateType){
		case insert:
			sql = "insert into author values(authorCode = " + authorCode + ", authorName =" + authorName + ")";
			break;
			
		case update:
			sql = "update author set authorName =" + authorName +  " where authorCode = " + authorCode;
			break;
			
		case delete:
			sql = "delete from author where authorCode = " + authorCode ;
			break;
		}
	
		try(Connection conn = ConnectionUtils.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)
			){

			return stmt.executeUpdate();
				
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return 0;
		
	}
}
