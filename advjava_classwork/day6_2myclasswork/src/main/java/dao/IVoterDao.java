package dao;

import java.sql.SQLException;

import pojos.Voter;

public interface IVoterDao {
//add a method decl for user auth.
	Voter authenticateUser(String name,String pwd) throws SQLException;
}
