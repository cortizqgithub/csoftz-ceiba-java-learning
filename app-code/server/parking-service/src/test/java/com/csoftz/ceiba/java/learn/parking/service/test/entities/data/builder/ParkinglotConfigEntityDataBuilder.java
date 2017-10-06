/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTCONFIGENTITYDATABUILDER.JAVA                      */
/* Description:   Test Data Builder Pattern for ParkinglotConfigEntity entity */
/*                object.                                                     */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.04/2017                                                 */
/* Last Modified: Oct.06/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.04/2017 COQ  File created.
 -----------------------------------------------------------------------------*/

package com.csoftz.ceiba.java.learn.parking.service.test.entities.data.builder;

import com.csoftz.ceiba.java.learn.parking.service.entities.ParkinglotConfigEntity;

/**
 * Test Data Builder Pattern for ParkinglotConfigEntity entity object.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.06/2017
 * @since 1.8 (JDK), Oct.04/2017
 */
public class ParkinglotConfigEntityDataBuilder {
	private Long id;
	private String name;
	private String value;
	private String description;

	/**
	 * Default constructor.
	 */
	public ParkinglotConfigEntityDataBuilder() {
		this.id = 0L;
		this.name = "";
		this.value = "";
		this.description = "";
	}

	/**
	 * Assign id field to ParkinglotConfigEntity.
	 * 
	 * @param id
	 *            Identifier for the object.
	 * @return A reference to itself.
	 */
	public ParkinglotConfigEntityDataBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Assign name field to ParkinglotConfigEntity.
	 * 
	 * @param name
	 *            Describes the configuration variable.
	 * @return A reference to itself.
	 */
	public ParkinglotConfigEntityDataBuilder withName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Assign value field to ParkinglotConfigEntity.
	 * 
	 * @param value
	 *            Content of variable.
	 * @return A reference to itself.
	 */
	public ParkinglotConfigEntityDataBuilder withValue(String value) {
		this.value = value;
		return this;
	}

	/**
	 * Assign description field to ParkinglotConfigEntity.
	 * 
	 * @param description
	 *            What it is used for.
	 * @return A reference to itself.
	 */
	public ParkinglotConfigEntityDataBuilder withDescription(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Makes a representation of ParkinglotConfigEntity to test.
	 * 
	 * @return A reference to itself.
	 */
	public ParkinglotConfigEntity build() {
		return new ParkinglotConfigEntity(this.id, this.name, this.value, this.description);
	}

}
