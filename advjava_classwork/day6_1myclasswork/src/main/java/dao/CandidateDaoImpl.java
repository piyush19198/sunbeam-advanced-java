package dao;

import static utils.DBUtils.fetchConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Candidate;


public class CandidateDaoImpl implements ICandidateDao {
	private Connection cn;
	private PreparedStatement pst1;
	private PreparedStatement pst2;
	
	public CandidateDaoImpl() throws ClassNotFoundException,SQLException {
		
		cn=fetchConnection();
		pst1=cn.prepareStatement("select * from candidates");
		pst2=cn.prepareStatement("update candidates set votes = votes+1 where id=?");
		System.out.println("---CANDIDATE DAO CREATED---");
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		System.out.println("---CANDIDATE DAO CLEANED UP---");
	}
	
	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		List<Candidate> list = new ArrayList<>();
		try(ResultSet rst = pst1.executeQuery()){
			while(rst.next())
				list.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		return list;
	}

	@Override
	public String incrementCandidateVotes(int candidateID) throws SQLException {
		pst2.setInt(1, candidateID);
		int updateCount = pst2.executeUpdate();
		if (updateCount == 1)
			return "---VOTE SUCCESSFULLY CASTED---";
		return "!!!VOTE CASTING FAILED!!!";
	}
}
