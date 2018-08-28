package com.example.model;

public class Users {

	String id,fname,lname,salary,dob,jod,quali,isfrehser;

	public Users(String id, String fname, String lname, String salary, String dob, String jod,String isfrehser,String quali) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.salary = salary;
		this.dob = dob;
		this.jod = jod;
		this.quali=quali;
		this.isfrehser=isfrehser;
	}

	public String getQuali() {
		return quali;
	}

	public String getIsfrehser() {
		return isfrehser;
	}

	public void setIsfrehser(String isfrehser) {
		this.isfrehser = isfrehser;
	}

	public void setQuali(String quali) {
		this.quali = quali;
	}

	public Users() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getJod() {
		return jod;
	}

	public void setJod(String jod) {
		this.jod = jod;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", fname=" + fname + ", lname=" + lname + ", salary=" + salary + ", dob=" + dob
				+ ", jod=" + jod + "]";
	}
	
	
	
	
	
	
}
