package com.jsf.jpa.crud;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the school database table.
 * 
 */
@Entity
@Table(name="school")
@NamedQuery(name="SchoolEntityManager.findAll", query="SELECT s FROM SchoolEntityManager s")
public class SchoolEntityManager implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_school", unique=true, nullable=false)
	private int idSchool;

	@Column(nullable=false, length=120)
	private String name;

	public SchoolEntityManager() {
	}

	public int getIdSchool() {
		return this.idSchool;
	}

	public void setIdSchool(int idSchool) {
		this.idSchool = idSchool;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}