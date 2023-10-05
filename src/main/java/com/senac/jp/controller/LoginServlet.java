package com.senac.jp.controller;

import java.io.IOException;
import java.util.List;

import com.senac.jp.dao.AlunoJDBCdao;
import com.senac.jp.model.Aluno;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuario = (String) request.getParameter("usuario");
		String password = (String) request.getParameter("senha");
		
		if(usuario.equals("admin") && password.equals("admin")
				&& usuario != null && password != null) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(10);
			session.setAttribute("usuario", usuario);
			AlunoJDBCdao dao = new AlunoJDBCdao();
			
			
			try {
				List<Aluno>  listaAlunos = dao.listarAlunos();
				request.setAttribute("alunos", listaAlunos);
				request.getRequestDispatcher("listarAlunos.jsp").forward(request, response);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}else {
			request.setAttribute("message", "Usuario ou senha incorreto, tente novamente!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

}
