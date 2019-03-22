package com.slk.programs;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.slk.dao.ShowProductsManager;
import com.slk.entity.Products;

@WebServlet("/MyCart")
public class MyCart extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		ShowProductsManager ob = new ShowProductsManager();
		List<Products> li = ob.getCartProducts();
		
		
		HttpSession s = request.getSession(false);
		String name=null;
		try
		{
			name = (String) s.getAttribute("name");
		}
		catch(Exception e)
		{
			System.out.println("E:"+e);
		}
		
		if (name != null) {
			
		}
		
		
		request.setAttribute("abc", li);
		
		try {
			request.getRequestDispatcher("./WEB-INF/pages/MyCart.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
