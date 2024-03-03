package com.gl.service;

import java.util.List;

import com.gl.bean.Employee;

public interface EmployeeService {
	
	public void addEmployee(Employee e);
	public List<Employee> showEmployee();
	public void deleteEmployeeById(int id);
	public Employee showEmployeeById(int id);
	public void updateEmployeeById(Employee e,int id);

}
