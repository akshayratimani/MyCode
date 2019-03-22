package com.slk.programs;

import java.io.IOException; 

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.slk.dao.DaoFactory;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("./login.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String u = request.getParameter("uname");
		String p = request.getParameter("pass");
		
		System.out.println(u+p);

		try {
			if (u.equals(com.slk.dao.DaoFactory.checkUsername(u)) && p.equals(com.slk.dao.DaoFactory.checkPassword(p))) {
				
				HttpSession session = request.getSession();
				session.setAttribute("name", u);			
				RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/pages/Home.jsp");
				rd.forward(request, response);
			} else {

				RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/pages/error.jsp");
				rd.forward(request, response);

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("No Data found..");
			RequestDispatcher rd = request.getRequestDispatcher("./WEB-INF/pages/error1.jsp");
			rd.forward(request, response);
			
		}

	}
}
