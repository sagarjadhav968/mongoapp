package com.desire3d.progma.model;

import java.util.List;

import javax.jdo.annotations.EmbeddedOnly;
import javax.jdo.annotations.FetchGroup;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable(detachable = "true")
@EmbeddedOnly
@FetchGroup(members = { @Persistent(name = "name"), @Persistent(name = "boundedContextId"),
		@Persistent(name = "domainId") ,})
public class ModelDefination {

	private String name;

	private String boundedContextId;

	private String domainId;

	@Persistent(defaultFetchGroup = "true")
	private List<NewFieldDefination> newFieldDefination;

	public ModelDefination() {

	}

	public ModelDefination(String name, String boundedContextId, String domainId,
			List<NewFieldDefination> fieldDefination) {
		this.name = name;
		this.boundedContextId = boundedContextId;
		this.domainId = domainId;
		this.newFieldDefination = fieldDefination;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the boundedContextId
	 */
	public String getBoundedContextId() {
		return boundedContextId;
	}

	/**
	 * @param boundedContextId
	 *            the boundedContextId to set
	 */
	public void setBoundedContextId(String boundedContextId) {
		this.boundedContextId = boundedContextId;
	}

	/**
	 * @return the domainId
	 */
	public String getDomainId() {
		return domainId;
	}

	/**
	 * @param domainId
	 *            the domainId to set
	 */
	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}

	public List<NewFieldDefination> getNewFieldDefination() {
		return newFieldDefination;
	}

	public void setNewFieldDefination(List<NewFieldDefination> newFieldDefination) {
		this.newFieldDefination = newFieldDefination;
	}

}