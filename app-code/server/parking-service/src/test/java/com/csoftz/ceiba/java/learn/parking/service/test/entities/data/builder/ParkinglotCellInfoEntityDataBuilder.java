/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTCELLINFOENTITYDATABUILDER.JAVA                    */
/* Description:   Test Data Builder Pattern for ParkinglotCellInfoEntity      */
/*                entity object.                                              */
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

package com.csoftz.ceiba.java.learn.parking.service.test.entities.data.builder;

import com.csoftz.ceiba.java.learn.parking.service.entities.ParkinglotCellInfoEntity;

/**
 * Test Data Builder Pattern for ParkinglotCellInfoEntity entity object.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.04/2017
 * @since 1.8 (JDK), Oct.10/2017
 */
public class ParkinglotCellInfoEntityDataBuilder {
	private String plate;
	private int vehicleType;

	/**
	 * Default constructor.
	 */
	public ParkinglotCellInfoEntityDataBuilder() {
		this.plate = "";
		this.vehicleType = 0;
	}

	/**
	 * Assign plate field to ParkinglotCellInfoEntity
	 * 
	 * @param plate
	 *            Description of the Vehicle.
	 * @return A reference to itself.
	 */
	public ParkinglotCellInfoEntityDataBuilder withPlate(String plate) {
		this.plate = plate;
		return this;
	}

	/**
	 * Assign vehicleType field to ParkinglotCellInfoEntity
	 * 
	 * @param vehicleType
	 *            Holds 1:Car, 2:Motorcycle.
	 * @return A reference to itself.
	 */
	public ParkinglotCellInfoEntityDataBuilder withVehicleType(int vehicleType) {
		this.vehicleType = vehicleType;
		return this;
	}

	/**
	 * Makes a representation of ParkinglotCellInfoEntity to test.
	 * 
	 * @return ParkinglotCellInfo domain object.
	 */
	public ParkinglotCellInfoEntity build() {
		return new ParkinglotCellInfoEntity(this.plate, this.vehicleType);
	}

}
