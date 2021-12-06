package dao;

import java.sql.SQLException;

import pojos.Voter;

public interface IVoterDao {
//add a method decl for user auth.
	Voter authenticateUser(String name,String pwd) throws SQLException;
	//add a method : to change voting status
	String updateVotingStatus(int voterId)throws SQLException;
}
