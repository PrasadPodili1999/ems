package com.mt.ems.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mt.ems.entity.Employee;
import com.mt.ems.exceptionhandler.EmployeeNotFoundException;
import com.mt.ems.service.EmployeeService;
//import com.sun.tools.sjavac.Log;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/ems")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@ResponseBody
	@RequestMapping("/home")
	public String welcome()
	{
		return "home";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee emp = empService.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.OK).body(emp);
	}

	@RequestMapping(value = "/getEmployee/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable("id") int id) throws EmployeeNotFoundException 
	{
		try
		{
			return ResponseEntity.status(HttpStatus.OK).body(empService.getEmployeeById(id));
		}
		catch(Exception e)
		{
			log.error("Employee Not available"+e);;
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}

	@RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> empList = empService.getAllEmployee();
		return ResponseEntity.status(HttpStatus.OK).body(empList);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
		Employee employee = empService.updateEmployee(emp);
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable("id") int id) throws EmployeeNotFoundException {
		try {
			empService.deleteEmployeeById(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			log.error(e+",there is no such employee with id "+id);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}

	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAllEmployee() throws EmployeeNotFoundException {
		try {
			empService.deleteAllEmployee();
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			log.error(e+",there is no employees present in ur database");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@RequestMapping(value = "/generate", method = RequestMethod.GET)
	public ResponseEntity<Void> generateExcelData()
	{
		try
		{
			empService.generateExcelData();
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		catch(Exception e)
		{
			log.error("something wrong happened");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
