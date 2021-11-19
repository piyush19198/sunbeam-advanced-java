package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pojos.User;

@WebServlet("/admin_page")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			HttpSession session = request.getSession();

			User admin = (User) session.getAttribute("client_details");
			if (admin != null)
				pw.print("<h4>Welcome Admin!</h4>");
			else
				pw.print("<h4>!!!NO SESSION TRACKING : NO COOKIES!!!</h4>");
			pw.print("<h5><a href=login.html>LOGOUT</a></h5>");
		}
	}

}
