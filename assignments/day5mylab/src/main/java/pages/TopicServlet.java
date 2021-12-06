package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TopicDaoImpl;
import pojos.Topic;
import pojos.User;

@WebServlet("/topics_page")
public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TopicDaoImpl dao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			HttpSession hs = request.getSession();
			User user = (User) hs.getAttribute("client_details");
			if (user != null) {
				List<Topic> topics = new ArrayList<Topic>(dao.getAllTopics());

				pw.print("<form action = 'tutorials' method = 'post'><br>");
				for (Topic t : topics) {
					pw.print("<input type = 'radio' name = 'topicname'>" + t.getTopics() + "</input><br>");
				}
				pw.print("<input type='submit' value='Choose Tutorial'></form>");
			} else
				pw.print("<h5>!!!NO COOKIES. SESSION TRACKING FAILED!!!</h5>");
		} catch (Exception e) {
			throw new ServletException("!!!ERROR IN DO-POST OF : " + getClass() + "!!!", e);
		}
	}

}
