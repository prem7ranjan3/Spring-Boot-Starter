package com.details.emp.service;

import java.util.List;
import com.details.emp.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(int id);
	Employee updateEmployee(Employee employee, int id);
	void deleteEmployee(int id) throws Exception;
}
