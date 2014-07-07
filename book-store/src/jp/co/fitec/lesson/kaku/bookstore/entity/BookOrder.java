package jp.co.fitec.lesson.kaku.bookstore.entity;

import java.util.Date;

public class BookOrder {
	
	private int orderNumber;
	private Date orderDate;
	private String customerCode;

	public BookOrder(int orderNumber, Date orderDate, String customerCode){
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.customerCode = customerCode;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	@Override
	public String toString() {
		return "BookOrder [orderNumber=" + orderNumber + ", orderDate="
				+ orderDate + ", customerCode=" + customerCode + "]";
	}
	
}
