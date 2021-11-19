package dao;

import static utils.DBUtils.fetchConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojos.Topic;

public class TopicDaoImpl implements ITopicDao{

	private Connection cn;
	private PreparedStatement pst3;
	
	List<Topic> topics = new ArrayList<Topic>();
	
	public TopicDaoImpl() throws ClassNotFoundException,SQLException {
		cn = fetchConnection();
		pst3 = cn.prepareStatement("select * from topics"); 
	}
	
	@Override
	public List<Topic> getAllTopics() throws SQLException {
		try (ResultSet rst = pst3.executeQuery()) {
			while (rst.next()) {
				topics.add(new Topic(rst.getInt(1),rst.getString(2)));
				
			}return topics;
		}
	}
	
	public void cleanUp() throws SQLException {
		if (pst3 != null)
			pst3.close();
		if (cn != null)
			cn.close();
	}

}
