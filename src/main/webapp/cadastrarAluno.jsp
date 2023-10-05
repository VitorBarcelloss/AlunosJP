<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Cadastrar aluno</h2>
	<form action="ConfirmarCadastroServlet" method="post">
		Nome:
		<input type="text" name="nome">
		Idade:
		<input type="text" name="idade">
		Genero:
		<input type="text" name="genero">
		Semestre:
		<input type="text" name="semestre">
		<input type="submit" value="Cadastrar">
	</form>
</body>
</html>