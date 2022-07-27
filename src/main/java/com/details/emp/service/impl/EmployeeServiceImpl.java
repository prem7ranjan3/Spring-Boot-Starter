package com.details.emp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.details.emp.model.Employee;
import com.details.emp.repository.EmployeeRepo;
import com.details.emp.service.EmployeeService;

@Service
@Repository
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepo emprepo;

	public EmployeeServiceImpl(EmployeeRepo emp) {
		super();
		this.emprepo = emp;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		
		return(emprepo.save(employee));
	}

	@Override
	public List<Employee> getAllEmployee() {
		return emprepo.findAll();
	}

	
	  @Override public Employee getEmployeeById(int id) { Optional<Employee>
	  employee = emprepo.findById(id); if (employee.isPresent()) { return
	  employee.get(); } return employee.get();
	  
	  }

	@Override
	public Employee updateEmployee(Employee employee, int id) {
		Employee existngEmployee = emprepo.findById(id).orElseThrow();
		existngEmployee.setFname(employee.getFname());
		existngEmployee.setLname(employee.getLname());
		existngEmployee.setEmail(employee.getEmail());
				
		emprepo.save(existngEmployee);
		return existngEmployee;
		
	}

	@Override
	public void deleteEmployee(int id) throws Exception {
		//check id exist or not
		emprepo.findById(id).orElseThrow(()-> new Exception("id not exist"));

		emprepo.deleteById(id);
		
	}
	 

}
