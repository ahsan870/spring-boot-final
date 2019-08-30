package com.monpura.FinalPractice.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monpura.FinalPractice.Entities.EmployeeEntity;

@Repository
public class EmployeeRepository implements EmployeeDao {

	// Entitymanager

	private EntityManager entitimanager;

	// Constructor injection
	@Autowired
	public EmployeeRepository(EntityManager theEntitymanager) {
		entitimanager = theEntitymanager;
	}

	@Override
	public List<EmployeeEntity> findAll() {
		// get the current hibernate session
		Session currentSession = entitimanager.unwrap(Session.class);

		// create a query
		Query<EmployeeEntity> thequery = currentSession.createQuery("from EmployeeEntity", EmployeeEntity.class);
		// execute query and result list
		List<EmployeeEntity> employeeEntity = thequery.getResultList();

		// reurn the result
		return employeeEntity;
	}

	@Override
	public EmployeeEntity findById(int theid) {
		// get the current hibernate session
		Session currentSession = entitimanager.unwrap(Session.class);

		// create a query
		 EmployeeEntity employee = currentSession.get(EmployeeEntity.class, theid);
		
		// reurn the result
		return employee;
	}

	
	@Override
	public void save(EmployeeEntity employeeEntity) {
		//get the session
		Session currentSession = entitimanager.unwrap(Session.class);
		//save it
		currentSession.saveOrUpdate(employeeEntity);
			
	}

	@Override
	public void deleteById(int id) {
		Session currentSession = entitimanager.unwrap(Session.class);
		Query thequiry = currentSession.createQuery(
				"delete from EmployeEntity where id=:employeeId");
		thequiry.setParameter("employeeId", id);
		thequiry.executeUpdate();
	}

	

	

}
