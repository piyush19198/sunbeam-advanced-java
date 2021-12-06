package tester;

import java.sql.Date;
import java.util.Scanner;

import dao.EmployeeDaoImpl;
import pojos.Employee;

public class TestLayeredAppCRUD {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			// create single dao instance : init phase of the app
			EmployeeDaoImpl dao = new EmployeeDaoImpl();
			boolean exit = false;
			while (!exit) {
				// clnt request servicing phase
				System.out.println(
						"Options : 1. Get selected emps 2. Hire Emp 3. Update Emp details 4. Delete Emp Details 5.Exit");
				try {
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter dept , start date n end date");
						System.out.println("Selected emps ");
						// simply call dao's method : for Data access logic
						dao.getSelectedEmployees(sc.next(), sc.next(), sc.next()).forEach(System.out::println);
						break;
					case 2:
						System.out.println("Enter Employee Details in below sequence\n"
								+"name,  address,  salary,  deptId,  joinDate(yr-mon-day)");
						System.out.println(dao.addEmpDetails(new Employee(sc.next(),sc.next(),sc.nextDouble(),sc.next(),Date.valueOf(sc.next()))));
						break;
					case 3:
						System.out.println("Enter empID,newDept,sal incr");
						System.out.println(dao.updateEmpDetails(sc.nextInt(), sc.next(), sc.nextDouble()));
						break;
					case 4:
						System.out.println("Enter EMP ID to delete");
						System.out.println(dao.deleteEmpDetails(sc.nextInt()));
						break;
					case 5:
						exit = true;
						// clean up db resources
						dao.cleanUp();
						break;
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				sc.nextLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}