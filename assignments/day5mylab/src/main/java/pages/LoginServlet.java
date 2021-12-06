package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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

@WebServlet(value = "/authenticate_user", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl dao;
	private TopicDaoImpl tdao;
	private TutorialDaoImpl tutdao;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("---Servlet Initiated---" + getClass());

		try {
			dao = new UserDaoImpl();
			tdao = new TopicDaoImpl();
			tutdao = new TutorialDaoImpl();
		} catch (Exception e) {
			throw new ServletException("!!!ERROR IN INIT OF : " + getClass() + "!!!", e);
		}
	}

	public void destroy() {
		System.out.println("---Servlet Destroyed---");
		try {
			dao.cleanUp();
			tdao.cleanUp();
			tutdao.cleanUp();
			DBUtils.closeConnection();
		} catch (SQLException e) {
			throw new RuntimeException("!!!ERROR IN DESTROY OF : " + getClass() + "!!!", e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {
			String nm = request.getParameter("name");
			String pwd = request.getParameter("pass");

			User user = dao.authenticateUser(nm, pwd);
			if (user != null) {
				HttpSession session = request.getSession();
				pw.print("<h5>---LOGIN SUCCESSFUL---<br>YOUR DETAILS :<br>" + user + "</h5>");
				session.setAttribute("client_details", user);
				session.setAttribute("t_dao", tdao);
				session.setAttribute("tut_dao", tutdao);
				
				if (user.getRole().equals("admin")) {
					response.sendRedirect("admin_page");
				} else if (user.getRole().equals("customer")) {
					response.sendRedirect("topics_page");
				}
			} else
				pw.print("<h5>!!!INVALID LOGIN, PLEASE <a href = 'login.html'>RETRY</a> !!!</h5>");
		} catch (Exception e) {
			throw new ServletException("!!!ERROR IN DO-POST OF : " + getClass() + "!!!", e);
		}
	}

}
