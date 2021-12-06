package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
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
		
		cst1.registerOutParameter(4, Types.DOUBLE);
		cst1.registerOutParameter(5, Types.DOUBLE);
		System.out.println("AccountDAO Created!");
	}
	
	@Override
	public String transferFunds(int srcId, int destId, double amount) throws SQLException {
		//set in parameters
		cst1.setInt(1, srcId);
		cst1.setInt(2, destId);
		cst1.setDouble(3, amount);
		//execute procedure
		cst1.execute();
		//get results stored in out param
		return "Updated SRC Balance: "+cst1.getDouble(4)+"\nUpdated DEST Balance: "+cst1.getDouble(5);
	}

	public void cleanUp() throws SQLException {
		if(cst1 != null)
			cst1.close();
		if(cn != null)
			cn.close();
	}
}
