package com.hrms.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "employee_master2")
public class Employee_MasterData2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer emp_id;
	private String email_id;
	private String employee_name;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_on;
	private String description;
	
	public Integer getemp_Id() {
		return emp_id;
	}
	public void setId(Integer emp_id) {
		this.emp_id = emp_id;
	}
	public String getemail_id() {
		return email_id;
	}
	public void setemail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getemployee_name() {
		return employee_name;
	}
	public void setemployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}
	public String getdescription(){
         return description;
	}
    public void setdescription(String description){
		this.description=description;
	}	
	@Override
	public String toString() {
		return "EmployeeMaster{" +
				"emp_id=" + emp_id +
				", email_id='" + email_id + '\'' +
				", employee_name=" + employee_name +
				", created_on=" + created_on +
				", description=' " + description + '\'' +
				'}';
	}
}
