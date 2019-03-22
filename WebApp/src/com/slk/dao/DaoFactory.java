package com.slk.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.slk.entity.Products;

public class DaoFactory {

	List<Products> p;
	List<Products> cart;

	public DaoFactory() {
		p = new ArrayList<>();
		cart = new ArrayList<>();
		p.add(new Products(1, "MINote4", 12000, 4.0f,"a.jfif"));
		p.add(new Products(2, "MotoG4", 13000, 3.0f,"motog4.jpg"));
		p.add(new Products(2, "MotoG4", 12500, 4.0f,"motog4.jpg"));
		p.add(new Products(3, "Iphone6s", 56000, 4.0f,"iphone.jpg"));
		p.add(new Products(4, "Skmei 115", 2000, 4.0f,"skmei.jpg"));
		p.add(new Products(5, "Samsung A4", 10000, 3.0f,"samsung.jpg"));
		p.add(new Products(6, "Boat 255s", 500, 3.0f,"boat.jpg"));
		p.add(new Products(7, "Skulcandy s3", 800, 3.0f,"skullcandy.jpeg"));
		p.add(new Products(7, "Skulcandy s3", 1800, 5.0f,"skullcandy.jpeg"));
		p.add(new Products(7, "Skulcandy s3", 2800, 2.0f,"skullcandy.jpeg"));
		p.add(new Products(8, "Nvidia GeForce", 120000, 4.0f,"nvidia.jpg"));
		p.add(new Products(9, "MRF tyres", 2000, 4.0f,"mrf.png"));
		p.add(new Products(10, "Nokia 1100", 2600, 5.0f,"nokia.jpg"));
		p.add(new Products(11, "AMD Raedon", 180000, 4.0f,"amd.jpg"));
		p.add(new Products(12, "Vivo A1", 11000, 1.0f,"vivo.jpeg"));

	}

	public List<Products> getProducts() {
		return p;
	}

	public List<Products> getCartProducts() {

		return cart;
	}

	public int getSize() {
		return cart.size();
	}

	public void AddToCart(Products pr) {
		cart.add(pr);
	}

	public void RemoveFromCart(Products p2) {
		int i = -1;
		int a = 0;
		try {
			for (Products p : cart) {
				i++;
				if (p.getId() == p2.getId()) {
					a = i;
				}
			}
			System.out.println("index:" + a);
			cart.remove(a);

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No matching product found");
		}
	}

	public List<Products> search(String n) {

		List<Products> l = new ArrayList<>();

		for (Products obj : p) {
			if (obj.getName().equals(n)) {
				l.add(obj);
			}
		}
		return l;
	}

	// login DAO from here

	public static void addUserdata(String fname, String lname, String email, String uname, String password)
			throws SQLException, ClassNotFoundException {
		Class.forName("org.h2.Driver");

		String url = "jdbc:h2:tcp://localhost/~/Login";
		String username = "sa";
		String pass = "";
		String sql = "insert into userdata values(?,?,?,?,?)";

		Connection con = DriverManager.getConnection(url, username, pass);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, fname);
		st.setString(2, lname);
		st.setString(3, email);
		st.setString(4, uname);
		st.setString(5, password);
		st.executeUpdate();
		st.close();
		con.close();

	}

	public static String checkUsername(String u) throws ClassNotFoundException, SQLException {
		Class.forName("org.h2.Driver");
		String pass = "";
		String url = "jdbc:h2:tcp://localhost/~/Login";
		String username = "sa";
		String sql = "select uname from userdata where uname='" + u + "'";

		Connection con = DriverManager.getConnection(url, username, pass);
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);
		rs.next();
		String a = rs.getString(1);
		System.out.println("Check:" + a);
		st.close();
		con.close();
		return a;
	}

	public static String checkPassword(String u) throws ClassNotFoundException, SQLException {

		System.out.println("u:" + u);
		Class.forName("org.h2.Driver");
		String pass = "";
		String url = "jdbc:h2:tcp://localhost/~/Login";
		String username = "sa";
		String sql = "select password from userdata where password='" + u + "'";

		Connection con = DriverManager.getConnection(url, username, pass);
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(sql);
		System.out.println("getting it");
		rs.next();

		String a = rs.getString(1);

		System.out.println("check pass:" + a);
		st.close();
		con.close();
		return a;
	}

	public List<Products> sortByNameAsc() {

		Collections.sort(p, new NameComparator());
		return p;

	}

	public List<Products> sortByNameDesc() {

		Collections.sort(p, new NameComparatorDesc());
		return p;

	}

	public List<Products> sortByPriceAsc() {

		Collections.sort(p, new PriceComparatorAsc());
		return p;

	}

	public List<Products> sortByPriceDesc() {

		Collections.sort(p, new PriceComparator());
		return p;

	}
	
	public List<Products> sortByRatingAsc() {

		Collections.sort(p, new RatingComparatorAsc());
		return p;

	}


	public List<Products> sortByRatingDesc() {

		Collections.sort(p, new RatingComparator());
		return p;

	}

}
