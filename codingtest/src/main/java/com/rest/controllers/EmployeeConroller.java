
/**
 * 
 */
package com.rest.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beans.Employee;
import com.service.EmployeeService;

/**
 * @author Admin
 *
 */
@RestController
public class EmployeeConroller {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ResponseEntity<Employee> addEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_ACCEPTABLE);
		}

		boolean employeeAdded = employeeService.adEmployee(employee);

		if (employeeAdded) {
			return new ResponseEntity<Employee>(HttpStatus.OK);
		}

		return new ResponseEntity<Employee>(HttpStatus.NOT_ACCEPTABLE);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") String employeeId) {

		boolean employeeUpdated = employeeService.updateOrDeleteEmployee(employeeId, true);
		if (employeeUpdated)
			return new ResponseEntity<Employee>(HttpStatus.OK);
		else
			return new ResponseEntity<Employee>(HttpStatus.NOT_ACCEPTABLE);

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") String employeeId) {

		boolean employeeUpdated = employeeService.updateOrDeleteEmployee(employeeId, false);
		if (employeeUpdated)
			return new ResponseEntity<Employee>(HttpStatus.OK);
		else
			return new ResponseEntity<Employee>(HttpStatus.NOT_ACCEPTABLE);

	}
}
