package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TutorialDaoImpl;
import pojos.Tutorial;

/**
 * Servlet implementation class TutorialDetails
 */
@WebServlet("/tutorial_details")
public class TutorialDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set cont type
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			//get HS from WC
			HttpSession session=request.getSession();
			//get tut dao instance from the session scope
			TutorialDaoImpl dao=(TutorialDaoImpl) session.getAttribute("tut_dao");
			//get selected tut name from : req param
			String tutName=request.getParameter("tut_name");
			//invoke dao's method , to get complete info about the selected tutorial
			Tutorial tutorialDetails = dao.getTutorialDetails(tutName);
			pw.print("<h5> Title "+tutorialDetails.getTutorialName()+"</h5>");
			pw.print("<h5> Author  "+tutorialDetails.getAuthor()+"</h5>");
			pw.print("<h5> Published On "+tutorialDetails.getPublishDate()+"</h5>");
			pw.print("<h5> Visits  "+tutorialDetails.getVisits()+"</h5>");
			pw.print("<h5> Contents  "+tutorialDetails.getContents()+"</h5>");
			//update visits
			System.out.println(dao.updateVisits(tutorialDetails.getTutorialId()));
			//add back link
			pw.print("<h5><a href='tutorials?topic_id="+tutorialDetails.getTopicId()+"'>Back</a></h5>");
			
			//add logout link
			pw.print("<h5><a href='logout'>Log Out</a></h5>");
			
		} catch (Exception e) {
			throw new ServletException("err in do-get of "+getClass(), e);
		}
	}

}
