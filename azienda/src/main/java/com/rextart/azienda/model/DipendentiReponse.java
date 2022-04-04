package com.rextart.azienda.model;

import java.util.Date;

public class DipendentiReponse {

	private Integer idDipendente;
	private String nomeDipendente;
	private String cognomeDipendente;
	private Date dataAssunzione;
	private Integer salario;
	private String nomeDipartimento;
	
	
	
	public DipendentiReponse(Integer idDipendente, String nomeDipendente, String cognomeDipendente, Date dataAssunzione,
			Integer salario, String nomeDipartimento) {
		super();
		this.idDipendente = idDipendente;
		this.nomeDipendente = nomeDipendente;
		this.cognomeDipendente = cognomeDipendente;
		this.dataAssunzione = dataAssunzione;
		this.salario = salario;
		this.nomeDipartimento = nomeDipartimento;
	}
	
	public DipendentiReponse() {
		
	}
	
	public Integer getIdDipendente() {
		return idDipendente;
	}
	public void setIdDipendente(Integer idDipendente) {
		this.idDipendente = idDipendente;
	}
	public String getNomeDipendente() {
		return nomeDipendente;
	}
	public void setNomeDipendente(String nomeDipendente) {
		this.nomeDipendente = nomeDipendente;
	}
	public String getCognomeDipendente() {
		return cognomeDipendente;
	}
	public void setCognomeDipendente(String cognomeDipendente) {
		this.cognomeDipendente = cognomeDipendente;
	}
	public Date getDataAssunzione() {
		return dataAssunzione;
	}
	public void setDataAssunzione(Date dataAssunzione) {
		this.dataAssunzione = dataAssunzione;
	}
	public Integer getSalario() {
		return salario;
	}
	public void setSalario(Integer salario) {
		this.salario = salario;
	}
	public String getNomeDipartimento() {
		return nomeDipartimento;
	}
	public void setNomeDipartimento(String nomeDipartimento) {
		this.nomeDipartimento = nomeDipartimento;
	}
	
	
	
	
}
