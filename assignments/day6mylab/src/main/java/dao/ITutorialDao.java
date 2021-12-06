package dao;

import java.sql.SQLException;
import java.util.List;

import pojos.Tutorial;

public interface ITutorialDao {
//get all tutorials under specified topic in a sorted as per visits manner
	List<String> getTutorialsByTopicId(int topicId) throws SQLException;

//get tutorial details
	Tutorial getTutorialDetails(String tutName) throws SQLException;
	//update visits 
	String updateVisits(int tutorialId) throws SQLException;
}
