package dao;

import java.sql.*;
import static utils.DBUtils.fetchConnection;
import pojos.Voter;

public class VoterDaoImpl implements IVoterDao {
	private Connection cn;
	private PreparedStatement pst1,pst2;

	public VoterDaoImpl() throws ClassNotFoundException, SQLException {
		// get cn
		cn = fetchConnection();
		pst1 = cn.prepareStatement("select * from voters where name=? and password=?");
		pst2=cn.prepareStatement("update voters set status=true where id=?");
		System.out.println("voter dao created...");
	}

//int id, String name, String email, String password, boolean status, String role
	@Override
	public Voter authenticateUser(String name, String pwd) throws SQLException {
		// set IN params
		pst1.setString(1, name);
		pst1.setString(2, pwd);
		// exec method : execQuery
		try (ResultSet rst = pst1.executeQuery()) {
			if (rst.next())
				return new Voter(rst.getInt(1), name, rst.getString(3), pwd, rst.getBoolean(5), rst.getString(6));
		}
		return null;
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		System.out.println("voter dao cleaned up...");
	}

	@Override
	public String updateVotingStatus(int voterId) throws SQLException {
		// set IN param : voter id
		pst2.setInt(1, voterId);
		//exec update
		int updateCount=pst2.executeUpdate();
		if (updateCount == 1)
			return "Voted successfully....";
		return "Voting status updation failed...";	
	
	}
	

}
