package com.company.auth.client.service;

import com.company.auth.client.model.Employee;

public interface EmployeeService {
	
	Employee getEmployee(String id) throws Exception;
	String createEmployee(Employee employee) throws Exception;
	
}
