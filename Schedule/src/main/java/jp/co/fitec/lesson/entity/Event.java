package jp.co.fitec.lesson.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Event implements Serializable {
	
	private static final long serialVersionUID = -3218481822178211563L;
	
	@Id
	private String eventId;
	private String eventName;
	private Date evenStart;
	private Date eventEnd;
	
	public Event(){}
	public Event(String eventId, String eventName, Date evenStart, Date eventEnd) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.evenStart = evenStart;
		this.eventEnd = eventEnd;
	}

	@ManyToOne(targetEntity = Category.class)
	@JoinColumn(name = "categoryId",referencedColumnName = "categoryId")	
	private Category category;
	
	@ManyToOne(targetEntity = Employee.class)
	@JoinColumn(name = "employeeId",referencedColumnName = "employeeId")	
	private Employee employee;

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEvenStart() {
		return evenStart;
	}

	public void setEvenStart(Date evenStart) {
		this.evenStart = evenStart;
	}

	public Date getEventEnd() {
		return eventEnd;
	}

	public void setEventEnd(Date eventEnd) {
		this.eventEnd = eventEnd;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getEventId() {
		return eventId;
	}
	
	


		
}
