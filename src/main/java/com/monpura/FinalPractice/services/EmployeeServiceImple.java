package com.monpura.FinalPractice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.monpura.FinalPractice.Entities.EmployeeEntity;
import com.monpura.FinalPractice.dao.EmployeeDao;



@Service
public class EmployeeServiceImple implements EmployeService {

	private EmployeeDao employeeDao;
	
	
	@Autowired
	public EmployeeServiceImple(EmployeeDao theEmployeeDao) {
		employeeDao = theEmployeeDao;
	}


	@Override
	@Transactional
	public List<EmployeeEntity> findAll() {
		
		return employeeDao.findAll();
	}


	@Override
	@Transactional
	public EmployeeEntity findById(int id) {
	
		return employeeDao.findById(id);
	}


	@Override
	@Transactional
	public void save(EmployeeEntity employeeEntity) {
		employeeDao.save(employeeEntity);
		
	}


	@Override
	@Transactional
	public void deleteById(int id) {
		employeeDao.deleteById(id);
		
	}
	
	
	

}
