package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.PersonalMaster;

public interface PersonMasterRepo extends JpaRepository<PersonalMaster, Long>{

	String q="SELECT tblP.e_Id,tblP.fname,tblP.lname,tblP.birthdate,tblE.Joiningdate,tblE.Salary FROM tblPersonal tblP inner join tblemployee tblE  on tblP.p_Id=tblE.e_Id";
//	@Query(value = "SELECT tblemployee.e_Id,tblPersonal.fname,tblPersonal.lname,tblPersonal.birthdate,tblemployee.Joiningdate,tblemployee.Salary FROM tblPersonal inner join tblemployee on tblpersonal.p_Id=tblemployee.e_Id", nativeQuery = true)
	@Query(value = q, nativeQuery = true)
	List getAllEmpl();
	
	
	
}
