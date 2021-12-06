package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test_input")
public class TestAllInputs extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()){
			pw.print("<h4>");
			pw.print("Hello "+request.getParameter("f1")+"<br/>");
			pw.print("Favorite Colors : "+Arrays.toString(request.getParameterValues("clr"))+"</br>");
			pw.print("Selected Browser : "+request.getParameter("browser")+"</br>");
			pw.print("City : "+request.getParameter("myselect")+"</br>");
			pw.print("Your Info : "+request.getParameter("info")+"</br>");
		}
	}
}
