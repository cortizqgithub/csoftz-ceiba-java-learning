/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTCONFIGENTITY.JAVA                                 */
/* Description:   Domain definition to manipulate configuration objects       */
/*                (Entity).                                                   */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.03/2017                                                 */
/* Last Modified: Oct.10/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.03/2017 COQ  File created.
 -----------------------------------------------------------------------------*/

package com.csoftz.ceiba.java.learn.parking.service.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Domain definition to manipulate configuration objects (Entity). <br>
 * <br>
 * The purpose is to hold Parking lot configuration variables in a centralized
 * may it be a database, a config or any other persistence way.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.10/2017
 * @since 1.8 (JDK), Oct.04/2017
 */

@Entity
@Table(name = "parking_lot_config")
public class ParkinglotConfigEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = false)
	private String value;

	@Column(nullable = false)
	private String description;

	/**
	 * Constructor with fields.
	 * 
	 * @param id
	 *            Identifier for the object.
	 * @param name
	 *            Describes the configuration variable.
	 * @param value
	 *            Content of variable
	 * @param description
	 *            What it is used for.
	 */
	public ParkinglotConfigEntity(Long id, String name, String value, String description) {
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
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
		ParkinglotConfigEntity other = (ParkinglotConfigEntity) obj;
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
		return "ParkinglotConfigEntity [id=" + id + ", name=" + name + ", value=" + value + ", description="
				+ description + "]";
	}

}
