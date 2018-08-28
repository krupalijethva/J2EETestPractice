package com.example.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.tomcat.jni.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.model.EmployeeMaster;
import com.example.model.PersonalMaster;
import com.example.model.QualificationMaster;
import com.example.model.Users;
import com.example.service.emplService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class EmployeeController {

	@Autowired
	emplService emplService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getHomePage() {
		return "/employeeForm";
	}

	@RequestMapping(value = "/AddEmpl/", method = RequestMethod.POST)
	public ResponseEntity<Void> createPerson(@RequestBody String EmployeeDetails, UriComponentsBuilder ucBuilder)
			throws JSONException, JsonParseException, JsonMappingException, IOException, ParseException {

		System.out.println(EmployeeDetails);

		ObjectMapper mapper = new ObjectMapper();
		String EmployeeMasterJson = null;
		String PersonalMasterJson = null;

		JSONObject outerObject = new JSONObject(EmployeeDetails);

		String fname = outerObject.getString("fname");
		String lname = outerObject.getString("lname");

		String birthdate = outerObject.getString("dob");
		String birthdate1 = birthdate.substring(0, 10);

		String gender = outerObject.getString("gender");

		PersonalMasterJson = "{\"fname\":\"" + fname + "\",\"lname\":\"" + lname + "\",\"birthdate\":\"" + birthdate1
				+ "\",\"gender\":\"" + gender + "\"}";

		System.out.println("PersonalMasterJson" + PersonalMasterJson);

		PersonalMaster personalMaster = mapper.readValue(PersonalMasterJson, PersonalMaster.class);

		personalMaster = emplService.AddPerson(personalMaster);

		// ---------------------------------
		// JSONObject params = (JSONObject) outerObject.get("quali");
		//
		// String param1 = params.getString("Name");
		//
		// System.out.println(params.getString("Name"));
		//
		// QualificationMasterJson = "{\"qualification\":\"" + param1 + "\"}";
		// QualificationMaster qualificationMaster =
		// mapper.readValue(QualificationMasterJson, QualificationMaster.class);
		//
		// qualificationMaster = emplService.AddQuali(qualificationMaster);
		//
		// System.out.println("QualificationMasterJson" + QualificationMasterJson);

		// ---------------------

		String Joiningdate = outerObject.getString("jod");
		String Joiningdate1 = Joiningdate.substring(0, 10);

		long salary = outerObject.getInt("salary");
		String isfresher = outerObject.getString("isfresher");

		EmployeeMasterJson = "{\"joiningdate\":\"" + Joiningdate1 + "\",\"salary\":\"" + salary
				+ "\",\"isfresher_employee\":\"" + isfresher + "\"}";

		System.out.println("EmployeeMasterJson" + EmployeeMasterJson);
		EmployeeMaster employeeMaster = mapper.readValue(EmployeeMasterJson, EmployeeMaster.class);

		employeeMaster.setPersonalMaster(personalMaster);
		// employeeMaster.setQualificationMaster(qualificationMaster);
		employeeMaster = emplService.AddEmpl(employeeMaster);
		System.out.println("In Add.."+employeeMaster.toString());
		// ------------------------------
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/updateEmpl/{id}", method = RequestMethod.POST)
	public ResponseEntity<Void> updateUser(@PathVariable("id") long id, @RequestBody String EmployeeDetails,
			UriComponentsBuilder ucBuilder)
			throws JSONException, JsonParseException, JsonMappingException, IOException, ParseException {

		System.out.println("Updating User " + id);
		System.out.println(EmployeeDetails + "In Update");

		EmployeeMaster employeeMaster = emplService.findById(id);

		if (employeeMaster == null) {
			System.out.println("User with id " + id + " not found");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}

		ObjectMapper mapper = new ObjectMapper();
		String EmployeeMasterJson = null;
		String PersonalMasterJson = null;

		JSONObject outerObject = new JSONObject(EmployeeDetails);

		String p_id = outerObject.getString("id");
		String fname = outerObject.getString("fname");
		String lname = outerObject.getString("lname");

		String birthdate = outerObject.getString("dob");
		String birthdate1 = birthdate.substring(0, 10);

		String gender = outerObject.getString("gender");

		PersonalMasterJson = "{\"p_Id\":\"" + p_id + "\",\"fname\":\"" + fname + "\",\"lname\":\"" + lname
				+ "\",\"birthdate\":\"" + birthdate1 + "\",\"gender\":\"" + gender + "\"}";

		System.out.println("PersonalMasterJson" + PersonalMasterJson);

		PersonalMaster personalMaster = mapper.readValue(PersonalMasterJson, PersonalMaster.class);

		personalMaster = emplService.updatePerson(personalMaster);

		String Joiningdate = outerObject.getString("jod");
		String Joiningdate1 = Joiningdate.substring(0, 10);

		long salary = outerObject.getInt("salary");
		String isfresher = outerObject.getString("isfresher");
		EmployeeMasterJson = "{\"e_Id\":\"" + id + "\",\"joiningdate\":\"" + Joiningdate1 + "\",\"salary\":\"" + salary
				+ "\",\"isfresher_employee\":\"" + isfresher + "\"}";

		System.out.println("EmployeeMasterJson" + EmployeeMasterJson);
		employeeMaster = mapper.readValue(EmployeeMasterJson, EmployeeMaster.class);
		employeeMaster.setPersonalMaster(personalMaster);

		System.out.println("--------------" + employeeMaster.toString());
		emplService.updateUser(employeeMaster);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/AllQuali", method = RequestMethod.GET) // get alldocs
	public ResponseEntity<List<QualificationMaster>> listQualificationMaster() {

		List<QualificationMaster> qualis = emplService.getAllQualificationMaster();

		if (qualis.isEmpty()) {
			return new ResponseEntity<List<QualificationMaster>>(HttpStatus.NO_CONTENT);// You many decide to return
			// HttpStatus.NOT_FOUND
		}

		return new ResponseEntity<List<QualificationMaster>>(qualis, HttpStatus.OK);
	}

	@RequestMapping(value = "/AllEmpl", method = RequestMethod.GET)
	public ResponseEntity<List<Users>> listAllUsers() {

		List<EmployeeMaster> users = emplService.getAllUsers();
		System.out.println(users.size());
		List<Users> tmpUsers = new ArrayList<>();
		for (EmployeeMaster empl : users) {
			Users user = new Users();
			// lets run
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String dob = dateFormat.format(empl.getPersonalMaster().getBirthdate());
			String job = dateFormat.format(empl.getJoiningdate());
			user.setDob(dob);
			user.setId(String.valueOf(empl.getE_Id()));
			user.setFname(empl.getPersonalMaster().getFname());
			user.setLname(empl.getPersonalMaster().getLname());
			// user.setQuali(empl.getQualificationMaster().getQualification());
			user.setIsfrehser(empl.getIsfresher_employee());
			user.setJod(job);
			user.setSalary(String.valueOf(empl.getSalary()));

			PersonalMaster personalMaster = emplService.findPersonById(empl.getPersonalMaster().getP_Id());
			empl.setPersonalMaster(personalMaster);
			tmpUsers.add(user);
		}

		if (tmpUsers.isEmpty()) {
			return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);// You many decide to return
																			// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Users>>(tmpUsers, HttpStatus.OK);
	}

}
