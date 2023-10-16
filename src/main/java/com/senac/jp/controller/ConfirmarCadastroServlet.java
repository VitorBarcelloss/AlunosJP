package com.senac.jp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.senac.jp.dao.AlunoJDBCdao;
import com.senac.jp.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ConfirmarCadastroServlet
 */
public class ConfirmarCadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Recuperando a sessão
		HttpSession session = request.getSession();
		
		// Recuperando os valores informados
		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");
		String genero = request.getParameter("genero");
		String semestre = request.getParameter("semestre");
		String matricula = request.getParameter("matricula");
		
		AlunoJDBCdao dao = new AlunoJDBCdao();
		Aluno aluno = new Aluno(nome,idade,genero,semestre,matricula);
		List<Aluno> listaAlunos;
		try {
			aluno = dao.cadastrarAluno(aluno);
			listaAlunos = dao.listarAlunos();
			request.setAttribute("aluno", aluno);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("detalharAlunos.jsp").forward(request, response);
		
		
		
		
		
		
		
	}

}
