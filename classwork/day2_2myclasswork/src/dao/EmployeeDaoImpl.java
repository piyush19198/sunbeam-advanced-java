package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static utils.DBUtils.fetchConnection;

import pojos.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {
	//state is : private non static non transient data members
	private Connection cn;
	private PreparedStatement pst1; //for getting details
	private PreparedStatement pst2;	//for adding new employee
	private PreparedStatement pst3;	//for updating employee
	private PreparedStatement pst4;	//for deleting employee

	public EmployeeDaoImpl() throws ClassNotFoundException,SQLException {
		//Dao's constructor will be invoked by tester in standalone applicaiton
		//get database conneciton
		cn=fetchConnection();
		
		String sql = "select empid,name,salary,join_date from my_emp where deptid=? and join_date between ? and ?";
		pst1=cn.prepareStatement(sql);
		
		pst2=cn.prepareStatement("insert into my_emp values(default,?,?,?,?,?)");
		
		pst3=cn.prepareStatement("update my_emp set deptid=?,salary=salary+? where empid=?");
		
		pst4=cn.prepareStatement("delete from my_emp where empid=?");
		
		System.out.println("EMPLOYEE DAO Created");
	}
	
	//to make sure DB resources are closed
	public void cleanUp() throws SQLException {
		if(pst1 != null)
			pst1.close();
		if(cn != null)
			cn.close();
		if(pst2 != null)
			pst2.close();
		if(pst3 != null)
			pst3.close();
		if(pst4 != null)
			pst4.close();
		System.out.println("EMPLOYEE DAO Cleaned Up!");
	}
	
	@Override
	public List<Employee> getSelectedEmployees(String dept, String strtDate, String endDate) throws SQLException {
		List<Employee> emps = new ArrayList<Employee>();
		pst1.setString(1, dept);
		pst1.setDate(2, Date.valueOf(strtDate));
		pst1.setDate(3, Date.valueOf(endDate));
		//execute query: select : execute query
		try(ResultSet rst = pst1.executeQuery()) {
			while (rst.next()) {
				emps.add(new Employee(rst.getInt(1), rst.getString(2), rst.getDouble(3), rst.getDate(4)));
			}
		}
		return emps;
	}

	@Override
	public String addEmpDetails(Employee newEmp) throws SQLException {
		//set IN parameters
		pst2.setString(1,newEmp.getName());
		pst2.setString(2,newEmp.getAddress());
		pst2.setDouble(3,newEmp.getSalary());
		pst2.setString(4,newEmp.getDeptId());
		pst2.setDate(5,newEmp.getJoinDate());
		
		int updateCount = pst2.executeUpdate();
		if(updateCount == 1)
			return "EMPLOYEE ADDED";
		return "EMPLOYEE NOT ADDED";
	}

	@Override
	public String updateEmpDetails(int empId, String newDept, double salIncrement) throws SQLException {
		//set IN parameters
		pst3.setString(1, newDept);
		pst3.setDouble(2, salIncrement);
		pst3.setInt(3, empId);
		
		int updateCount = pst3.executeUpdate();
		if(updateCount == 1)
			return "EMPLOYEE DETAILS UPDATED";
		return "FAILED TO UPDATE EMPLOYEE DETAILS";
	}

	@Override
	public String deleteEmpDetails(int empId) throws SQLException {
		pst4.setInt(1, empId);
		int updateCount = pst4.executeUpdate();
		if(updateCount==1)
			return "EMPLOYEE DELETED SUCCESSFULLY";
		return "DELETING NOT COMPLETED";
	}

}
