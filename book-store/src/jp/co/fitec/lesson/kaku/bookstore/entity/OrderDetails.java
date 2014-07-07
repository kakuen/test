package jp.co.fitec.lesson.kaku.bookstore.entity;

public class OrderDetails {

	private int sequenceNumber;
	private String isbn;
	private int orderNumber;
	private int quantity;

	public OrderDetails(int sequenceNumber,String isbn,int orderNumber,int quantity){
		this.sequenceNumber = sequenceNumber;
		this.isbn = isbn;
		this.orderNumber = orderNumber;
		this.quantity =  quantity;
	}

	public int getSequenceNumber() {
		return sequenceNumber;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "OrderDetails [sequenceNumber=" + sequenceNumber + ", isbn="
				+ isbn + ", orderNumber=" + orderNumber + ", quantity="
				+ quantity + "]";
	}
	
	
}
