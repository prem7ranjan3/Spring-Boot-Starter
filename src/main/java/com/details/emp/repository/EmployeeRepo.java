package com.details.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.details.emp.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
