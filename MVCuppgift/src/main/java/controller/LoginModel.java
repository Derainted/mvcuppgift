package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginBeans;

/**
 * Servlet implementation class LoginModel
 */
@WebServlet("/LoginModel")
public class LoginModel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		HttpSession session = request.getSession();

		String thisSession = (String) session.getAttribute("mySession");
		System.out.println(thisSession);

		if (thisSession == null) {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			LoginBeans account = new LoginBeans();
			account.setUsername(request.getParameter("username"));
			account.setUserpass(request.getParameter("userpass"));

			if (account.getUsername().equals("moon") && account.getUserpass().equals("12345")) {
				session.setAttribute("mySession", "session rocks");
				session.setMaxInactiveInterval(45);

				RequestDispatcher dispatch = request.getRequestDispatcher("success.jsp");
				dispatch.forward(request, response);

			} else if (account.getUsername().equals("sun") && account.getUserpass().equals("12345")) {
				session.setAttribute("mySession", "session rocks");
				session.setMaxInactiveInterval(45);
				RequestDispatcher dispatch = request.getRequestDispatcher("success.jsp");
				dispatch.forward(request, response);

			}

			else {
				out.println("<h3>Error</h3>");
				response.sendRedirect("index.jsp");
			}
		} 
			
			else {
			response.setContentType("text/html");
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);

		}

	}

}
