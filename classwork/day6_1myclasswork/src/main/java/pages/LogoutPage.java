package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import dao.VoterDaoImpl;
import pojos.Voter;

@WebServlet("/logout")
public class LogoutPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {

	}

	public void destroy() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			HttpSession session = request.getSession();

			Voter user = (Voter) session.getAttribute("client_details");
			if (user != null) {
				if (user.getRole().equals("admin"))
					pw.print("<h5><a href=login.html>LOGOUT</a></h5>");
				else {
					if (user.getStatus())
						pw.print("<h5>---VOTE ALREADY CASTED---</h5>");
					else {
						int candidateId = Integer.parseInt(request.getParameter("candidate_id"));

						CandidateDaoImpl candidateDao = (CandidateDaoImpl) session.getAttribute("candidate_dao");
						VoterDaoImpl voterDao = (VoterDaoImpl) session.getAttribute("voter_dao");

						System.out.println(candidateDao.incrementCandidateVotes(candidateId));
						pw.print("<h5>voterDao.updateVotingStatus(user.getId())<h5>");
					}
				}
			} else
				pw.print("<h5>!!!NO SESSION TRACKING : NO COOKIES!!!</h5>");
			session.invalidate();
			pw.print("<h5>YOU HAVE LOGGED OUT SUCCESSFULLY</h5>");
		} catch (SQLException e) {
			throw new ServletException("!!!ERROR IN DO-GET OF : " + getClass() + "!!!", e);
		}
	}

}
