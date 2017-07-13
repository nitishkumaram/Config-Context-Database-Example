package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class LoadServletContext
 */
public class LoadServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	public void init() throws ServletException {

		System.out.println("Load Context");
	Map<String,String> users=new HashMap<String,String>();
	users.put("Jayesh", "abc");
	users.put("praveen", "abcd");
	users.put("sophia", "das");
	
	ServletContext context=getServletContext();
	context.setAttribute("usersmap", users);


	}
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public LoadServletContext() {
        super();
        // TODO Auto-generated constructor stub
    }
}
