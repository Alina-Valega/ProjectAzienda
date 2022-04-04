package com.rextart.azienda.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.rextart.azienda.dao.DipartimentoDao;
import com.rextart.azienda.entity.Dipartimento;

public class DipartimentoDaoImpl implements DipartimentoDao {

	private static final String PERSISTENCE_UNIT_NAME = "JSFJPACrud";   
    private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    private static EntityTransaction transactionObj = entityMgrObj.getTransaction();
	
	@Override
	public List<Object[]> getAllDipartimenti() {
		
		Query getAll = entityMgrObj.createNamedQuery("Dipartimento.findAll", Dipartimento.class);
		List<Object[]> result = getAll.getResultList();
		return result;
	}

	@Override
	public Dipartimento getDipartimenti(int id_dipartimento) {
		
		Query findBy = entityMgrObj.createQuery("SELECT * FROM ");
		
		return null;
	}

	@Override
	public void updateDipendente(Dipartimento dipartimento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteDipendnete(Dipartimento dipartimento) {
		// TODO Auto-generated method stub
		
	}

}
