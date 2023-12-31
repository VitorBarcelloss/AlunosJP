package com.senac.jp.model;

public class Aluno {
	private int id;
	private String nome;
	private String idade;
	private String semestre;
	private String genero;
	private String matricula;
	
	public Aluno() {
	
	}
	public Aluno(String nome, String idade, String semestre, String genero) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.semestre = semestre;
		this.genero = genero;
	}
	public Aluno(String nome, String idade, String semestre, String genero, String matricula) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.semestre = semestre;
		this.genero = genero;
		this.matricula = matricula;
	}
	public Aluno(int id, String nome, String idade, String semestre, String genero, String matricula) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.semestre = semestre;
		this.genero = genero;
		this.matricula = matricula;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getIdade() {
		return idade;
	}
	public void setIdade(String idade) {
		this.idade = idade;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}

}
