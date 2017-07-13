package servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
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

		ServletContext context=request.getServletContext(); //context
		
		String email=request.getParameter("email");
		String password=request.getParameter("password").trim();
		
		Map<String,String> us=(Map<String, String>) context.getAttribute("usersmap");
		
		context.setAttribute("msg", "s");
		context.setAttribute("msg", "abc");
		context.removeAttribute("msg");
		
		RequestDispatcher dispatcher=null;
		
		boolean flag=false;
		for(Map.Entry<String, String> m:us.entrySet())
		{
			if(email.equals(m.getKey()) )
			{
				
				if(password.equals(m.getValue())){
					flag=true;
					break;
				}
			}
		}
		if(flag==true){

				dispatcher=request.getRequestDispatcher("/SuccessServlet");
				dispatcher.forward(request, response);
		}
		else
		{
			dispatcher=request.getRequestDispatcher("/FailedServlet");
			dispatcher.forward(request, response);
		}

	}
}
