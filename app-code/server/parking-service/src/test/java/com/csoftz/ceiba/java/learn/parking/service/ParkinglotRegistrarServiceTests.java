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
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_INVALID_ARGUMENT;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_OK;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
	private static final String PLATE_STARTS_WITH_A = "ABC123";
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
	public void givenVehicleOtherCheckParkinglotCanReceiveReturnsFalse() {
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
	public void givenVehicleCarCheckParkinglotCanReceiveRetursTrue() {
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
	public void givenVehicleMotorCycleCheckParkinglotCanReceiveReturnsTrue() {
		// Arrange
		vehicle.setType(VEHICLE_TYPE_MOTORCYCLE);

		// Act
		boolean mayEnter = parkinglotRegistrarService.isValid(vehicle);

		// Assert
		assertThat(mayEnter).isTrue();
	}

	/**
	 * When a vehicle's plate start with "A" but day of week is not Sunday or
	 * Monday, then it is allowed to enter.
	 */
	@Test
	public void givenVehicleWithPlateStartingWithAAndDateIsNotSundayOrMondayThenAllowedToEnterReturnsTrue() {
		// Arrange
		LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(2017, 10, 06), LocalTime.MIN);
		vehicle.setPlate(PLATE_STARTS_WITH_A);

		// Act
		boolean isValidPlate = parkinglotRegistrarService.isValidPlate(vehicle, localDateTime);

		// Assert
		assertThat(isValidPlate).isTrue();
	}

	/**
	 * When a vehicle's plate start with "A" and day of week is Sunday, then it is
	 * not allowed to enter.
	 */
	@Test
	public void givenVehicleWithPlateStartingWithAAndDateIsSundayThenNotAllowdToEnterReturnsFalse() {
		// Arrange
		// Oct.01/2017 is SUNDAY
		LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(2017, 10, 01), LocalTime.MIN);
		vehicle.setPlate(PLATE_STARTS_WITH_A);

		// Act
		boolean isValidPlate = parkinglotRegistrarService.isValidPlate(vehicle, localDateTime);

		// Assert
		assertThat(isValidPlate).isFalse();
	}

	/**
	 * When a vehicle's plate start with "A" and day of week is Monday, then it is
	 * not allowed to enter.
	 */
	@Test
	public void givenVehicleWithPlateStartingWithAAndDateIsMondayThenNotAllowdToEnterReturnsFalse() {
		// Arrange
		// Oct.01/2017 is MONDAY
		LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(2017, 10, 02), LocalTime.MIN);
		vehicle.setPlate(PLATE_STARTS_WITH_A);

		// Act
		boolean isValidPlate = parkinglotRegistrarService.isValidPlate(vehicle, localDateTime);

		// Assert
		assertThat(isValidPlate).isFalse();
	}

	/**
	 * Both isValidPlate parameters are null then return false.
	 */
	@Test
	public void givenVehicleAsNullAndDateTimeAsNullCheckIsNotValidPlateReturnsFalse() {
		// Arrange
		vehicle = null;
		LocalDateTime localDateTime = null;

		// Act
		boolean isValidPlate = parkinglotRegistrarService.isValidPlate(vehicle, localDateTime);

		// Assert
		assertThat(isValidPlate).isFalse();
	}

	/**
	 * Only one parameter for isValidPlate is null, returns false.
	 */
	@Test
	public void givenVehicleAsNullAndDateTimeAsNotNullCheckIsNotValidPlateReturnsFalse() {
		// Arrange
		vehicle = null;
		LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(2017, 10, 01), LocalTime.MIN);

		// Act
		boolean isValidPlate = parkinglotRegistrarService.isValidPlate(vehicle, localDateTime);

		// Assert
		assertThat(isValidPlate).isFalse();
	}

	/**
	 * Given vehicle parameter as not null and localDateTime parameter as null and
	 * when isValidPlate is called then it returns false.
	 */
	@Test
	public void givenVehicleAndLocalDateTimeIsNullCheckIsValidPlateReturnsFalse() {
		// Arrange
		LocalDateTime localDateTime = null;

		// Act
		boolean isValidPlate = parkinglotRegistrarService.isValidPlate(vehicle, localDateTime);

		// Assert
		assertThat(isValidPlate).isFalse();
	}

	/**
	 * If Plate does not start with an "A" it is considered a valid plate and local
	 * date time is not used.
	 */
	@Test
	public void givenVehiclePlateNotStartingWithAAnyDayCanEnterReturnsTrue() {
		// Arrange
		LocalDateTime localDateTime = LocalDateTime.of(LocalDate.of(2017, 10, 01), LocalTime.MIN);

		// Act
		boolean isValidPlate = parkinglotRegistrarService.isValidPlate(vehicle, localDateTime);

		// Assert
		assertThat(isValidPlate).isTrue();
	}

	/**
	 * Check for invalid parameter when calling register method.
	 */
	@Test
	public void givenVehicleAsNullRegisterReturnsCodeInvalidArgument() {
		// Arrange
		vehicle = null;

		// Act
		int value = parkinglotRegistrarService.register(vehicle);

		// Assert
		assertThat(value).isEqualTo(PARKING_LOT_REGISTRAR_INVALID_ARGUMENT);
	}

	/**
	 * Given Vehicle a successful registration is done.
	 */
	@Test
	public void givenVehicleRegisterReturnsCodeOK() {
		// Arrange
		// Act
		int value = parkinglotRegistrarService.register(vehicle);

		// Assert
		assertThat(value).isEqualTo(PARKING_LOT_REGISTRAR_OK);
	}

}