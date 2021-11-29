package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static utils.DBUtils.fetchConnection;

import pojos.Candidate;

public class CandidateDaoImpl implements ICandidateDao {

	private Connection cn;
	private PreparedStatement pst1, pst2;

	public CandidateDaoImpl() throws ClassNotFoundException, SQLException {
		// get cn
		cn = fetchConnection();
		pst1 = cn.prepareStatement("select * from candidates");
		pst2 = cn.prepareStatement("update candidates set votes=votes+1 where id=?");
		System.out.println("candidate dao created...");
	}

	@Override
	public List<Candidate> getAllCandidates() throws SQLException {
		List<Candidate> list = new ArrayList<>();
		// exec query
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				list.add(new Candidate(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4)));
		}
		return list;
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		System.out.println("candidate dao cleaned up...");
	}

	@Override
	public String incrementCandidateVotes(int candidateId) throws SQLException {
		// set IN param : id
		pst2.setInt(1, candidateId);
		// exec method : exec update
		int updateCount = pst2.executeUpdate();
		if (updateCount == 1)
			return "Votes incremented.....";
		return "Votes updation failed...";
	}

}
