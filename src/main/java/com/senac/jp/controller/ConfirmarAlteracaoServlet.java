package com.senac.jp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.senac.jp.dao.AlunoJDBCdao;
import com.senac.jp.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfirmarAlteracaoServlet
 */
public class ConfirmarAlteracaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String idade = request.getParameter("idade");
		String genero = request.getParameter("genero");
		String semestre = request.getParameter("semestre");
		int id = Integer.parseInt(request.getParameter("id"));
		
		AlunoJDBCdao dao = new AlunoJDBCdao();
	
		try {
			Aluno aluno = dao.pesquisarPorId(id);
			aluno.setNome(nome);
			aluno.setIdade(idade);
			aluno.setGenero(genero);
			aluno.setSemestre(semestre);
			dao.alterarAluno(aluno);
			
			List<Aluno> listaAlunos = new ArrayList<>();
			listaAlunos = dao.listarAlunos();
			request.setAttribute("listaAlunos", listaAlunos);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		request.getRequestDispatcher("listarAlunos.jsp").forward(request, response);
	}

}
