package com.company.auth.client.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.company.auth.client.exception.DuplicateResourceException;
import com.company.auth.client.exception.ResourceNotFoundException;

import java.util.HashMap;
import java.util.Map;


import com.company.auth.client.model.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeService{

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	private static Map<String, Employee> employeeMap=new HashMap<String, Employee>();
	
	static {
		employeeMap.put("test", new Employee("test","testEmployee"));
	}
	
	 
	public Employee getEmployee(String id) throws Exception{
		LOGGER.info("Entering");
    	LOGGER.info("Received Id  is :" + id);
    	Employee employee=(Employee) employeeMap.get(id);
    	if(null!=employee){
    		LOGGER.info("Fetched Employee Successfully");
    		LOGGER.info("Leaving getEmployee");
    		return (Employee) employeeMap.get(id);
    	}else{
    		throw new ResourceNotFoundException(
					"Invalid Employee no: " + id + " passed as input ");
    	}
	}
	
	
	
	 public String createEmployee(Employee employee) throws Exception {
LOGGER.info("Entering");
    	LOGGER.info("Received Employee Object  is :" + employee.toString());
    	
    	Employee eEmployee=employeeMap.get(employee.getEmpno());
    	
    	if(null!=eEmployee && eEmployee.getEmpno().equalsIgnoreCase(employee.getEmpno())){
    		throw new DuplicateResourceException(
					"Passed Employee No:" + employee.getEmpno() + " Already Exists");
    	}
    	
    	employeeMap.put(employee.getEmpno(),employee);
    	LOGGER.info("Saved Employee Successfully.");
    	LOGGER.info("Leaving createEmployee");
        return employee.getEmpno();
    }
}
