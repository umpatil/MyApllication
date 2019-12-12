package com.ems.controler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ems.beans.Employee;
import com.ems.dbconnection.DatabaseConnection;

public class EmployeeDaoImpl {

	public void saveEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Inside EmployeeDaoImpl#saveEmployee method");
		Connection connection = DatabaseConnection.getConnection();
		Statement statement = connection.createStatement();
		String query = "INSERT INTO EMPLOYEE values(" + employee.getId() + ", " + "'" + employee.getFirstName() + "', "
				+ "'" + employee.getMiddleName() + "', " + "'" + employee.getLastName() + "', " + ""
				+ employee.getContact() + "," + "'" + employee.getEmail() + "', " + "'" + employee.getAddress() + "') ";
		System.out.println("Query : " + query);
		boolean isInserted = statement.execute(query);
		if(isInserted==true){
			System.out.println("Employee Details Add Successfully. ");
		}else
			System.out.println("Not Insert the Data");
			
		

	}

	public Employee searchEmployee(int id) throws SQLException {
		// TODO Auto-generated method stub
		Employee employee = null;
		System.out.println("Inside EmployeeDaoImpl#searchEmployee method");
		Connection connection = DatabaseConnection.getConnection();
		Statement statement = connection.createStatement();

		String query = "SELECT * FROM Employee where id = " + id;
		System.out.println(query);
		// "select * from myDatabase.myTable where name =" + "'" + name + "'"
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			System.out.println("inside result set");
			int employeeId = resultSet.getInt("id");
			String employeefirstName = resultSet.getString("firstName");
			String employeemiddleName = resultSet.getString("middleName");
			String employeelastName = resultSet.getString("lastName");
			long employeecontact = resultSet.getLong("contact");
			String employeeemail = resultSet.getString("email");
			String employeeaddress = resultSet.getString("address");

			employee = new Employee(employeeId, employeefirstName, employeemiddleName, employeelastName,
					employeecontact, employeeemail, employeeaddress);
			break;
		}
		return employee;
	}

	public Employee updateEmployee(Employee employeeToUpdate) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Inside EmployeeDaoImpl#updateEmployee method");
		Connection connection = DatabaseConnection.getConnection();
		Statement statement = connection.createStatement();
		String query = "UPDATE employee SET firstname='" + employeeToUpdate.getFirstName() + "', middlename = '"
				+ employeeToUpdate.getMiddleName() + "', lastname = '" + employeeToUpdate.getLastName() + "', contact="
				+ employeeToUpdate.getContact() + "," + "email='" + employeeToUpdate.getEmail() + "',address='"
				+ employeeToUpdate.getAddress() + "' where id =" + employeeToUpdate.getId();
		System.out.println(query);
		int isUpdated = statement.executeUpdate(query);
		System.out.println("isupdated : " + isUpdated);
		return null;
	}

	public void deleteEmployee(int id) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("Inside EmployeeDaoImpl# deletEmployee method");
		Connection connection = DatabaseConnection.getConnection();
		Statement statement = connection.createStatement();
		System.out.println("EMployee ID :" + id);
		String query = "delete from Employee where id = " + id;
		System.out.println(query);
		statement.executeUpdate(query);
		System.out.println("Record deleted successfully");

	}

	public List<Employee> showAllEmployee() throws SQLException {
		// TODO Auto-generated method stub
		List<Employee> employeeslist = new ArrayList<Employee>();

		// Create Query to fetch all employee records
		System.out.println("Inside EmployeeDaoImpl#showAllEmployee method");
		Connection connection = DatabaseConnection.getConnection();
		Statement statement = connection.createStatement();

		String query = "SELECT * FROM Employee ";
		System.out.println(query);
		// "select * from myDatabase.myTable where name =" + "'" + name + "'"
		ResultSet resultSet = statement.executeQuery(query);

		// Iterate the resultSet to form the employee object as done in search operation
		while (resultSet.next()) {
			System.out.println("inside result set");
			int employeeId = resultSet.getInt("id");
			String employeefirstName = resultSet.getString("firstName");
			String employeemiddleName = resultSet.getString("middleName");
			String employeelastName = resultSet.getString("lastName");
			long employeecontact = resultSet.getLong("contact");
			String employeeemail = resultSet.getString("email");
			String employeeaddress = resultSet.getString("address");

			Employee employee = new Employee(employeeId, employeefirstName, employeemiddleName, employeelastName,
					employeecontact, employeeemail, employeeaddress);

			// Add the employee object to Collection i.e. list
			employeeslist.add(employee);

		}
		// return the list
		return employeeslist;
	}

}
