package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Topic;

public interface ITopicDao {
	ArrayList<Topic> getAllTopics() throws SQLException;
}
