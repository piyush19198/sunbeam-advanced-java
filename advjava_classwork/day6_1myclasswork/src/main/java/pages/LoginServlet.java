package pages;

import static utils.DBUtils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import dao.VoterDaoImpl;
import pojos.Voter;
import utils.DBUtils;

//@WebServlet(value = "/authenticate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoterDaoImpl voterDao;
	private CandidateDaoImpl candidateDao;

	public LoginServlet() {
		System.out.println("!!!IN DEFAULT CONSRUCTOR OF LOGINSERVLET!!!");
	}

	public LoginServlet(String name) {
		System.out.println("!!!IN PARAMETERIZED CONSTRUCTOR OF LOGINSERVLET!!!");
	}

	public void init() throws ServletException {
		System.out.println("---Servlet Initiated---" + getClass());
		ServletConfig config = getServletConfig();
		System.out.println("---CONFIG IN INIT---" + config);
		String url = config.getInitParameter("db_url");
		String userName = config.getInitParameter("user_name");
		String password = config.getInitParameter("pwd");
		try {
			openConnection(url, userName, password);
			voterDao = new VoterDaoImpl();
			candidateDao = new CandidateDaoImpl();
		} catch (Exception e) {
			throw new ServletException("!!!ERROR IN INIT OF : " + getClass() + "!!!", e);
		}
	}

	public void destroy() {
		System.out.println("---Servlet Destroyed---");
		try {

			voterDao.cleanUp();
			candidateDao.cleanUp();
			DBUtils.closeConnection();
		} catch (SQLException e) {
			throw new RuntimeException("!!!ERROR IN DESTROY OF : " + getClass() + "!!!", e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("REQUEST: " + request + "\nRESPONSE: " + response);
		try (PrintWriter pw = response.getWriter()) {
			String nm = request.getParameter("name");
			String pwd = request.getParameter("pass");

			Voter user = voterDao.authenticateUser(nm, pwd);

			if (user != null) {
				HttpSession session = request.getSession();
				System.out.println("---NEW SESSION " + session.isNew() + "---");
				System.out.println("---SESSION ID " + session.getId() + "---");
				session.setAttribute("client_details", user);
				session.setAttribute("voter_dao", voterDao);
				session.setAttribute("candidate_dao", candidateDao);

				if (user.getRole().equals("admin")) {
					response.sendRedirect("admin_page");
				} else if (user.getStatus()) {
					pw.print("<h5>!!!EK AADMI EK VOTE!!!</h5>");
					response.sendRedirect("logout");
				} else {
					response.sendRedirect("candidate_list");
				}
			} else
				pw.print("<h5>!!!INVALID LOGIN, PLEASE <a href = 'login.html'>RETRY</a> !!!</h5>");
		} catch (Exception e) {
			throw new ServletException("!!!ERROR IN DO-POST OF : " + getClass() + "!!!", e);
		}
	}

}
