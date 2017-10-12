/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTCONFIG.JAVA                                       */
/* Description:   Domain definition to manipulate configuration objects       */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.03/2017                                                 */
/* Last Modified: Oct.11/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.03/2017 COQ  File created.
 -----------------------------------------------------------------------------*/

package com.csoftz.ceiba.java.learn.parking.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Domain definition to manipulate configuration objects. <br>
 * <br>
 * The purpose is to hold Parking lot configuration variables in a centralized
 * may it be a database, a configuration file or any other persistence way.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.11/2017
 * @since 1.8 (JDK), Oct.03/2017
 */
public class ParkinglotConfig {
	private Long id;
	private String name;
	private String value;
	private String description;

	/**
	 * Default constructor.
	 */
	public ParkinglotConfig() {
		this.id = 0L;
		this.name = "";
		this.value = "";
		this.description = "";
	}

	/**
	 * Constructor with fields.
	 * 
	 * @param id
	 *            Identifier for the object.
	 * @param name
	 *            Describes the configuration variable.
	 * @param value
	 *            Content of variable.
	 * @param description
	 *            What it is used for.
	 */
	public ParkinglotConfig(Long id, String name, String value, String description) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.description = description;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(name).append(value).append(description).toHashCode();
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		ParkinglotConfig other = (ParkinglotConfig) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(id, other.description).append(name, other.name)
				.append(value, other.value).append(description, other.description).isEquals();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParkinglotConfig [id=" + id + ", name=" + name + ", value=" + value + ", description=" + description
				+ "]";
	}

}
