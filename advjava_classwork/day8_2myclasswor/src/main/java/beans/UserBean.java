package beans;

import java.sql.SQLException;

import dao.VoterDaoImpl;
import pojos.Voter;

public class UserBean {
	//propeties : non static , no transient data members.
	//clnt's conversation state : clnt specific info.
	private String name;
	private String password;
	//voter dao ref
	private VoterDaoImpl voterDao;
	//to hold validated user details : Voter POJO
	private Voter userDetails;
	
	public UserBean() throws ClassNotFoundException, SQLException{
		// invoked by WC : jsp:useBean
		//create dao's instance
		voterDao=new VoterDaoImpl();
		System.out.println("user bean created");
		
	}
	//setters n getters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public VoterDaoImpl getVoterDao() {
		return voterDao;
	}

	public void setVoterDao(VoterDaoImpl voterDao) {
		this.voterDao = voterDao;
	}

	public Voter getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(Voter userDetails) {
		this.userDetails = userDetails;
	}
	//Add B.L method for user authentication , to return dynamic navigational outcome.
	public String validateUser() throws SQLException
	{
		//invoke Dao's method : for login
		userDetails=voterDao.authenticateUser(name, password);
		if(userDetails == null) //=>invalid login 
			return "login";
		//=> valid login
		if(userDetails.getRole().equals("admin")) //=> admin login success
			return "admin";
		//=> valid voter login
		if(userDetails.isStatus()) //=>voter has already voted....
			return "logout";
		//voter : not yet voted
		return "candidate_list";
					
		
			
	}
	
	

}
