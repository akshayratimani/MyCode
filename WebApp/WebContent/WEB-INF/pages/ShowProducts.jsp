<%@page import="com.slk.entity.Products"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="./assets/bootstrap/bootstrap.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style type="text/css">
.topnav .search-container button {
	float: right;
	padding: 6px 10px;
	margin-top: 8px;
	margin-right: 16px;
	background: #ddd;
	font-size: 17px;
	border: none;
	cursor: pointer;
}

.checked {
	color: orange;
}
</style>
</head>
<body>

	<br>

	<div>
		<h1>
			<b>Online Shopping</b>
		</h1>
		<hr
			style="height: 1px; border: none; color: #333; background-color: #333;" />
	</div>

	<%
		HttpSession s = request.getSession(false);
		String name = (String) s.getAttribute("name");

		int num = (int) request.getAttribute("n");
		if (name == null) {
			num = 0;
		}
		System.out.println("num" + num);
	%>

	<div style="position: absolute; left: 1220px; top: 30px;">
		<a href="./MyCart"><span
			style="position: absolute; bottom: 15px; left: 16px;"><font
				color="black" size="2px"><b><%=num%></b></font></span><img height="45px"
			width="45px" alt="Not found" src="./assets/images/cart.png"><font
			color="black"><b>MyCart</b></font></a>&nbsp;&nbsp;&nbsp;&nbsp;
		<%
			System.out.println("name:" + name);

			if (name == null) {
		%>
		<a href="./login" class="btn btn-primary" id="login">Login</a>
		<%
			} else {
		%>
		<l><%=s.getAttribute("name")%></l>
		<div style="position: absolute; bottom: 50px; left: 115px;">
			<a href="./logout" id="logout">Logout</a>
		</div>
		<%
			}
		%>
	</div>


	<h3>List of all Products</h3>

	<div class="search-container">
		<form action="./Search" method="POST">
			<input type="text" placeholder="Search.." name="search" required>
			<button type="submit" value="search">Search</button>
		</form>
	</div>

	<div style="position: absolute; left: 300px; top: 145px;">
		<h6>
			<b>sort by :
				<form action="./Sort" method="get">
					<div style="position: absolute; left: 65px; top: 0px;">

						<select name="a">
							<option value="PriceAsc">Price Low->High</option>
							<option value="PriceDesc">Price High->Low</option>
							<option value="RatingAsc">Rating Low->High</option>
							<option value="RatingDesc">Rating High->Low</option>
							<option value="NameAsc">Name A->Z</option>
							<option value="NameDesc">Name Z->A</option>
						</select>
						<div style="position: absolute; left: 150px; top: 0px;">
							<input type="submit" value="Sort">
						</div>
					</div>
	</div>
	</form>
	</h6>


	</div>

	<%
		List<Products> li = (List<Products>) request.getAttribute("val");

		for (Products p : li) {
	%>
	<div style="background-color: #DBE1E1">
		<a href="./productdetails"><div style="background-color: #DBE1E1">
			<hr>
			<div style="position: relative; left: 15px; top: 0px;">
				<img width="150px" height="150px" alt="Image not Found" src="./assets/images/<%=p.getImg() %>" />
			</div><br>
			<b>ProductName:<%=p.getName()%></b><br> Price:<%=p.getPrice()%><br>
			Rating:
			<%
				int n = (int) p.getRating();
					for (int i = 0; i < n; i++) {
			%>
			<span class="fa fa-star checked"></span>
			<%
				}
					n = 5 - n;
					for (int i = 0; i < n; i++) {
			%>
			<span class="fa fa-star"></span>

			<%
				}
			%>


		</div>
		</a>
		<div style="background-color: #DBE1E1">
			<br> <br> <a href="./AddToCart?id=<%=p.getId()%>"
				class="btn btn-primary">Add to Cart</a> &nbsp; <a href="Buy.jsp"
				class="btn btn-primary">Buy</a>
			<hr>
		</div>
	</div>
	<%
		}
	%>


</body>
</html>