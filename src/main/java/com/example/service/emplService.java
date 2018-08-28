package com.example.service;

import java.util.List;

import com.example.model.EmployeeMaster;
import com.example.model.PersonalMaster;
import com.example.model.QualificationMaster;

public interface emplService {

	PersonalMaster AddPerson(PersonalMaster personalMaster);

	List<PersonalMaster> getAllPersonalMaster();

	QualificationMaster AddQuali(QualificationMaster qualificationMaster);

	EmployeeMaster AddEmpl(EmployeeMaster employeeMaster);

	List<EmployeeMaster> getAllEmployeeMaster();
	List<EmployeeMaster> getAllUsers();
	

	List<String> getAllEmployee();

	PersonalMaster findPersonById(long p_Id);

	EmployeeMaster findById(long id);

	void updateUser(EmployeeMaster employeeMaster);

	List<QualificationMaster> getAllQualificationMaster();

	PersonalMaster updatePerson(PersonalMaster personalMaster);

}
