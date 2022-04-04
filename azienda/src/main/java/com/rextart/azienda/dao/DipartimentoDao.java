package com.rextart.azienda.dao;

import java.util.List;
import java.util.Optional;

import com.rextart.azienda.entity.Dipartimento;

public interface DipartimentoDao {

public List <Object[]> getAllDipartimenti();
	
	public Dipartimento getDipartimenti(int id_dipartimento);
	
	public void updateDipendente (Dipartimento dipartimento);
	
	public void deleteDipendnete(Dipartimento dipartimento);
  
}
