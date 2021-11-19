package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TopicDaoImpl;
import dao.TutorialDaoImpl;
import dao.UserDaoImpl;
import pojos.User;
import utils.DBUtils;

/**
 * Servlet implementation class AuthenticationPage
 */
@WebServlet(urlPatterns = "/authenticate", loadOnStartup = 1)
public class AuthenticationPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
	private TopicDaoImpl topicDao;
	private TutorialDaoImpl tutDao;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		try {
			userDao = new UserDaoImpl();
			topicDao = new TopicDaoImpl();
			tutDao=new TutorialDaoImpl();
		} catch (Exception e) {
			throw new ServletException("err in init of :" + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			// dao's clean up
			userDao.cleanUp();
			topicDao.cleanUp();
			tutDao.cleanUp();
			// close conn
			DBUtils.closeConnection();
		} catch (Exception e) {
			throw new RuntimeException("err in destroy of :" + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set cont type
		response.setContentType("text/html");
		// get PW
		try (PrintWriter pw = response.getWriter()) {
			//get em n pwd : from req params n invoke user dao's method for validation
			User validateUser = userDao.validateUser(request.getParameter("email"), request.getParameter("pass"));
			if(validateUser != null)
			{
				//valid login : assume 1 type of user "customer"
				//get HttpSesison from WC
				HttpSession session=request.getSession();
				System.out.println("session new "+session.isNew());
				//add user details n daos under session scope
				session.setAttribute("user_details", validateUser);
				session.setAttribute("user_dao", userDao);
				session.setAttribute("topic_dao", topicDao);
				session.setAttribute("tut_dao", tutDao);
				//redirect clnt to the topics page in the NEXT request
				response.sendRedirect("topics");
				
			}
			else //invalid user : retry link
				pw.print("<h5>Invalid Login , Pls  <a href='login.html'>Retry</a></h5>");

		} catch (Exception e) {
			throw new ServletException("err in do-post of :" + getClass(), e);
		}
	}

}
