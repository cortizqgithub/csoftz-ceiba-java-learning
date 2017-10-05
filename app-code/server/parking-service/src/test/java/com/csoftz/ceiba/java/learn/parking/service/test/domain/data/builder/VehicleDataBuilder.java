/*----------------------------------------------------------------------------*/
/* Source File:   VEHICLEDATABUILDER.JAVA                                     */
/* Description:   Test Data Builder Pattern for Vehicle domain object.        */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.04/2017                                                 */
/* Last Modified: Oct.04/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.04/2017 COQ  File created.
 -----------------------------------------------------------------------------*/

package com.csoftz.ceiba.java.learn.parking.service.test.domain.data.builder;

import com.csoftz.ceiba.java.learn.parking.domain.Vehicle;

/**
 * Test Data Builder Pattern for Vehicle domain object.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.04/2017
 * @since 1.8 (JDK), Oct.04/2017
 */
public class VehicleDataBuilder {
	private Long id;
	private String plate;
	private int type;
	private int cylinder;

	/**
	 * Default constructor.
	 */
	public VehicleDataBuilder() {
		super();
		this.id = 0L;
		this.plate = "";
		this.type = 0;
		this.cylinder = 0;
	}

	/**
	 * Assign Id field to Vehicle
	 * 
	 * @param id
	 *            Identifier to the object
	 * @return A reference to itself.
	 */
	public VehicleDataBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Assign plate field to Vehicle
	 * 
	 * @param plate
	 *            Description of the Vehicle
	 * @return A reference to itself.
	 */
	public VehicleDataBuilder withPlate(String plate) {
		this.plate = plate;
		return this;
	}

	/**
	 * Assign type field to Vehicle
	 * 
	 * @param type
	 *            Holds 1:Car, 2:Motorcycle.
	 * @return A reference to itself.
	 */
	public VehicleDataBuilder withType(int type) {
		this.type = type;
		return this;
	}

	/**
	 * Assign cylinder to Vehicle
	 * 
	 * @param cylinder
	 *            It is -1 for car, otherwise it is for motorcycle.
	 * @return A reference to itself.
	 */
	public VehicleDataBuilder withCylinder(int cylinder) {
		this.cylinder = cylinder;
		return this;
	}

	/**
	 * Makes a representation of Vehicle to test.
	 * 
	 * @return Vehicle domain object.
	 */
	public Vehicle build() {
		return new Vehicle(this.id, this.plate, this.type, this.cylinder);
	}
}
