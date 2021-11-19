package dao;

import static utils.DBUtils.fetchConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojos.Voter;

public class VoterDaoImpl implements IVoterDao {
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;

	public VoterDaoImpl() throws ClassNotFoundException, SQLException {
		cn = fetchConnection();
		pst1 = cn.prepareStatement("select * from voters where name=? and password=?");
		pst2 = cn.prepareStatement("update voters set status = true where id = ?");
		System.out.println("---VOTER DAO CREATED---");
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		System.out.println("---VOTER DAO CLEANED UP---");
	}

	@Override
	public Voter authenticateUser(String name, String pwd) throws SQLException {
		pst1.setString(1, name);
		pst1.setString(2, pwd);

		try (ResultSet rst = pst1.executeQuery()) {
			if (rst.next())
				return new Voter(rst.getInt(1), name, rst.getString(3), pwd, rst.getBoolean(5), rst.getString(6));
		}
		return null;
	}

	@Override
	public String updateVotingStatus(int voterId) throws SQLException {
		pst2.setInt(1, voterId);
		int updateCount = pst2.executeUpdate();
		if (updateCount == 1)
			return "---VOTE STATUS UPDATED---";
		return "!!!VOTE STATUS UPDATION FAILED!!!";
	}

}
