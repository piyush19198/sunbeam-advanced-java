package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import pojos.Candidate;
import pojos.Voter;

@WebServlet("/candidate_list")
public class CandidateListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {
			HttpSession hs = request.getSession();
			System.out.println("---NEW SESSION " + hs.isNew() + "---");
			System.out.println("---SESSION ID " + hs.getId() + "---");

			Voter client = (Voter) hs.getAttribute("client_details");
			if (client != null) {
				pw.print("<h5>Validated Voter Name : " + client + "</h5>");

				CandidateDaoImpl cDao = (CandidateDaoImpl) hs.getAttribute("candidate_dao");
				List<Candidate> candidates = cDao.getAllCandidates();

				pw.print("<h5>CANDIDATE LIST<br></h5>");
				pw.print("<form action = 'logout'>");
				pw.print("<h5>");
				for (Candidate c : candidates)
					pw.print("<input type=radio name='candidate_id' value=" + c.getCandidateId() + ">" + c.getName()
							+ "<br/>");
				pw.print("<input type = submit value = 'Vote'>");
				pw.print("</h5>");
				pw.print("</form>");
			} else
				pw.print("<h5>!!!NO COOKIES. SESSION TRACKING FAILED!!!</h5>");
			pw.print("<h5><a href = 'logout'>LOG OUT</a></h5>");
		} catch (Exception e) {
			throw new ServletException("!!!ERROR IN DO-GET OF : " + getClass() + "!!!", e);
		}
	}

}
