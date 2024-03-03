package com.gl.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.gl.bean.Employee;

@Repository
@EnableTransactionManagement
public class EmployeeDAOImpl implements EmployeeDAO {
	
	SessionFactory sf;
	Session session;
	
	public EmployeeDAOImpl(SessionFactory sf) {
		this.sf=sf;
		this.session=sf.openSession();
	}

	@Transactional
	@Override
	public void addEmployee(Employee e) {
		
		Transaction tx=session.beginTransaction();
		session.save(e);
		tx.commit();
	}

	
	@Override
	public List<Employee> showEmployee() {
		
		
		return (List<Employee>) session.createQuery("from Employee").list();
		
	}

	@Transactional
	@Override
	public void deleteEmployeeById(int id) {
		Transaction tx=session.beginTransaction();
		Employee e1=showEmployeeById(id);
		if(e1!=null) {
			session.delete(e1);
		}
		else {
			System.out.println("Student id doesn't exist");
		}
		tx.commit();
	}
	
	@Override
	public Employee showEmployeeById(int id)
	{
		return session.get(Employee.class, id);
	}

	@Transactional
	@Override
	public void updateEmployeeById(Employee e,int id) {
		
		Transaction tx=session.beginTransaction();
		Employee oldEmp=showEmployeeById(id);
		oldEmp.setEmployeeAddress(e.getEmployeeAddress());
		oldEmp.setEmployeeName(e.getEmployeeName());
		oldEmp.setEmployeePhone(e.getEmployeePhone());
		oldEmp.setEmployeeSalary(e.getEmployeeSalary());
		session.saveOrUpdate(oldEmp);
		tx.commit();
		
	}

}
