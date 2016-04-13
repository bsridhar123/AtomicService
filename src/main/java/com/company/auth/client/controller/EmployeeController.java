package com.company.auth.client.controller;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.company.auth.client.model.Employee;
import com.company.auth.client.service.EmployeeService;


@Controller
public class EmployeeController {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
    
	@Autowired
	EmployeeService employeeService;

	

	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getEmployee(@PathVariable String id) throws Exception {
		LOGGER.info("Entering..");
		Employee employee = employeeService.getEmployee(id);
		LOGGER.info("Leaving.");
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	
	


	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public  ResponseEntity<String>  createEmployee(@RequestBody Employee employee) throws Exception {
		
		LOGGER.info("Entering..");
		String  empNo = employeeService.createEmployee(employee);
		
		// Set the location header for the newly created resource
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newQuoteUri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(empNo)
				.toUri();
		responseHeaders.setLocation(newQuoteUri);

		LOGGER.info("Leaving.");
		return new ResponseEntity<>("Created Employee with id: " +empNo, responseHeaders, HttpStatus.CREATED);

	}

	

}
