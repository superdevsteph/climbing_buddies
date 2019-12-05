package fr.ocr.climbing;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/lifecycle", loadOnStartup=1)
public class LifeCycleServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	private String databaseURL;
	private int counter;

	public LifeCycleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	
	@Override
	public void init() throws ServletException {
		super.init();
		databaseURL = this.getServletContext().getInitParameter("DATABASE_URL");
		System.out.println("in init " + databaseURL);
		counter = 0;

	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Demo", "A value");
		response.getWriter().append("Served at:").append(request.getContextPath());
		counter++;
		System.out.println("In doGet" + counter);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.doPost(request, response);

	}

	@Override
	public void destroy() {
		System.out.println("In destroy");
		super.destroy();
	}
}
