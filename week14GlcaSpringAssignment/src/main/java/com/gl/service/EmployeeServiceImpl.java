package com.gl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.bean.Employee;
import com.gl.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDAO edao;

	@Override
	public void addEmployee(Employee e) {
		
		edao.addEmployee(e);

	}

	@Override
	public List<Employee> showEmployee() {
		
		return edao.showEmployee();
	}

	@Override
	public void deleteEmployeeById(int id) {
		
		edao.deleteEmployeeById(id);

	}

	@Override
	public Employee showEmployeeById(int id) {
		
		return edao.showEmployeeById(id);
	}

	@Override
	public void updateEmployeeById(Employee e, int id) {
		
		edao.updateEmployeeById(e, id);

	}

}
