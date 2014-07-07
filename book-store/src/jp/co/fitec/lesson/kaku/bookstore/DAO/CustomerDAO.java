package jp.co.fitec.lesson.kaku.bookstore.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.PSource;

import jp.co.fitec.lesson.kaku.bookstore.ConnectionUtils;
import jp.co.fitec.lesson.kaku.bookstore.DAOException;
import jp.co.fitec.lesson.kaku.bookstore.entity.Customer;

public class CustomerDAO {
	enum UpdateType{
		insert,update,delete
	}

	public List<Customer> findAll() throws DAOException {
		return findany(null);
	}
	
	public Customer findBycustomerCode(String index) throws DAOException {
		return findany("" + index).get(0);
	}
	
	
	public int insert(Customer customer) throws DAOException {
		return doany(customer,UpdateType.insert);
	}
	
	public int update(Customer customer) throws DAOException {
		return doany(customer,UpdateType.update);
	}

	
	public int delete(Customer customer) throws DAOException {
		return doany(customer,UpdateType.delete);
	}
	
	

	
	private List<Customer> findany(String index) throws DAOException {
		
		List<Customer> list = new ArrayList<>();
		String sql = "select * from customer ";
		
		if(index != null){
			sql = sql + " where customerCode = " ;
		}
	
		try(Connection conn = ConnectionUtils.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)
			){
				while(rs.next()){
					list.add(new Customer(rs.getString("customerCode"),rs.getString("name"),rs.getString("address")));
				}
				return (list);
				
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		
		return null;
		
	}
	
	
	private int doany(Customer customer,UpdateType updateType) throws DAOException {
		String customerCode = customer.getCustomerCode();
		String name = customer.getName();
		String address = customer.getAddress();
		
		String sql = null;
		
		switch(updateType){
		case insert:
			sql = "insert into customer values(customerCode = " + customerCode + ", name =" + name + ", address =" + address + ")";
			break;
			
		case update:
			sql = "update customer set name =" + name + ", address =" + address + "where customerCode = " + customerCode;
			break;
			
		case delete:
			sql = "delete from customer where customerCode = " + customerCode ;
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
