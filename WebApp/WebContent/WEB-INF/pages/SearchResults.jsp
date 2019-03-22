<%@page import="com.slk.entity.Products"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="./assets/bootstrap/bootstrap.min.css">


<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style type="text/css">
.checked {
	color: orange;
}
</style>

</head>
<body>

<%
	
List<Products> li2 = (List<Products>) request.getAttribute("search");
String name = (String) request.getAttribute("name");



%>

<br>

	<div>
		<h1>
			<b>Online Shopping</b>
		</h1>
		<hr
			style="height: 1px; border: none; color: #333; background-color: #333;" />
	</div>
	
	<h3><%=li2.size() %> Search results for "<%=name %>"</h3>
	
	
	
	
	
	<%
		List<Products> li = (List<Products>) request.getAttribute("search");

		for (Products p : li) {
	%>
	<div style="background-color: #DBE1E1">
		<hr>
		<div style="position: relative; left: 15px; top: 0px;">
				<img width="150px" height="150px" alt="Image not Found" src="./assets/images/<%=p.getImg() %>" />
			</div><br>
		<b>ProductName:<%=p.getName()%></b><br> Price:<%=p.getPrice()%><br>
		Rating:<%
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
		<br> <br> <a href="./AddToCart?id=<%=p.getId()%>"
			class="btn btn-primary">Add to Cart</a> &nbsp; <a href="Buy.jsp"
			class="btn btn-primary">Buy</a>
		<hr>
	</div>
	<%
		}
	%>

</body>
</html>