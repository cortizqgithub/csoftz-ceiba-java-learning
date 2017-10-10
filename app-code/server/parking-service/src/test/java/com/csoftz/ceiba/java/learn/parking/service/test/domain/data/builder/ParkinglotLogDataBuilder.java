/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTLOGDATABUILDER.JAVA                               */
/* Description:   Test Data Builder Pattern for ParkinglotLog domain object.  */
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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotLog;

/**
 * Test Data Builder Pattern for ParkinglotLog domain object.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.10/2017
 * @since 1.8 (JDK), Oct.04/2017
 */
public class ParkinglotLogDataBuilder {
	private Long id;
	private String plate;
	private int vehicleType;
	private LocalDateTime admissionDate;
	private LocalDateTime departureDate;

	/**
	 * Default constructor.
	 */
	public ParkinglotLogDataBuilder() {
		super();
		this.id = 0L;
		this.plate = "";
		this.vehicleType = 0;
		this.admissionDate = LocalDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIN);
		this.departureDate = LocalDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIN);
	}

	/**
	 * Assign id field to ParkinglotLog
	 * 
	 * @param id
	 *            Identification of object
	 * @return A reference to itself.
	 */
	public ParkinglotLogDataBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Assign plate field to ParkinglotLog
	 * 
	 * @param plate
	 *            Description of the Vehicle
	 * @return A reference to itself.
	 */
	public ParkinglotLogDataBuilder withPlate(String plate) {
		this.plate = plate;
		return this;
	}

	/**
	 * Assign vehicleType field to ParkinglotLog
	 * 
	 * @param vehicleType
	 *            Holds 1:Car, 2:Motorcycle.
	 * @return A reference to itself.
	 */
	public ParkinglotLogDataBuilder withVehicleType(int vehicleType) {
		this.vehicleType = vehicleType;
		return this;
	}

	/**
	 * Assign admissionDate field to ParkinglotLog
	 * 
	 * @param admissionDate
	 *            Date/Time when vehicle entered the Parkinglot.
	 * @return A reference to itself.
	 */
	public ParkinglotLogDataBuilder withAdmissionDate(LocalDateTime admissionDate) {
		this.admissionDate = admissionDate;
		return this;
	}

	/**
	 * Assign departureDate field to ParkinglotLog
	 * 
	 * @param departureDate
	 *            Date/Time when vehicle left the Parkinglot.
	 * @return A reference to itself.
	 */
	public ParkinglotLogDataBuilder withDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
		return this;
	}

	/**
	 * Makes a representation of ParkinglotLog to test.
	 * 
	 * @return ParkinglotLog domain object.
	 */
	public ParkinglotLog build() {
		return new ParkinglotLog(this.id, this.plate, this.vehicleType, this.admissionDate, this.departureDate);
	}
}
