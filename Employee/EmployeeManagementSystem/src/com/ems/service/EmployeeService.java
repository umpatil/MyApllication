package com.ems.service;

import java.sql.SQLException;
import java.util.List;
import com.ems.beans.Employee;
import com.ems.controler.EmployeeDaoImpl;

public class EmployeeService {

	/**
	 * Used to insert the employee into database
	 * 
	 * @param employee
	 * @throws SQLException
	 */
	public void insert(Employee employee) throws SQLException {
		System.out.println("Inside EmployeeService#insert() method");
		System.out.println(employee);
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		employeeDaoImpl.saveEmployee(employee);
	}

	/**
	 * This method is used to search the employee by he's ID in a Database
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public Employee searchEmployee(int id) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Inside EmployeeService#searchEmployee method");
		System.out.println(id);
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		return employeeDaoImpl.searchEmployee(id);
	}

	public Employee updateEmployee(Employee employeeToUpdate) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Inside EmployeeService#updateEmployee method");
		System.out.println(employeeToUpdate);
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		return employeeDaoImpl.updateEmployee(employeeToUpdate);
	}

	public void deleteEmployee(int id) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Inside EmployeeService#deleteEmployee method");
		System.out.println(id);
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		employeeDaoImpl.deleteEmployee(id);

	}

	public List<Employee> showAllEmployee() throws SQLException {
		// TODO Auto-generated method stub

		System.out.println("Inside EmployeeService#ShowAllEmployee method");
		EmployeeDaoImpl employeeDaoImpl = new EmployeeDaoImpl();
		return employeeDaoImpl.showAllEmployee();
	}

}
