package com.example.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tblPersonal")
public class PersonalMaster {

	
	@Id
	@Column(name = "p_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long p_Id;
	
	private String fname;
	
	private String lname;
	
	public long getP_Id() {
		return p_Id;
	}


	public void setP_Id(long p_Id) {
		this.p_Id = p_Id;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public Date getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@OneToMany(mappedBy = "personalMaster", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<EmployeeMaster> employeeMasters=new HashSet<>();	

	public Set<EmployeeMaster> getEmployeeMasters() {
		return employeeMasters;
	}


	public void setEmployeeMasters(Set<EmployeeMaster> employeeMasters) {
		this.employeeMasters = employeeMasters;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}
	private Date birthdate;
	private String gender;	
	
	
	
}

