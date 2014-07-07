package jp.co.fitec.lesson.kaku.bookstore.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import jp.co.fitec.lesson.kaku.bookstore.ConnectionUtils;
import jp.co.fitec.lesson.kaku.bookstore.DAOException;
import jp.co.fitec.lesson.kaku.bookstore.entity.Publisher;

public class PublisherDAO {
	
	enum UpdateType{
		insert,update,delete
	}
	
	public List<Publisher> findAll() throws DAOException {
		return findany(null);
	}
	
	public Publisher findBypublisherCode(String index) throws DAOException {
		return findany("" + index).get(0);
	}
	
	
	public int insert(Publisher pblisher) throws DAOException {
		return doany(pblisher,UpdateType.insert);
	}
	
	public int update(Publisher pblisher) throws DAOException {
		return doany(pblisher,UpdateType.update);
	}

	
	public int delete(Publisher pblisher) throws DAOException {
		return doany(pblisher,UpdateType.delete);
	}
	
	
	
	private List<Publisher> findany(String index) throws DAOException {
		
		List<Publisher> list = new ArrayList<>();
		String sql = "select * from publisher ";
		
		if(index != null){
			sql = sql + " where pblisherCode = " ;
		}
	
		try(Connection conn = ConnectionUtils.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)
			){
				while(rs.next()){
					list.add(new Publisher(rs.getString("publisherCode"),rs.getString("publisherName")));
				}
				return (list);
				
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		
		return null;
		
	}
	
	
	private int doany(Publisher publisher,UpdateType updateType) throws DAOException {
//		String publisherCode = publisher.getPublisherCode();
//		String publisherName = publisher.getPublisherName();
		
		String sql = null;
		int count = 0;
		
		Object[] params = null;
		
		
		switch(updateType){
		
		case insert:
			sql = "insert into publisher values(publisherCode = ? , publisherName = ?)";
			params = new Object[]{publisher.getPublisherCode(),publisher.getPublisherName()};
			break;
			
		case update:
			sql = "update publisher set publisherCode = ? , publisherName = ? where publisherCode = ?";
			params = new Object[]{publisher.getPublisherCode(),publisher.getPublisherName(),publisher.getPublisherCode()};
			break;
			
		case delete:
			sql = "delete from publisher where pulisherCode = ? " ;
			params = new Object[]{publisher.getPublisherCode()};
			break;
		}
	
		try(Connection conn = ConnectionUtils.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)
			){
				for (int i = 0; i < params.length; i ++){
					stmt.setObject(i+1,params[i]);
				}
				count = stmt.executeUpdate();
				
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return count;
		
	}

}
