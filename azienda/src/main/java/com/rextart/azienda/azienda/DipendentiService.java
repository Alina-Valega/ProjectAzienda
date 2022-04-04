package com.rextart.azienda.azienda;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rextart.azienda.entity.Dipendenti;
import com.rextart.azienda.repository.DipendenteRepository;

@Service
@ManagedBean(name="dipendentiController")
public class DipendentiService {
	
	@PersistenceContext
	@Autowired
	

	private EntityManager em;
	
	//Lista dipendenti
	@SuppressWarnings("unchecked")
	public List<Dipendenti> getAllDipendenti(){
		
		@SuppressWarnings("unused")
			List<Dipendenti> listDipendenti = new ArrayList<Dipendenti>();
		try {
			listDipendenti = em.createNamedQuery("Dipendneti.findAll").getResultList();
		}
		catch(Exception e) {}
		
		return dipendenteRepository.findAll();
	}
	
	
	public void saveDipendente(Dipendenti dipendente) {
		dipendenteRepository.saveAndFlush(dipendente);
	}
	
	public void deleteDipendente(Integer id) {
		dipendenteRepository.deleteById(id);
	}
	
	public void updateDipendente(Dipendenti dipendente) {
		dipendenteRepository.saveAndFlush(dipendente);
	
	}
	
}
