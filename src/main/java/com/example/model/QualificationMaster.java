package com.example.model;

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
@Table(name = "tblQualification")
public class QualificationMaster {
	@Id
	@Column(name = "q_Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long q_Id;
	
	private String Qualification;
	
	
	public long getQ_Id() {
		return q_Id;
	}


	@Override
	public String toString() {
		return "QualificationMaster [q_Id=" + q_Id + ", Qualification=" + Qualification + ", employeeMasters="
				+ employeeMasters + "]";
	}


	public void setQ_Id(long q_Id) {
		this.q_Id = q_Id;
	}


	public String getQualification() {
		return Qualification;
	}


	public Set<EmployeeMaster> getEmployeeMasters() {
		return employeeMasters;
	}


	public void setEmployeeMasters(Set<EmployeeMaster> employeeMasters) {
		this.employeeMasters = employeeMasters;
	}


	public void setQualification(String qualification) {
		Qualification = qualification;
	}




	@OneToMany(mappedBy = "qualificationMaster", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private Set<EmployeeMaster> employeeMasters = new HashSet<>();
}
