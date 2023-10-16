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
public Connection getConexao () throws ClassNotFoundException {
		
		//Driver
		String driver = "com.mysql.cj.jdbc.Driver";
		
		// Banco de Dados
		String url = "jdbc:mysql://localhost:3306/aluno?useTimezone=true&serverTimezone=UTC";
		
		// Usuario
		String user = "root";
		
		// Senha
		String password = "root";
		
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Conectado ao banco de dados");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public List<Aluno> listarAlunos() throws SQLException {
		List<Aluno> alunos = new ArrayList<>();
		String query = "SELECT * FROM alunos";
		
		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String idade = rs.getString(3);
				String semestre = rs.getString(4);
				String genero = rs.getString(5);
				String matricula = rs.getString(6);
				alunos.add(new Aluno(id, nome, idade, semestre,genero,matricula));
			}
			
			rs.close();
			pst.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return alunos;
		
	}
	
	public Aluno pesquisarPorId(int id) throws SQLException {
		 String query = "Select * from alunos where id =?";
	        Aluno aluno = null;
			try {
				Connection con = getConexao();
				PreparedStatement pst = con.prepareStatement(query);
				pst.setInt(1, id);
				
				ResultSet rs = pst.executeQuery();
				while (rs.next()) {
					String nome = rs.getString(2);
					String idade = rs.getString(3);
					String semestre = rs.getString(4);
					String genero = rs.getString(5);
					String matricula = rs.getString(6);
					aluno = new Aluno (id,nome,idade,semestre,genero,matricula);
				}
				
				pst.close();
				con.close();
				return aluno;
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
		}
			return null;
		
	}
	
	public String excluirAluno(int id)throws SQLException{
		String query = "DELETE FROM alunos WHERE id = ?;";
		
		try {
			Connection con = getConexao();
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1, id);
			int linhasAfetadas = pst.executeUpdate();
			if(linhasAfetadas == 0) {
				return "Aluno não encontrado";
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return "Aluno excluido com sucesso";
	}
	
	public Aluno cadastrarAluno(Aluno aluno) throws SQLException {
		String query = "INSERT INTO alunos (nome, idade, semestre, genero, matricula) VALUES (?, ?, ?, ?, ?);";
		
		try {
			Connection con = getConexao();
		
			try(PreparedStatement pst = con.prepareStatement(query);){
				pst.setString(1, aluno.getNome());
				pst.setString(2, aluno.getIdade());
				pst.setString(3, aluno.getGenero());
				pst.setString(4, aluno.getMatricula());
				pst.setString(5, aluno.getSemestre());
				pst.executeUpdate();
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return aluno;
	}
	
	public Aluno alterarAluno(Aluno aluno) throws SQLException {
		String query = "UPDATE alunos SET nome = ?, idade = ?, genero = ?, semestre = ? WHERE id = ?;";
		
		try {
			Connection con = getConexao();
		
			try(PreparedStatement pst = con.prepareStatement(query);){
				pst.setString(1, aluno.getNome());
				pst.setString(2, aluno.getIdade());
				pst.setString(3, aluno.getGenero());
				pst.setString(4, aluno.getSemestre());
				pst.setInt(5, aluno.getId());
				pst.executeUpdate();
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return aluno;
	}
	
}
