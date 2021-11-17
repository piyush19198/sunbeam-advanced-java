package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet(value="/test1",loadOnStartup = 1)
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		System.out.println("IN INIT : ");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("IN DESTROY : ");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set resp content type : done for clnt browser
		response.setContentType("text/html");
		System.out.println("IN DO GET OF SERVLET1 : "+getClass());
		//attach char buffered o/p strm to send resp from servlet ---> clnt
		try(PrintWriter pw=response.getWriter())
		{
			pw.print("<h4> Testing Lazy INIT of the servlet "+LocalDateTime.now()+"</h4>");
		}
	}

}