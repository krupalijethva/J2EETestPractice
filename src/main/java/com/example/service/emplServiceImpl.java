package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.EmployeeMaster;
import com.example.model.PersonalMaster;
import com.example.model.QualificationMaster;
import com.example.repository.EmployeeMasterRepo;
import com.example.repository.PersonMasterRepo;
import com.example.repository.QualificationMasterRepo;

@Service
public class emplServiceImpl implements emplService{

	@Autowired
	PersonMasterRepo PersonMasterRepo; //
	
	@Autowired
	EmployeeMasterRepo EmployeeMasterRepo;
	
	@Autowired
	QualificationMasterRepo QualificationMasterRepo;
	
	@Override
	public PersonalMaster AddPerson(PersonalMaster personalMaster) {
		// TODO Auto-generated method stub
		return PersonMasterRepo.save(personalMaster);
	}

	@Override
	public List<PersonalMaster> getAllPersonalMaster() {
		// TODO Auto-generated method stub
		return PersonMasterRepo.findAll();
	}

	@Override
	public QualificationMaster AddQuali(QualificationMaster qualificationMaster) {
		// TODO Auto-generated method stub
		return QualificationMasterRepo.save(qualificationMaster);
	}

	@Override
	public EmployeeMaster AddEmpl(EmployeeMaster employeeMaster) {
		// TODO Auto-generated method stub
		return EmployeeMasterRepo.save(employeeMaster);
	}

	@Override
	public List<EmployeeMaster> getAllEmployeeMaster() {
		// TODO Auto-generated method stub
		return EmployeeMasterRepo.findAll();
	}

	@Override
	public List<String> getAllEmployee() {
		// TODO Auto-generated method stub
		return PersonMasterRepo.getAllEmpl(); // ok kr.. tu
	}

	@Override
	public PersonalMaster findPersonById(long p_Id) {
		// TODO Auto-generated method stub
		return PersonMasterRepo.findOne(p_Id);
	}

	@Override
	public List<EmployeeMaster> getAllUsers() {
		// TODO Auto-generated method stub
		return  EmployeeMasterRepo.getAllEmplAndPerson();//wait
	}

	@Override
	public EmployeeMaster findById(long id) {
		// TODO Auto-generated method stub
		return EmployeeMasterRepo.findOne(id);
	}

	@Override
	public void updateUser(EmployeeMaster employeeMaster) {
		// TODO Auto-generated method stub
		EmployeeMasterRepo.save(employeeMaster);
	}

	@Override
	public List<QualificationMaster> getAllQualificationMaster() {
		// TODO Auto-generated method stub
		return QualificationMasterRepo.findAll();
	}

	@Override
	public PersonalMaster updatePerson(PersonalMaster personalMaster) {
		// TODO Auto-generated method stub
		return PersonMasterRepo.save(personalMaster);
	}
	
	
	

}
