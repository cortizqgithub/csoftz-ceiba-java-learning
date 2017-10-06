/*----------------------------------------------------------------------------*/
/* Source File:   VEHICLEENTITYDATABUILDER.JAVA                               */
/* Description:   Test Data Builder Pattern for VehicleEntity entity object.  */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.04/2017                                                 */
/* Last Modified: Oct.05/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.04/2017 COQ  File created.
 -----------------------------------------------------------------------------*/

package com.csoftz.ceiba.java.learn.parking.service.test.entities.data.builder;

import com.csoftz.ceiba.java.learn.parking.service.entities.VehicleEntity;

/**
 * Test Data Builder Pattern for VehicleEntity entity object.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.04/2017
 * @since 1.8 (JDK), Oct.05/2017
 */
public class VehicleEntityDataBuilder {
	private Long id;
	private String plate;
	private int type;
	private int cylinder;

	/**
	 * Default constructor
	 */
	public VehicleEntityDataBuilder() {
		super();
		this.id = 0L;
		this.plate = "";
		this.type = 0;
		this.cylinder = 0;
	}

	/**
	 * Assign Id field to VehicleEntity
	 * 
	 * @param id
	 *            Identifier to the object
	 * @return A reference to itself.
	 */
	public VehicleEntityDataBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Assign plate field to VehicleEntity
	 * 
	 * @param plate
	 *            Description of the VehicleEntity
	 * @return A reference to itself.
	 */
	public VehicleEntityDataBuilder withPlate(String plate) {
		this.plate = plate;
		return this;
	}

	/**
	 * Assign type field to VehicleEntity
	 * 
	 * @param type
	 *            Holds 1:Car, 2:Motorcycle.
	 * @return A reference to itself.
	 */
	public VehicleEntityDataBuilder withType(int type) {
		this.type = type;
		return this;
	}

	/**
	 * Assign cylinder to VehicleEntity
	 * 
	 * @param cylinder
	 *            It is -1 for car, otherwise it is for motorcycle.
	 * @return A reference to itself.
	 */
	public VehicleEntityDataBuilder withCylinder(int cylinder) {
		this.cylinder = cylinder;
		return this;
	}

	/**
	 * Makes a representation of VehicleEntity to test.
	 * 
	 * @return Vehicle domain object.
	 */
	public VehicleEntity build() {
		return new VehicleEntity(this.id, this.plate, this.type, this.cylinder);
	}
}
