package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FailedServlet
 */
@WebServlet("/FailedServlet")
public class FailedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FailedServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doPost(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		ServletContext context=request.getServletContext();
		context.removeAttribute("userss");
		//Adding attribute to check listener
		
		PrintWriter pw=response.getWriter();

		response.setContentType("text/html");
		pw.print("<html><body>");
		pw.print("<h1>Login Failed</h1>");
		pw.print("</body></html>");
		RequestDispatcher dispatcher=request.getRequestDispatcher("./index.html");
		dispatcher.include(request,response);

	}

}
