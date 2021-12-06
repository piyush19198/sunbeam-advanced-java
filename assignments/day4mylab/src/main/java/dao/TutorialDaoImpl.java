package dao;

import static utils.DBUtils.fetchConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TutorialDaoImpl implements ITutorialDao {
	private Connection cn;
	private PreparedStatement pst4;
	
	ArrayList<String> tutorials = new ArrayList<String>();
	
	public TutorialDaoImpl() throws ClassNotFoundException,SQLException {
		cn = fetchConnection();
		pst4 = cn.prepareStatement("select name from tutorials where topic_id=(select id from topics where name=?) order by visits desc"); 
	}
	
	@Override
	public ArrayList<String> getTutorialsByTopicName(String topicName) throws SQLException{
		pst4.setString(1, topicName);
		try(ResultSet rst = pst4.executeQuery()){
			while (rst.next()) {
				tutorials.add(rst.getString(1));
			}return tutorials;
		}
	}
	
	public void cleanUp() throws SQLException {
		if (pst4 != null)
			pst4.close();
		if (cn != null)
			cn.close();
	}
}
