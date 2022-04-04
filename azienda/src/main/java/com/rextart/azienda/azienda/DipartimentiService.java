package com.rextart.azienda.azienda;

import java.util.List;

import javax.faces.bean.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import com.rextart.azienda.entity.Dipartimento;
import com.rextart.azienda.repository.DipartimentoRepository;

@SuppressWarnings("serial")
@ManagedBean
public class DipartimentiService extends Dipartimento {

	@Autowired
	private DipartimentoRepository dipartimentoRepository;
	
	public List<Dipartimento> getAllDipartimenti(){
		return dipartimentoRepository.findAll();
	}
	
	public void saveDipartimento(Dipartimento dipartimento) {
		dipartimentoRepository.saveAndFlush(dipartimento);
	}
	
	public void deleteDipartimento(Integer id) {
		dipartimentoRepository.deleteById(id);
	}
	
	public void updateDipartimento(Dipartimento dipartimento) {
		dipartimentoRepository.saveAndFlush(dipartimento);
	
	}

}
