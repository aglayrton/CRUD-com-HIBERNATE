package com.projetocursoshibernate;
// Generated 29/06/2020 15:59:06 by Hibernate Tools 5.4.14.Final

/**
 * Curso generated by hbm2java
 */
public class Curso implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long cdcurso;
	private String nome;
	private long valor;

	public Curso() {
	}

	public Curso(long cdcurso, String nome, long valor) {
		this.cdcurso = cdcurso;
		this.nome = nome;
		this.valor = valor;
	}

	public Long getCdcurso() {
		return this.cdcurso;
	}

	public void setCdcurso(Long cdcurso) {
		this.cdcurso = cdcurso;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getValor() {
		return this.valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

}