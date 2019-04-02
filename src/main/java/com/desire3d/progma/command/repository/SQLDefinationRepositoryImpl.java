package com.desire3d.progma.command.repository;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.desire3d.progma.fw.command.repository.SQLDefinationRepository;
import com.desire3d.progma.model.NewFieldDefination;
import com.desire3d.progma.model.SQLDefination;

@Repository
public class SQLDefinationRepositoryImpl implements SQLDefinationRepository {

	@Autowired
	private PersistenceManagerFactory pmf;

	@Override
	public SQLDefination saveOrUpdate(SQLDefination sqlDefination) {
		PersistenceManager pm = pmf.getPersistenceManager();
		return pm.makePersistent(sqlDefination);
	}

	@Override
	public NewFieldDefination saveNewFieldDefination(NewFieldDefination newFieldDefination) {
		PersistenceManager pm = pmf.getPersistenceManager();
		return pm.makePersistent(newFieldDefination);
	}

	@Override
	public SQLDefination findById(String id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		return pm.getObjectById(SQLDefination.class, id);
	}

	@Override
	public NewFieldDefination findByFieldId(String id) {
		PersistenceManager pm = pmf.getPersistenceManager();
		return pm.getObjectById(NewFieldDefination.class, id);
	}

}
