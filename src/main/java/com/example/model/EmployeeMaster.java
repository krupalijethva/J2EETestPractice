package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tblEmployee")//from table tblEmployee 6e?ok?ha
public class EmployeeMaster {

	

	@Id
	@Column(name = "e_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)//aa rhi
	private long e_Id;
	
	private Date Joiningdate;	
	private long Salary;
	private String isfresher_employee;
	
	
	
	//getter setter 
	@Override
	public String toString() {
		return "EmployeeMaster [e_Id=" + e_Id + ", Joiningdate=" + Joiningdate + ", Salary=" + Salary
				+ ", isfresher_employee=" + isfresher_employee + ", personalMaster="
				+ personalMaster.toString() + ", qualificationMaster=" + qualificationMaster + "]";
	}
//

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "p_Id",nullable = true)
	public PersonalMaster personalMaster;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "q_Id",nullable = true)
	public QualificationMaster qualificationMaster;

	public long getE_Id() {
		return e_Id;
	}



	public void setE_Id(long e_Id) {
		this.e_Id = e_Id;
	}

	public Date getJoiningdate() {
		return Joiningdate;
	}

	public void setJoiningdate(Date joiningdate) {
		Joiningdate = joiningdate;
	}

	public long getSalary() {
		return Salary;
	}

	public void setSalary(long salary) {
		Salary = salary;
	}

	//auto getter 


	public String getIsfresher_employee() {
		return isfresher_employee;
	}

	public void setIsfresher_employee(String isfresher_employee) {
		this.isfresher_employee = isfresher_employee;
	}

	public PersonalMaster getPersonalMaster() {
		return personalMaster;
	}

	public void setPersonalMaster(PersonalMaster personalMaster) {
		this.personalMaster = personalMaster;
	}

	public QualificationMaster getQualificationMaster() {
		return qualificationMaster;
	}

	public void setQualificationMaster(QualificationMaster qualificationMaster) {
		this.qualificationMaster = qualificationMaster;
	}
	
	
	


}
