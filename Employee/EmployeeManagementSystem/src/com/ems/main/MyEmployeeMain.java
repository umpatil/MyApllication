package com.ems.main;

import java.util.List;
import java.util.Scanner;

import com.ems.beans.Employee;
import com.ems.service.EmployeeService;

/**
 * This class is used to start Employee Management System.
 * @author umpatil
 *
 */
public class MyEmployeeMain {

	private static EmployeeService employeeService = new EmployeeService();	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		try {
			while(true) {
				System.out.println("\t==========================");
				System.out.println("\tEmployee Management System");
				System.out.println("\t==========================");
				System.out.println("1. Add Employee");
				System.out.println("2. Search Employee");
				System.out.println("3. Update Employee");
				System.out.println("4. Delete Employee");
				System.out.println("5. ShowAll Employee");
				System.out.println("6. Exit");
				System.out.println("Enter the Operation");
				int choice = scanner.nextInt();
				switch(choice) {
					case 1: System.out.println("Add Employee Details: ");
							System.out.println("Enter the Employee ID :");
							int id = scanner.nextInt();
							System.out.println("Enter the Employee FirstName :");
							String firstName = scanner.next();
							System.out.println("Enter the Employee  MiddleName :");
							String middleName = scanner.next();
							System.out.println("Enter the Employee LastName :");
							String lastName = scanner.next();
							System.out.println("Enter the Employee Contact No :");
							long contact = scanner.nextLong();
							System.out.println("Enter the Employee Email Id :");
							String email = scanner.next();
							System.out.println("Enter the Employee Address :");
							String address = scanner.next();
							Employee employee = new Employee(id, firstName, middleName, lastName, contact, email, address);
							employeeService.insert(employee);
					break;
					
					case 2: System.out.println("Search Employee");
					
					  System.out.println("Enter the Employee ID :"); 
					  int empid = scanner.nextInt();
					  Employee employeeSearched = employeeService.searchEmployee(empid);
					  System.out.println(employeeSearched);
							
					break;
					
					case 3: System.out.println("Update Employee");
					
					  System.out.println("Enter the Employee ID to Update the Details :");
					  int empIdToUpdate = scanner.nextInt();
					  //Search Employee
					  Employee employeeToUpdate = employeeService.searchEmployee(empIdToUpdate);
					  
					  //If Employee Found, show employee details. If employee not found, log message. 
					  if(employeeToUpdate == null)
					  {
						  System.out.println("Employee Not Found");
					  }
					  else
					  {
						  //Print The details of Employee
						 System.out.println(employeeToUpdate);
						  
						 //Ask customer updated information
						 System.out.println("Enter the Employee FirstName :");
						 String firstNameToUpdate = scanner.next();
						 employeeToUpdate.setFirstName(firstNameToUpdate);
						 
						 System.out.println("Enter the Employee  MiddleName :");
						 String middleNameToUpdate = scanner.next();
						 employeeToUpdate.setMiddleName(middleNameToUpdate);
						 
						 System.out.println("Enter the Employee LastName :");
						 String lastNameToUpdate = scanner.next();
						 employeeToUpdate.setLastName(lastNameToUpdate);
						 
						 System.out.println("Enter the Employee Contact No :");
						 long contactToUpdate = scanner.nextLong();
						 employeeToUpdate.setContact(contactToUpdate);
						 
						 System.out.println("Enter the Employee Email Id :");
						 String emailToUpdate = scanner.next();
						 employeeToUpdate.setEmail(emailToUpdate);
						 
						 System.out.println("Enter the Employee Address :");
						 String addressToUpdate = scanner.next(); 
						 employeeToUpdate.setAddress(addressToUpdate);
						 employeeService.updateEmployee(employeeToUpdate);
					  }
					  
					 
					break;
					
					case 4: System.out.println("Delete Employee");
							System.out.println("Enter the Employee ID to delete the Details :");
							int emp2id = scanner.nextInt();
							employeeService.deleteEmployee(emp2id);
					break;
					
					case 5: System.out.println("ShowAll Employee");
					
							List<Employee> list =employeeService.showAllEmployee();
							for (Employee employee2 : list) {
								System.out.println("Employee details:"+employee2);
							}
					break;
					
					case 6: System.out.println("Exit Employee");
					scanner.close();
					System.exit(0);
					break;
					
					default:System.out.println("Enter valid option");
					break;
				}
			}
		}
		catch(Exception e) {
			
		}
	}	

}
