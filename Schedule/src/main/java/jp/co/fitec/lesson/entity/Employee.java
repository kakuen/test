package jp.co.fitec.lesson.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 1953548311045658377L;
	
	@Id
	private String employeeId;
	
	private String name;
	private String email;
	private String password;
	
	@ManyToOne(targetEntity = Department.class)
	@JoinColumn(name = "departId",referencedColumnName = "departId")	
	private Department department;
	
	@OneToMany(targetEntity = Event.class,mappedBy = "employee")
	private Set<Event> events;
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Set<Event> getEvents() {
		return events;
	}
	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	@ManyToMany
	@JoinTable(name = "employeeproject",
		joinColumns = @JoinColumn
			(name = "employeeId",referencedColumnName = "employeeId"),
		inverseJoinColumns = @JoinColumn
			(name = "projectId",referencedColumnName= "projectId")
			)
	private Set<Project> projects;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	
	

}
