<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>WEB-APP</title>

<link rel="stylesheet" type="text/css"
	href="./assets/bootstrap/bootstrap.min.css">
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

	<div style="position: absolute; left: 1120px; top: 30px;">
		<a href="./MyCart"><span
			style="position: absolute; bottom: 15px; left: 16px;"><font
				color="black" size="2px"><b>0</b></font></span><img height="45px"
			width="45px" alt="Not found" src="./assets/images/cart.png"><font
			color="black"><b>MyCart</b></font></a>&nbsp;&nbsp;&nbsp;&nbsp;<a
			href="./ShowProducts" class="btn btn-primary">Show products</a>&nbsp;&nbsp;&nbsp;&nbsp;
			
			<%
			HttpSession s = request.getSession(false);
			String name = null;
			try{
				 name = (String) s.getAttribute("name");
			}catch(Exception e){
				System.out.println("E:"+e);
			}
			
				
				System.out.println("name:"+name);
	
				if(name==null){
			%>
			<a href="./login"
			class="btn btn-primary" id="login">Login</a>
			<%
				}else{
			%>
				<l><%=s.getAttribute("name") %></l> <div style="position: absolute; bottom: 50px; left: 115px;"><a href="./logout"
			 id="logout">Logout</a></div>
			<%
				}
			%>
			

	</div>



</body>
</html>