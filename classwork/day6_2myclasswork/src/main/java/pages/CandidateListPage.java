package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CandidateLIstPage
 */
@WebServlet("/candidate_list")
public class CandidateListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set cont type , get pw , print mesg :" from candidate list page" 
		System.out.println("in do-post of "+getClass());
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			pw.print("<h4> from candidate list page </h4>" );
			//display validated voter details : 
			pw.print("<h5>Validated Voter Details   "+request.getAttribute("user_dtls")+"</h5>");
			pw.print("<h5> User Name "+request.getParameter("name")+"</h5>");
		}
	}

}
