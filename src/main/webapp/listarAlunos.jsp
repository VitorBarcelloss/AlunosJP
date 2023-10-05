<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.senac.jp.model.Aluno, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listar alunos</title>
</head>
<body>
<%List<Aluno> listaAlunos = (List<Aluno>) request.getAttribute("alunos"); %>
<h2> Bem vindo <%=session.getAttribute("usuario") %></h2>

<a href="cadastrarAluno.jsp">Cadastrar Alunos</a>

<table border=1>
	<tr>
		<th>Detalhar</th>
		<th>Id</th>
		<th>Nome</th>
		<th>Idade</th>
		<th>Genero</th>
		<th>Semestre</th>
		<th>Matricula</th>
		<th>Excluir</th>
	</tr>
	<%if(listaAlunos != null){		
		for(Aluno aluno:listaAlunos){ %>
		<tr>
			<td><a href="detalharAlunos.jsp">Detalhar</a></td>
			<td><%=aluno.getId() %></td>
			<td><%=aluno.getNome() %></td>
			<td><%=aluno.getIdade() %></td>
			<td><%=aluno.getGenero() %></td>
			<td><%=aluno.getSemestre() %></td>
			<td><%=aluno.getMatricula() %></td>
			<td><a href="ExcluirServlet">Excluir</a></td>
		</tr>
	<%} }%>
</table>
</body>
</html>