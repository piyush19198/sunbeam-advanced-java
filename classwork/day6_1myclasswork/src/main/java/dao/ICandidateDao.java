package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Candidate;

public interface ICandidateDao {

	public List<Candidate> getAllCandidates() throws SQLException;

	String incrementCandidateVotes(int candidateId) throws SQLException;
}
