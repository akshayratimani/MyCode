package com.slk.programs;

import java.io.IOException; 
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slk.dao.DaoFactory;
import com.slk.entity.Userdata;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Reached RS");
		
		request.getRequestDispatcher("WEB-INF/pages/Register.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String a  = request.getParameter("fname");	
	String b  = request.getParameter("lname");	
	String c  = request.getParameter("email");	
	String d  = request.getParameter("uname");	
	String e  = request.getParameter("pass");	
	
	System.out.println(a+b+c+d+e);
	if(passwordValidation(e)) {
	try {
		System.out.println("Passing");
		DaoFactory.addUserdata(a, b, c, d, e);
		
		RequestDispatcher rd=request.getRequestDispatcher("./login.jsp");
		rd.forward(request, response);
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	}
	else {
		RequestDispatcher rd=request.getRequestDispatcher("./WEB-INF/pages/error.jsp");
		rd.forward(request, response);
	}
	

	
	
	}
	public boolean passwordValidation(String password) {
		boolean valid = true;
		if (password.length() < 8) {
			valid = false;
		}

		String uppercase = "(.*[A-Z].*)";
		if (!password.matches(uppercase)) {
			valid = false;
		}

		String lowercase = "(.*[a-z].*)";
		if (!password.matches(lowercase)) {
			valid = false;
		}
		String numbers = "(.*[0-9].*)";
		if (!password.matches(numbers)) {
			valid = false;
		}

		String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,_,-].*$)";
		if (!password.matches(specialChars)) {
			valid = false;
		}

		return valid;

	}

}
