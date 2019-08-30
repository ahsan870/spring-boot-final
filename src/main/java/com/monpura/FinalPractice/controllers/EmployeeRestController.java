package com.monpura.FinalPractice.controllers;

import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.monpura.FinalPractice.Entities.EmployeeEntity;
import com.monpura.FinalPractice.services.EmployeService;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private EmployeService employeService;
	
	@Autowired
	public EmployeeRestController(EmployeService theemployeService) {
		employeService = theemployeService;
	}
//expose/employees and return result
	@GetMapping("/employees")
	public List<EmployeeEntity> findAll(){
		return employeService.findAll();
	}
	
	//expose/employees and return result
	@GetMapping("/employees/{employeeId}")
	public EmployeeEntity getEmployee(@PathVariable int employeeId ) {
		EmployeeEntity  employee = employeService.findById(employeeId);
		
		if (employee == null) {
			throw new RuntimeException("Employee ID is not found "+employeeId) ;	
		}
		return employee;
		
	}	
	@PostMapping("/employee")
	public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
		employeeEntity.setId(0);
		employeService.save(employeeEntity);
		return employeeEntity;
		
	}
	@PutMapping("/update")
	public EmployeeEntity UpdateEmployee(@RequestBody EmployeeEntity employeeEntity) {
	
		employeService.save(employeeEntity);
		return employeeEntity;
		
	}
	/*
	
	@DeleteMapping("/employees/{employeeId}")
	public String DeleteId(@PathVariable int employeeId ) {
		
		EmployeeEntity employee = employeService.findById(employeeId);
		
		if (employee == null) {
			throw new RuntimeException("This id is not found " +employeeId);
		}
		employeService.deleteById(employeeId);
		
		return "Delete employee id " +employeeId;
	}
	
	*/
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		
		EmployeeEntity tempEmployee = employeService.findById(employeeId);
		
		// throw exception if null
		
		if (tempEmployee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		
		employeService.deleteById(employeeId);
		
		return "Deleted employee id - " + employeeId;
	}
}
