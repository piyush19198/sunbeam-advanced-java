package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.CallableStatement;
import static utils.DBUtils.fetchConnection;

public class AccountDaoImpl implements IAccountDao {
	private Connection cn;
	private CallableStatement cst1;
	
	public AccountDaoImpl() throws ClassNotFoundException,SQLException{
		cn = fetchConnection();
		//{call<procedure-name>[(<arg1>,<arg2>,...)]}
		String procInvocation="{call transfer_funds(?,?,?,?,?)}";
		cst1=cn.prepareCall(procInvocation);
		System.out.println("AccountDAO Created!");
	}
	
	@Override
	public String transferFunds(int srcId, int destId, double amount) throws SQLException {
		
		return null;
	}

}
