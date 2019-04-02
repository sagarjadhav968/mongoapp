package com.desire3d.progma.model;

import java.util.List;

import javax.jdo.annotations.DatastoreIdentity;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable(table = "sql_defination")
@DatastoreIdentity(customStrategy = "uuid")
public class SQLDefination {

    @PrimaryKey
	@Persistent(column = "_id", customValueStrategy = "uuid")
    public String id;

    public String name;

    private String sql;

    @Persistent(defaultFetchGroup = "true")
    private List<Parameter> params;
    
    @Persistent(defaultFetchGroup = "true")
    private ModelDefination modelDefination;

    public SQLDefination(){

    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sql
     */
    public String getSql() {
        return sql;
    }

    /**
     * @param sql the sql to set
     */
    public void setSql(String sql) {
        this.sql = sql;
    }

    /**
     * @return the params
     */
    public List<Parameter> getParams() {
        return params;
    }

    /**
     * @param params the params to set
     */
    public void setParams(List<Parameter> params) {
        this.params = params;
    }

    /**
     * @return the modelDefination
     */
    public ModelDefination getModelDefination() {
        return modelDefination;
    }

    /**
     * @param modelDefination the modelDefination to set
     */
    public void setModelDefination(ModelDefination modelDefination) {
        this.modelDefination = modelDefination;
    }
 

    
}