package jp.co.fitec.lesson.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department implements Serializable{

	private static final long serialVersionUID = 1001372909755209676L;

	@Id
	private String departId;
	private String departName;
	
	@OneToMany(targetEntity = Employee.class,mappedBy = "department")
	private Set<Employee> employees;
	
	
	
	
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getDepartId() {
		return departId;
	}
	
}
