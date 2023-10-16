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
 * Servlet implementation class DetalharServlet
 */
public class DetalharServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    
    public DetalharServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		AlunoJDBCdao dao = new AlunoJDBCdao();
		Aluno aluno;
		try {
			aluno = dao.pesquisarPorId(id);
			request.setAttribute("aluno", aluno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
		request.getRequestDispatcher("detalharAlunos.jsp").forward(request, response); 
		
		
	}



}
