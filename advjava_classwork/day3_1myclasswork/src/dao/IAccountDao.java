package dao;

import java.sql.SQLException;

public interface IAccountDao {
	//add a method declaration to transfer the funds
	String transferFunds(int srcId,int destId,double amount) throws SQLException;
}
