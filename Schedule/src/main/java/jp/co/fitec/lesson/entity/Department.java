package jp.co.fitec.lesson.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department implements Serializable{

	private static final long serialVersionUID = 1001372909755209676L;

	@Id
	private String departId;
	private String departName;
	
	
	
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
