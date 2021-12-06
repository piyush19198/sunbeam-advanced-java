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

import pojos.Voter;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {

	}

	public void destroy() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			System.out.println("---IN LOGOUT PAGE---");
			HttpSession session = request.getSession();
			System.out.println("---CURRENT SESSION " + session.isNew() + "---");
			System.out.println("---CURRENT SESSION ID " + session.getId() + "---");
			Voter user = (Voter) session.getAttribute("client_details");
			if(user != null)
				pw.print("<h5>User Details from Logout Page : " + user + "</h5>");
			if(user.getRole().equals("admin"))
				pw.print("<h5><a href=login.html>Login Again</a></h5>");
			else
				pw.print("<h5>!!!NO SESSION TRACKING : NO COOKIES!!!</h5>");
			session.invalidate();
			pw.print("<h5>YOU HAVE LOGGED OUT SUCCESSFULLY</h5>");
		}
	}

}
