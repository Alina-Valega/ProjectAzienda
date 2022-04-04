package com.rextart.azienda.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="Dipartimento")
@NamedQuery(name="EntityManager.findAll", query="SELECT s FROM EntityManager s")
public class Dipartimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_dipartimento", unique=true, nullable=false)
	private Integer idDipartimento;

	@Column(name = "nome_dipartimento", nullable=false, length=120)
	private String nomeDipartimento;
	
	@OneToMany(mappedBy= "dipartimento")
	private List<Dipendenti> dipendenti;
	
	public int getIdDipartimento() {
		return idDipartimento;
	}
	
	public void setIdDipartimento(int idDipartimento) {
		this.idDipartimento = idDipartimento;
	}

	public String getNomeDipartimento() {
		return nomeDipartimento;
	}

	public void setNome_dipartimento(String nomeDipartimento) {
		this.nomeDipartimento = nomeDipartimento;
	}
	
}
