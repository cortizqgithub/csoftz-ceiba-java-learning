/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTCELLINFODATABUILDER.JAVA                          */
/* Description:   Test Data Builder Pattern for ParkinglotCellInfo domain     */
/*                object.                                                     */
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

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotCellInfo;

/**
 * Test Data Builder Pattern for ParkinglotCellInfo domain object.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.04/2017
 * @since 1.8 (JDK), Oct.04/2017
 */
public class ParkinglotCellInfoDataBuilder {
	private String plate;
	private int vehicleType;

	/**
	 * Default constructor.
	 */
	public ParkinglotCellInfoDataBuilder() {
		this.plate = "";
		this.vehicleType = 0;
	}

	/**
	 * Assign plate field to ParkinglotCellInfo
	 * 
	 * @param plate
	 *            Description of the Vehicle.
	 * @return A reference to itself.
	 */
	public ParkinglotCellInfoDataBuilder withPlate(String plate) {
		this.plate = plate;
		return this;
	}

	/**
	 * Assign vehicleType field to ParkinglotCellInfo
	 * 
	 * @param vehicleType
	 *            Holds 1:Car, 2:Motorcycle.
	 * @return A reference to itself.
	 */
	public ParkinglotCellInfoDataBuilder withVehicleType(int vehicleType) {
		this.vehicleType = vehicleType;
		return this;
	}

	/**
	 * Makes a representation of ParkinglotCellInfo to test.
	 * 
	 * @return ParkinglotCellInfo domain object.
	 */
	public ParkinglotCellInfo build() {
		return new ParkinglotCellInfo(this.plate, this.vehicleType);
	}

}
