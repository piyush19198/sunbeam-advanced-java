package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet(value="/test2",loadOnStartup = 2)
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
     
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		   System.out.println("IN INIT 2");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("IN DESTROY 2");	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set resp content type : done for clnt browser
				response.setContentType("text/html");
				System.out.println("IN DO GET OF SERVLET2 : "+getClass());
				//attach char buffered o/p strm to send resp from servlet ---> clnt
				try(PrintWriter pw=response.getWriter())
				{
					pw.print("<h4> Testing Eager INIT of the servlet "+LocalDateTime.now()+"</h4>");
				}
	}

}
