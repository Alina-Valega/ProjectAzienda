package com.rextart.azienda.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="Dipendente")
@NamedQuery(name="EntityManager.findAll", query="SELECT d FROM Dipendente d order by d.id")

public class Dipendenti implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dipendente", unique=true, nullable=false)
	private int idDipendente;
	
	@Column(name = "nome_dipendente", nullable=false, length=120)
	private String nomeDipendente;
	
	@Column(name = "cognome_dipendente",nullable=false, length=120)
	private String cognomeDipendente;
	
	@Column(name = "data_assunzione", nullable=false)
	private Date dataAssunzione;
	
	@Column(nullable=false)
	private float salario;
	
	@ManyToOne()
	@JoinColumn(name ="id_dipartimento_fk", referencedColumnName = "id_dipendente", nullable= false)
	private Dipartimento dipartimento;
	
	public Dipartimento getDipartimento() {
		return dipartimento;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}

	public int getIdDipendente() {
		return idDipendente;
	}

	public void setIdDipendente(int idDipendente) {
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

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

}