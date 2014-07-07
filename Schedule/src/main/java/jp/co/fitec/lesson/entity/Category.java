package jp.co.fitec.lesson.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category implements Serializable{

	private static final long serialVersionUID = -4503613759736800914L;
	
	@Id
	private String categoryId;
	private String categoryName;
	
	public Category(){}
	
	
	
	public Category(String categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}



	@OneToMany(targetEntity = Event.class,mappedBy = "category")
	private Set<Event> events;
	
	

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

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
