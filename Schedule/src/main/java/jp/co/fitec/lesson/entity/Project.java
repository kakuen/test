package jp.co.fitec.lesson.entity;

import java.io.Serializable;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Project implements Serializable{

	private static final long serialVersionUID = -2878105840889573772L;
	
	@Id
	private String projectId;
	
	private String projectName;
	private Date projectStart;
	private Date projectEnd;
	
	@ManyToMany(mappedBy="projects")
	private Set<Employee> employees;
	
	
	

	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public Date getProjectStart() {
		return projectStart;
	}
	public void setProjectStart(Date projectStart) {
		this.projectStart = projectStart;
	}
	public Date getProjectEnd() {
		return projectEnd;
	}
	public void setProjectEnd(Date projectEnd) {
		this.projectEnd = projectEnd;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectId() {
		return projectId;
	}
	

}
