package com.senac.jp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.senac.jp.model.Aluno;

public class AlunoJDBCdao {
	 
	public Connection getConexao() throws ClassNotFoundException {
		String driver = "com.mysql.cj.jdbc.Driver";
		
		String url = "jdbc:mysql://localhost:3306/aluno?useTimezone=true&serverTimezone=UTC";
		
		String user = "root";
		
		String password = "root";
		
		Connection con = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url,user,password);
			System.out.println("Conectado ao banco de dados");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public List<Aluno> listarAlunos() throws ClassNotFoundException{
		List<Aluno> alunos = new ArrayList<>();
		String query = "SELECT * FROM alunos";
		
		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String idade = rs.getString(3);
				String semestre = rs.getString(4);
				String genero = rs.getString(5);
				String matricula = rs.getString(6);
				alunos.add(new Aluno(id,name, idade, semestre, genero, matricula));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return alunos;
	}
}
