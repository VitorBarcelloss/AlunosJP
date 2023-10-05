<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2>Entre com sua conta:</h2>
<form action="LoginServlet" method="post">
	Usuario:
	<input type="text" name="usuario">
	Senha:
	<input type="password" name="senha">
	<input type="submit" value="Enviar">
</form>
<%=
request.getAttribute("message") == null? "" : request.getAttribute("message")
%>

</body>
</html>