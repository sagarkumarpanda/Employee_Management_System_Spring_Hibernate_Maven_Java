
package com.hpSpring.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import com.hpSpring.model.Employee;


@Repository
public class EmployeeRepo {
	
	@Autowired
	SessionFactory sf;
	
	@Transactional
	public boolean saveEmployee(Employee emp)
	{
		Session ssn =sf.openSession();
		ssn.save(emp);
		
		return true;
	}
	
	@Transactional
	public Employee getEmployee(int empId) {
		Session ssn =sf.openSession();
		return ssn.get(Employee.class, empId);
	}

	@Transactional
	public List<Employee> getAllEmployee(){
		Session ssn =sf.openSession();
		Criteria ctr = ssn.createCriteria(Employee.class);
		return ctr.list();
		
	}
	
	@Transactional
	public boolean deleteEmployee(int empId) {
		Session ssn =sf.openSession();
		Employee emp2 =ssn.get(Employee.class, empId);
		ssn.beginTransaction();
		ssn.remove(emp2);
		ssn.getTransaction().commit();
		return true;
	}
//	
//	@Transactional
//	public boolean updateEmployee(int empId) {
//		Session ssn =sf.openSession();
//		Employee emp2 =ssn.get(Employee.class, empId);
//		ssn.beginTransaction();
//		ssn.update(, object);
//		ssn.getTransaction().commit();
//		return true;
//	}
	
}
