package dao;	//Data Access Object Layer
//DTO Data Transfer Object layer

import java.sql.SQLException;
import java.util.List;

import pojos.Employee;

public interface IEmployeeDao {
	//add a method declaration for getting selected emps
	List<Employee> getSelectedEmployees(String dept, String strtDate, String endDate) throws SQLException;
	//add method declaration for inserting new employee
	String addEmpDetails(Employee newEmp) throws SQLException;
	//add method declaration for updating existing emp details
	String updateEmpDetails(int empId,String newDept,double salIncrement) throws SQLException;
	//add method to delete the emp
	String deleteEmpDetails(int empId) throws SQLException;
}
