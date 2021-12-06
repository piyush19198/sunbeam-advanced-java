package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/text")
public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("INSIDE DO_GET: "+Thread.currentThread());
		resp.setContentType("text/html");
		try(PrintWriter pw = resp.getWriter()){
			pw.print("<h4>Hello From Servlets "+LocalDateTime.now()+"</h4>");
		}
	}

	@Override
	public void destroy() {
		System.out.println("DESTROY INIT: "+Thread.currentThread());

	}

	@Override
	public void init() throws ServletException {
		System.out.println("INSIDE INIT: "+Thread.currentThread());
	}
	
}
