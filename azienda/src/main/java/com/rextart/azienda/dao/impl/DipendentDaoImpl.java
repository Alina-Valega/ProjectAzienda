package com.rextart.azienda.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rextart.azienda.dao.DipendenteDao;
import com.rextart.azienda.entity.Dipendenti;
import com.rextart.azienda.model.DipendentiReponse;

public class DipendentDaoImpl implements DipendenteDao{

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Azienda");
	private EntityManager em = emf.createEntityManager();
	
	@Override
	public List<Dipendenti> getAllDipendenti() {
		return em.createQuery("form Dipendenti").getResultList();
	}

	@Override
	public Dipendenti getDipendente(int idDipendente) {
		 Dipendenti dipendente = em.find(Dipendenti.class, idDipendente);
	        return dipendente != null ? dipendente : null;
	}

	@Override
	public void saveDipendente(Dipendenti dipendente) {
		try {
			em.getTransaction().begin();
			em.persist(dipendente);
			em.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateDipendente(Dipendenti dipendente) {
		try {
			em.getTransaction().begin();
			em.persist(dipendente);
			em.getTransaction().commit();
			em.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteDipendnete(int idDipendente) {
		 Dipendenti dipendente = em.find(Dipendenti.class, idDipendente);
		 em.getTransaction().begin();
		 em.remove(dipendente);
		 em.getTransaction().commit();		
	}

}
