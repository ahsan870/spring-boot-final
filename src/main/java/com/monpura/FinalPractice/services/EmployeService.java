package com.monpura.FinalPractice.services;

import java.util.List;

import com.monpura.FinalPractice.Entities.EmployeeEntity;

public interface EmployeService {

	public List<EmployeeEntity> findAll();
	
	public EmployeeEntity findById(int id);
	
	public void save(EmployeeEntity employeeEntity);
	
	public void deleteById(int id);
	
}
