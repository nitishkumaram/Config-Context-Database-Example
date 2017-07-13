package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccessDatabase;

/**
 * Servlet implementation class ControllEmailAndPassword
 */
@WebServlet("/ControllEmailAndPassword")
public class ControllEmailAndPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllEmailAndPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		String password=request.getParameter("password").trim();
		
		AccessDatabase ad=new AccessDatabase();
		RequestDispatcher dispatcher=null;
		if(ad.search(email, password))
		{
		dispatcher=request.getRequestDispatcher("/UsersSuccessServlet");
		dispatcher.forward(request, response);
		}
		else
		{
			dispatcher=request.getRequestDispatcher("/UsersFailedServlet");
			dispatcher.forward(request, response);
		}


	}

}
