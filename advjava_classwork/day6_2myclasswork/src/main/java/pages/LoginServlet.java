package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.VoterDaoImpl;
import pojos.Voter;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/authenticate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoterDaoImpl dao;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		System.out.println("in init of " + getClass());
		try {
			dao = new VoterDaoImpl();
		} catch (Exception e) {
			// e.printStackTrace();
			// re throw the same exc , by wrapping it in javax.servlet.ServletException
			// ServletException(String mesg,Throwable rootCause)
			// centralized err handling in servlets
			throw new ServletException("err in init of : " + getClass(), e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			dao.cleanUp();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			// re throw the same exc to the caller : wrap it in RuntimeExc
			throw new RuntimeException("err in destroy of " + getClass(), e);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in do-post of "+getClass());
		// set cont type
		response.setContentType("text/html");//setting resp header : content type
		try (PrintWriter pw = response.getWriter()) {
			
			// read req params : nm n pwd
			String nm = request.getParameter("name");
			String pwd = request.getParameter("pass");
			// servlet --invoke dao's method for user auth.
			Voter user = dao.authenticateUser(nm, pwd);
			// in case of success : print success mesg + voter details
			// o.w : : send retry link
			if (user != null) {
				pw.print("<h5>from login page</h5> ");
		//		pw.flush(); //java.lang. IllegalStateException : can't forward after committing the resp
				//save validated user details under "request" scope
				request.setAttribute("user_dtls", user);
				//Server Pull : Request dispatching tech : forward scenario
				//steps 1. Create RD (javac.servlet.RequetDispatcher)
				//API of ServletRequest : public RD getRequestDispatcher(String path)
				RequestDispatcher rd=request.getRequestDispatcher("candidate_list");
				//forward the clnt's request to the next page : in the SAME request
				rd.forward(request, response);
				//WC : suspends the exec of the curnt page, clrs / empties PW's buffer , invokes CandidateListPage's 
				//doPost method.
				System.out.println("came back.....");
				
			
			} else
				pw.print("<h5>Invalid Login , Please <a href='login.html'>Retry</a></h5>");

		} catch (Exception e) {
			// re throw the raised exc to the caller : WC
			throw new ServletException("err in do-post of " + getClass(), e);
		}
	}

}
