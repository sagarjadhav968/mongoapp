package com.desire3d.progma.fw.command.repository;

import com.desire3d.progma.model.NewFieldDefination;
import com.desire3d.progma.model.SQLDefination;

public interface SQLDefinationRepository {

	public SQLDefination saveOrUpdate(SQLDefination sqlDefination);

	public SQLDefination findById(String id);

	public NewFieldDefination findByFieldId(String id);

	NewFieldDefination saveNewFieldDefination(NewFieldDefination newFieldDefination);
}
