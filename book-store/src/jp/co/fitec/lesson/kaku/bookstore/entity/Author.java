package jp.co.fitec.lesson.kaku.bookstore.entity;

public class Author {

	private String authorCode;
	private String authorName;

	public Author(String authorCode,String authorName){
		this.authorCode = authorCode;
		this.authorName = authorName;
		
	}

	public String getAuthorCode() {
		return authorCode;
	}

	public String getAuthorName() {
		return authorName;
	}

	@Override
	public String toString() {
		return "Author [authorCode=" + authorCode + ", authorName="
				+ authorName + "]";
	}
	
	
}
