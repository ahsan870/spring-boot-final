package com.monpura.FinalPractice.dao;

import java.util.List;

import com.monpura.FinalPractice.Entities.EmployeeEntity;

public interface EmployeeDao {

	public List<EmployeeEntity> findAll();
	
	public EmployeeEntity findById(int theid);
	
	public void save(EmployeeEntity employeeEntity);
	
	public void deleteById(int id);
}
