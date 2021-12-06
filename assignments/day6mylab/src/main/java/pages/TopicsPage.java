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

import dao.TopicDaoImpl;
import pojos.Topic;

/**
 * Servlet implementation class TopicsPage
 */
@WebServlet("/topics")
public class TopicsPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set cont type
		response.setContentType("text/html");
		// get PW
		try (PrintWriter pw = response.getWriter()) {
			// get existing HS from WC
			HttpSession session = request.getSession();
			// get topic dao instance from sesison scope
			TopicDaoImpl dao = (TopicDaoImpl) session.getAttribute("topic_dao");
			// invoke dao's method to get all topics
			List<Topic> allTopics = dao.getAllTopics();
			// dyn form generation
			pw.print("<form action='tutorials'>");
			for (Topic t : allTopics)
				pw.print("<input type=radio name=topic_id value=" + t.getTopicId() + ">" + t.getTopicName() + "<br/>");
			pw.print("<input type=submit value='Choose Topic'>");
			pw.print("</form>");

		} catch (Exception e) {
			throw new ServletException("err in do-get of :" + getClass(), e);
		}
	}

}
