package tester;

import java.util.Scanner;

import dao.EmployeeDaoImpl;

public class TestLayeredApp {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)){
			//create single DAO instance //initialization phase
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			//client request servicing phase
			System.out.println("Enter deptID, Start Date, End Date");
			//call DAO's method for data access logic
			System.out.println("Selected EMPS");
			dao.getSelectedEmployees(sc.next(), sc.next(), sc.next()).forEach(System.out::println);
			//cleanup db resources
			dao.cleanUp();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
