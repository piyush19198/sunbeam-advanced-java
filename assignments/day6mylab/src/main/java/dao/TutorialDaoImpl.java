package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import pojos.Tutorial;
import static utils.DBUtils.fetchConnection;

public class TutorialDaoImpl implements ITutorialDao {
	private Connection cn;
	private PreparedStatement pst1, pst2, pst3;

	public TutorialDaoImpl() throws ClassNotFoundException, SQLException {
		cn = fetchConnection();
		pst1 = cn.prepareStatement("select name from tutorials where topic_id=? order by visits desc");
		pst2 = cn.prepareStatement("select * from tutorials where name=?");
		pst3 = cn.prepareStatement("update tutorials set visits=visits+1 where id=?");
		System.out.println("tut dao created");
	}

	@Override
	public List<String> getTutorialsByTopicId(int topicId) throws SQLException {
		List<String> tutNames = new ArrayList<>();
		pst1.setInt(1, topicId);
		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				tutNames.add(rst.getString(1));
		}
		return tutNames;
	}

	@Override
	public Tutorial getTutorialDetails(String tutName) throws SQLException {
		pst2.setString(1, tutName);
		try (ResultSet rst = pst2.executeQuery()) {
			if (rst.next())
				return new Tutorial(rst.getInt(1), tutName, rst.getString(3), rst.getDate(4), rst.getInt(5),
						rst.getString(6), rst.getInt(7));
		}
		return null;
	}

	@Override
	public String updateVisits(int tutorialId) throws SQLException {
		// set IN param
		pst3.setInt(1, tutorialId);
		int updateCount = pst3.executeUpdate();
		if (updateCount == 1)
			return "visits updated...";
		return "sists updation failed...";
	}

	public void cleanUp() throws SQLException {
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		System.out.println("tut dao cleaned up...");
	}

}
