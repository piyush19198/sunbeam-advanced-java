package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TutorialDaoImpl;

/**
 * Servlet implementation class TutorialsPage
 */
@WebServlet("/tutorials")
public class TutorialsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//set reps cont type
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			//get existing HS from WC
			HttpSession session=request.getSession();
			//get tut dao from session scope
			TutorialDaoImpl dao=(TutorialDaoImpl)session.getAttribute("tut_dao");
			//get selected topic id from : request param 
			int topicId=Integer.parseInt(request.getParameter("topic_id"));
			//invoke dao's method to get list of tut names for the selected topic
			List<String> tutNames = dao.getTutorialsByTopicId(topicId);
			for (String s : tutNames)
				pw.print("<h5> <a href='tutorial_details?tut_name="+s+"'>"+s+"</a></h5>");
			
		} catch (Exception e) {
			throw new ServletException("err in do-get of "+getClass(), e);
		}
	}

}
