package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import pojos.Tutorial;

public interface ITutorialDao {
	public ArrayList<String> getTutorialsByTopicName(String topicName) throws SQLException;
}
