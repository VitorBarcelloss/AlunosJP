package com.senac.jp.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.senac.jp.dao.AlunoJDBCdao;
import com.senac.jp.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlterarServlet
 */
public class AlterarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Aluno aluno = new Aluno();
		AlunoJDBCdao dao = new AlunoJDBCdao();
		
		try {
			aluno = dao.pesquisarPorId(id);
			request.setAttribute("aluno", aluno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("alterarAluno.jsp").forward(request, response);
		
	}

}
