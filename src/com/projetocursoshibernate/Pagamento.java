package com.projetocursoshibernate;
// Generated 29/06/2020 15:59:06 by Hibernate Tools 5.4.14.Final

/**
 * Pagamento generated by hbm2java
 */
public class Pagamento implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private PagamentoId id;
	private String datainscricao;

	public Pagamento() {
	}

	public Pagamento(PagamentoId id, String datainscricao) {
		this.id = id;
		this.datainscricao = datainscricao;
	}

	public PagamentoId getId() {
		return this.id;
	}

	public void setId(PagamentoId id) {
		this.id = id;
	}

	public String getDatainscricao() {
		return this.datainscricao;
	}

	public void setDatainscricao(String datainscricao) {
		this.datainscricao = datainscricao;
	}
	
	@Override
	public String toString() {
		return "Pagamento [cpf="+id.getCpf()+" cdcurso="+id.getCdcurso()+" data_inscricao="+datainscricao+"]";
	}
}