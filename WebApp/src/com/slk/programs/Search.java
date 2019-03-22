package com.slk.programs;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.RequestDispatcher;

import com.slk.dao.ShowProductsManager;
import com.slk.entity.Products;


@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Reached");
		
		String text = request.getParameter("search");
		
		System.out.println(text);
		
		ShowProductsManager obj = new ShowProductsManager();
		
		List<Products> l = obj.search(text);
		
		request.setAttribute("search", l);
		request.setAttribute("name", text);
		
		request.getRequestDispatcher("./WEB-INF/pages/SearchResults.jsp").forward(request, response);
	}

}
