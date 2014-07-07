package jp.co.fitec.lesson.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Category implements Serializable{

	private static final long serialVersionUID = -4503613759736800914L;
	
	@Id
	private String categoryId;
	
	private String categoryName;
	
	

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryId() {
		return categoryId;
	}
	
	
}
