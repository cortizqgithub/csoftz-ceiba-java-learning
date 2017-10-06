/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTREGISTRARSERVICETESTS.JAVA                        */
/* Description:   Test for the Registrar Service.                             */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.06/2017                                                 */
/* Last Modified: Oct.06/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.06/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.ceiba.java.learn.parking.service;

import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_TYPE_CAR;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_TYPE_MOTORCYCLE;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_TYPE_OTHER;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.csoftz.ceiba.java.learn.parking.domain.Vehicle;
import com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotRegistrarService;
import com.csoftz.ceiba.java.learn.parking.service.test.domain.data.builder.VehicleDataBuilder;

/**
 * Test for the Registrar Service.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.06/2017
 * @since 1.8 (JDK), Oct.06/2017
 */
public class ParkinglotRegistrarServiceTests {
	/*
	 * Test data constants.
	 */
	private static final Long ID = 1L;
	private static final String PLATE = "KDF123";
	private static final int VEHICLE_TYPE = VEHICLE_TYPE_CAR;
	private static final int CYLINDER = 120;

	/*
	 * Test working data.
	 */
	private Vehicle vehicle;
	private static IParkinglotRegistrarService parkinglotRegistrarService;

	/**
	 * Prepare helpers.
	 */
	@BeforeClass
	public static void init() {
		parkinglotRegistrarService = new ParkinglotRegistrarService();
	}

	/**
	 * Prepare data for each test.
	 */
	@Before
	public void setup() {
		vehicle = new VehicleDataBuilder().withId(ID).withPlate(PLATE).withType(VEHICLE_TYPE).withCylinder(CYLINDER)
				.build();
	}

	@Test
	public void givenVehicleIsNullReturnsFalse() {
		// Arrange
		Vehicle vh = null;

		// Act
		boolean mayEnter = parkinglotRegistrarService.isValid(vh);

		// Assert
		assertThat(mayEnter).isFalse();
	}

	/**
	 * Assume the vehicle object is neither a car nor a motorcycle, then it is not
	 * allowed to enter the parking lot.
	 */
	@Test
	public void givenVehicleOtherCheckParkinglotCanReceive() {
		// Arrange
		vehicle.setType(VEHICLE_TYPE_OTHER);

		// Act
		boolean mayEnter = parkinglotRegistrarService.isValid(vehicle);

		// Assert
		assertThat(mayEnter).isFalse();
	}

	/**
	 * Vehicle is a car. It may enter the parking lot.
	 */
	@Test
	public void givenVehicleCarCheckParkinglotCanReceive() {
		// Arrange
		vehicle.setType(VEHICLE_TYPE_CAR);

		// Act
		boolean mayEnter = parkinglotRegistrarService.isValid(vehicle);

		// Assert
		assertThat(mayEnter).isTrue();
	}

	/**
	 * Vehicle is a car. It may enter the parking lot.
	 */
	@Test
	public void givenVehicleMotorCycleCheckParkinglotCanReceive() {
		// Arrange
		vehicle.setType(VEHICLE_TYPE_MOTORCYCLE);

		// Act
		boolean mayEnter = parkinglotRegistrarService.isValid(vehicle);

		// Assert
		assertThat(mayEnter).isTrue();
	}

}