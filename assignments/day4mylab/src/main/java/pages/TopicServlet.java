package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TopicDaoImpl;
import pojos.Topic;

/**
 * Servlet implementation class TopicServlet
 */
@WebServlet("/topics")
public class TopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TopicDaoImpl dao;

	public void init(ServletConfig config) throws ServletException {
		System.out.println("---Servlet Initiated---" + getClass());

		try {
			dao = new TopicDaoImpl();
		} catch (Exception e) {
			throw new ServletException("!!!ERROR IN INIT OF : " + getClass() + "!!!", e);
		}
	}

	public void destroy() {
		System.out.println("---Servlet Destroyed---");
		try {
			dao.cleanUp();
		} catch (SQLException e) {
			throw new RuntimeException("!!!ERROR IN DESTROY OF : " + getClass() + "!!!", e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			List<Topic> topics = new ArrayList<Topic>(dao.getAllTopics());
			pw.print("<form action = 'tutorials'>" + "<input type = 'radio' name = 'topicname'>" + topics.get(0).getName()
					+ "</input>" + "<input type = 'radio' name = 'topicname'>" + topics.get(1).getName() + "</input>"
					+ "<input type = 'radio' name = 'topicname'>" + topics.get(2).getName() + "</input>"
					+ "<input type = 'radio' name = 'topicname'>" + topics.get(3).getName() + "</input>"
					+ "<input type='submit' value='Choose Tutorial'>");
		} catch (Exception e) {
			throw new ServletException("!!!ERROR IN DO-POST OF : " + getClass() + "!!!", e);
		}
	}

}
