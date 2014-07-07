package jp.co.fitec.lesson.kaku.bookstore.entity;

public class Publisher {
	private String publisherCode;
	private String publisherName;

	public Publisher(String publisherCode,String publisherName){
		this.publisherCode = publisherCode;
		this.publisherName = publisherName;
	}

	public String getPublisherCode() {
		return publisherCode;
	}

	public String getPublisherName() {
		return publisherName;
	}

	@Override
	public String toString() {
		return "Publisher [publisherCode=" + publisherCode + ", publisherName="
				+ publisherName + "]";
	}
	
	
	

}
