package com.slk.programs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.slk.dao.ShowProductsManager;
import com.slk.entity.Products;

@WebServlet("/AddToCart")
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String a = (String) request.getParameter("id");

		HttpSession s = request.getSession(false);

		String name = (String) s.getAttribute("name");

		if (name == null) {
			//response.sendRedirect("./login");
			request.getRequestDispatcher("./login").forward(request, response);
		} else {
			ShowProductsManager ob = new ShowProductsManager();
			Products p = ob.getProductById(Integer.parseInt(a));

			ob.AddToCart(Integer.parseInt(a));

			response.sendRedirect("./ShowProducts");
		}

	}

}
