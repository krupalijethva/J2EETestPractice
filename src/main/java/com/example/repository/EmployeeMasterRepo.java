package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.EmployeeMaster;

public interface EmployeeMasterRepo extends JpaRepository<EmployeeMaster, Long> {

	//type cast...
	//
	@Query(value = "SELECT tblemployee.*,tblPersonal.fname,tblPersonal.lname,tblPersonal.birthdate,tblPersonal.gender as person_id FROM tblemployee inner join tblpersonal on tblemployee.e_Id=tblpersonal.p_Id", nativeQuery = true)
	List<EmployeeMaster> getAllEmplAndPerson();
	
	
}
