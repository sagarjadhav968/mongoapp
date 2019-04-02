package com.desire3d.progma.model;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(table = "field_definition", detachable = "true")
public class NewFieldDefination {

	@PrimaryKey
	@Persistent(column = "_id", customValueStrategy = "uuid")
	public String id;

	@Persistent
	private String newfieldname;

	public String getNewfieldname() {
		return newfieldname;
	}

	public void setNewfieldname(String newfieldname) {
		this.newfieldname = newfieldname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}