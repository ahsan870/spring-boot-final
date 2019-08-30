package com.monpura.FinalPractice.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.monpura.FinalPractice.Entities.EmployeeEntity;


@Repository
public class EmployeeRepositoryJPA implements EmployeeDao {

	private EntityManager entityManager;
	
	public EmployeeRepositoryJPA(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	
	
	@Override
	public List<EmployeeEntity> findAll() {
		//Create Query
		Query employee =  entityManager.createQuery("from EmployeeEntity");
		
		//execute Query & get list
		List<EmployeeEntity> employ = employee.getResultList();
		
		//return Query
		return employ;
	}

	@Override
	public EmployeeEntity findById(int theid) {
		
		//Create Query
		EmployeeEntity singleEm = entityManager.find(EmployeeEntity.class, theid);
		
		//retrun result
		return singleEm;
	}

	@Override
	public void save(EmployeeEntity employeeEntity) {
		
		//get and update the employee
		EmployeeEntity employe = entityManager.merge(employeeEntity);
		employeeEntity.setId(employe.getId());
	}

	@Override
	public void deleteById(int deleteid) {
		Query theQuery = entityManager.createQuery("delete from EmployeeEntity where id =:employeId");
		theQuery.setParameter("employeId", deleteid);
		theQuery.executeUpdate();

	}

}
