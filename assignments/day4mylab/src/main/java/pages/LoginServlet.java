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

import dao.UserDaoImpl;
import pojos.User;

@WebServlet(value = "/authenticate_user", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl dao;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("---Servlet Initiated---" + getClass());

		try {
			dao = new UserDaoImpl();
		} catch (Exception e) {
			throw new ServletException("!!!ERROR IN INIT OF : " + getClass() + "!!!", e);
		}
	}

	public void destroy() {
		System.out.println("---Servlet Destroyed---");
		try {
			dao.cleanUp();
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
				pw.print("<h5>---LOGIN SUCCESSFUL---<br>YOUR DETAILS :<br>"+user+"</h5>");
				response.sendRedirect("topics");
			} else
				pw.print("<h5>!!!INVALID LOGIN, PLEASE <a href = 'login.html'>RETRY</a> !!!</h5>");
		} catch (Exception e) {
			throw new ServletException("!!!ERROR IN DO-POST OF : " + getClass() + "!!!", e);
		}
	}

}
