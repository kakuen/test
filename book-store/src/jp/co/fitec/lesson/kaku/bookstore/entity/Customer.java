package jp.co.fitec.lesson.kaku.bookstore.entity;

public class Customer {
	
	private String customerCode;
	private String name;
	private String address;

	public Customer(String customerCode, String name, String address){
		this.customerCode = customerCode;
		this.name = name;
		this.address = address;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

}
