/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTCONFIGDATABUILDER.JAVA                            */
/* Description:   Test Data Builder Pattern for ParkinglotConfig domain object*/
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.04/2017                                                 */
/* Last Modified: Oct.10/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.04/2017 COQ  File created.
 -----------------------------------------------------------------------------*/

package com.csoftz.ceiba.java.learn.parking.service.test.domain.data.builder;

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotConfig;

/**
 * Test Data Builder Pattern for ParkinglotConfig domain object.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.10/2017
 * @since 1.8 (JDK), Oct.04/2017
 */
public class ParkinglotConfigDataBuilder {
	private Long id;
	private String name;
	private String value;
	private String description;

	/**
	 * Default constructor.
	 */
	public ParkinglotConfigDataBuilder() {
		this.id = 0L;
		this.name = "";
		this.value = "";
		this.description = "";
	}

	/**
	 * Assign id field to ParkinglotConfig.
	 * 
	 * @param id
	 *            Identifier for the object.
	 * @return A reference to itself.
	 */
	public ParkinglotConfigDataBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Assign name field to ParkinglotConfig.
	 * 
	 * @param name
	 *            Describes the configuration variable.
	 * @return A reference to itself.
	 */
	public ParkinglotConfigDataBuilder withName(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Assign value field to ParkinglotConfig.
	 * 
	 * @param value
	 *            Content of variable.
	 * @return A reference to itself.
	 */
	public ParkinglotConfigDataBuilder withValue(String value) {
		this.value = value;
		return this;
	}

	/**
	 * Assign description field to ParkinglotConfig.
	 * 
	 * @param description
	 *            What it is used for.
	 * @return A reference to itself.
	 */
	public ParkinglotConfigDataBuilder withDescription(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Makes a representation of ParkinglotConfig to test.
	 * 
	 * @return A reference to itself.
	 */
	public ParkinglotConfig build() {
		return new ParkinglotConfig(this.id, this.name, this.value, this.description);
	}
}
