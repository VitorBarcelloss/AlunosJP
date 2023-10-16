package com.senac.jp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.senac.jp.dao.AlunoJDBCdao;
import com.senac.jp.model.Aluno;

/**
 * Servlet implementation class ListaServlet
 */
public class ListaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AlunoJDBCdao dao = new AlunoJDBCdao();
		List<Aluno> listaAlunos;
		try {
			listaAlunos = dao.listarAlunos();
			request.setAttribute("listaAlunos", listaAlunos);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("listarAlunos.jsp").forward(request, response);
		
	}


}
