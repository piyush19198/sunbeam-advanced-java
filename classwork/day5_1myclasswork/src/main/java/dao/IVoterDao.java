package dao;

import java.sql.SQLException;

import pojos.Voter;

public interface IVoterDao {
	Voter authenticateUser(String name, String pwd) throws SQLException;
}