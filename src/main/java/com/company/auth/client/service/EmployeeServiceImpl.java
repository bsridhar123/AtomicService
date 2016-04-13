package com.company.auth.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.company.auth.client.model.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeService{

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	 
	public Employee getEmployee(String id) throws Exception{
		LOGGER.info("Entering");
    	LOGGER.info("Received Id  is :" + id);
    	return new Employee("1","Sridhar");
	}
	
	
	
	 public String createEmployee(Employee employee) throws Exception {
		LOGGER.info("Entering");
    	LOGGER.info("Received Employee Object  is :" + employee.toString());
    	LOGGER.info("Saved Employee Successfully.");
    	LOGGER.info("Leaving createEmployee");
        return employee.getEmpno();
    }
}
