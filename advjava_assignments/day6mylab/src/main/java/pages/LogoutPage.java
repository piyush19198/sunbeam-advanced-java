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

/**
 * Servlet implementation class LogoutPage
 */
@WebServlet("/logout")
public class LogoutPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set reps cont type
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// get HS from WC
			HttpSession session = request.getSession();
			// get user details from the session scope
			User user = (User) session.getAttribute("user_details");
			pw.print("<h5> Hello , "+user.getName()+"</h5>");
			pw.print("<h5> You have logged out.....</h5>");
			//invalidate the session
			session.invalidate();
			//add visit again  link
			pw.print("<h5><a href='login.html'>Visit Again</a></h5>");
	

		}
	}

}
