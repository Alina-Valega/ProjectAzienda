package com.rextart.azienda.dao;

import java.util.List;
import java.util.Optional;

import com.rextart.azienda.entity.Dipendenti;
import com.rextart.azienda.model.DipendentiReponse;

public interface DipendenteDao {
	
	public List <Dipendenti> getAllDipendenti();
	
	public Dipendenti getDipendente(int id_dipendente);
	
	public void saveDipendente(Dipendenti dipendente);
	
	public void updateDipendente (Dipendenti dipendente);
	
	public void deleteDipendnete(int idDipendente);
	
}


