<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	if (session.getAttribute("thisSession") != null) {

	//not the samething
	//response.sendRedirect("SessionServlet");
	
	RequestDispatcher rd = request.getRequestDispatcher("LoginModel");
	rd.forward(request, response);// this lands on the GET in the servlet
}
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>

	<form action="<%=request.getContextPath()%>/LoginModel" method="post">
		<table>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="userpass"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>

</body>
</html>