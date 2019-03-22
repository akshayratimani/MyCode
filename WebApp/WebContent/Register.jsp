<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="./assets/bootstrap/bootstrap.min.css">
<style>
.label-color {
	background-color: #800080;
	color: white;
}

table, th, td {
	border: 1px solid black;
	padding: 5px;
}

table {
	border-spacing: 15px;
}

table tr:nth-child(even) {
	background-color: #FF0000;
}

table tr:nth-child(odd) {
	background-color: #fff;
}

table th {
	background-color: black;
	color: white;
}
</style>
</head>
<body>

	<form action="./RegisterServlet" method="POST">
		<center>
			<br>
			<br> <h2><b>Register yourself</b></h2> <br><br>First Name <input type="text"
				name="fname" value="" required><br><br> Last Name <input type="text" name="lname"
				value="" required><br><br> Email <input type="text" name="email" value="" required><br><br> User
			Name <input type="text" name="uname" value="" required><br><br> Password <input
				type="password" name="pass" value="" required><br><br> <input type="submit"
				value="Submit" > <input type="reset" value="Reset" />

		</center>
	</form>

</body>
</html>