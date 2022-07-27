package com.details.emp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.details.emp.model.Employee;
import com.details.emp.service.EmployeeService;

@Service
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService employeeservice;

	public EmployeeController(EmployeeService employeeservice) {
		super();
		this.employeeservice = employeeservice;
	}

	//to post the api request 
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeservice.saveEmployee(employee),HttpStatus.CREATED);
	}
	//to get the api requested details
	@GetMapping
	public List<Employee> getAllEmployee(){
		return employeeservice.getAllEmployee();

	}
	
	//to get the api by id requested details
	@GetMapping("{id}") public ResponseEntity<Employee>
	getEmployeeById(@PathVariable("id") int employeeid){ return new
			ResponseEntity<Employee>(employeeservice.getEmployeeById(employeeid),
					HttpStatus.OK); }
	
	//to update the api by id requested details
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeservice.updateEmployee(employee,id),HttpStatus.OK);
	}
	
	//to delete the data from api requested details
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) throws Exception{
		employeeservice.deleteEmployee(id);
		return new ResponseEntity<String>("record deleted successfully",HttpStatus.OK);
	}
	

}
