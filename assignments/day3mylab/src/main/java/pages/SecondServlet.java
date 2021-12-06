package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("INSIDE DO_GET of SECOND: "+Thread.currentThread());
		resp.setContentType("text/html");
		try(PrintWriter pw = resp.getWriter()){
			pw.print("<h4>Inside SecondServlet via XML "+LocalDateTime.now()+"</h4>");
		}
	}

	@Override
	public void destroy() {
		System.out.println("DESTROY INIT of SECOND: "+Thread.currentThread());
	}

	@Override
	public void init() throws ServletException {
		System.out.println("INSIDE INIT of SECOND: "+Thread.currentThread());
	}
	
}
