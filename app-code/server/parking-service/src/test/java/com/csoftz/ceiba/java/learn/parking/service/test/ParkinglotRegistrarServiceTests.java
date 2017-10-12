/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTREGISTRARSERVICETESTS.JAVA                        */
/* Description:   Test for the Registrar Service.                             */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.06/2017                                                 */
/* Last Modified: Oct.12/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.06/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.ceiba.java.learn.parking.service.test;

import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_CAR_CAPACITY;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_MOTORCYCLE_CAPACITY;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_TYPE_CAR;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_TYPE_MOTORCYCLE;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_TYPE_OTHER;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_INVALID_ARGUMENT;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_OK;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_ALREADY_IN_CELL;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_CAR_CAPACITY_FULL;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_CELL_NOT_ASSIGNED;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_LOG_FAILURE;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_MOTORCYCLE_CAPACITY_FULL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotCellInfo;
import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotLog;
import com.csoftz.ceiba.java.learn.parking.domain.Vehicle;
import com.csoftz.ceiba.java.learn.parking.service.ParkinglotRegistrarService;
import com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotCellInfoService;
import com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotLogService;
import com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotRegistrarService;
import com.csoftz.ceiba.java.learn.parking.service.test.domain.data.builder.ParkinglotCellInfoDataBuilder;
import com.csoftz.ceiba.java.learn.parking.service.test.domain.data.builder.ParkinglotLogDataBuilder;
import com.csoftz.ceiba.java.learn.parking.service.test.domain.data.builder.VehicleDataBuilder;

/**
 * Test for the Registrar Service.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.12/2017
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
	private static IParkinglotCellInfoService parkingCellInfoService;
	private static IParkinglotLogService parkinglotLogService;

	/**
	 * Prepare helpers.
	 */
	@BeforeClass
	public static void init() {
		parkingCellInfoService = mock(IParkinglotCellInfoService.class);
		parkinglotLogService = mock(IParkinglotLogService.class);
		parkinglotRegistrarService = new ParkinglotRegistrarService(parkingCellInfoService, parkinglotLogService);
	}

	/**
	 * Prepare data for each test.
	 */
	@Before
	public void setup() {
		reset(parkingCellInfoService);
		reset(parkinglotLogService);
		vehicle = new VehicleDataBuilder().withId(ID).withPlate(PLATE).withType(VEHICLE_TYPE).withCylinder(CYLINDER)
				.build();
	}

	/**
	 * If Vehicle object to validate is NULL then returns false.
	 */
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
	public void givenVehicleAsNullRegisterReturnsOpCodeInvalidArgument() {
		// Arrange
		vehicle = null;

		// Act
		int value = parkinglotRegistrarService.register(vehicle);

		// Assert
		assertThat(value).isEqualTo(PARKING_LOT_REGISTRAR_INVALID_ARGUMENT);
	}

	/**
	 * Given a vehicle in parking lot cell,return a constant indicating that Vehicle
	 * is already in cell.
	 */
	@Test
	public void givenVehicleExistInParkinLotReturnsOpCodeVehicleAlreadyInCell() {
		// Arrange
		ParkinglotCellInfo parkinglotCellInfoCarTest = new ParkinglotCellInfoDataBuilder().withPlate(PLATE)
				.withVehicleType(VEHICLE_TYPE_CAR).build();
		Vehicle vehicleTest = new VehicleDataBuilder().withId(ID).withPlate(PLATE).withType(VEHICLE_TYPE)
				.withCylinder(CYLINDER).build();
		when(parkingCellInfoService.find(vehicleTest.getPlate(), vehicleTest.getType()))
				.thenReturn(parkinglotCellInfoCarTest);

		// Act
		int value = parkinglotRegistrarService.register(vehicleTest);

		// Assert
		assertThat(value).isEqualTo(PARKING_LOT_REGISTRAR_VEHICLE_ALREADY_IN_CELL);
		verify(parkingCellInfoService, times(1)).find(vehicleTest.getPlate(), vehicleTest.getType());
		verifyNoMoreInteractions(parkingCellInfoService);
	}

	/**
	 * When a car tries to enter the parking lot it is rejected because Parking Lot
	 * capacity for cars is full.
	 */
	@Test
	public void givenVehicleIsCarAndCapacityIsFullThenReturnOpCodeVehicleCarCapacityFull() {
		// Arrange

		// vehicle
		when(parkingCellInfoService.find(vehicle.getPlate(), vehicle.getType())).thenReturn(null);
		when(parkingCellInfoService.takeCapacityFor(VEHICLE_TYPE_CAR)).thenReturn(VEHICLE_CAR_CAPACITY);

		// Act
		int value = parkinglotRegistrarService.register(vehicle);

		// Assert
		assertThat(value).isEqualTo(PARKING_LOT_REGISTRAR_VEHICLE_CAR_CAPACITY_FULL);
		verify(parkingCellInfoService, times(1)).find(vehicle.getPlate(), vehicle.getType());
		verify(parkingCellInfoService, times(1)).takeCapacityFor(VEHICLE_TYPE_CAR);
		verifyNoMoreInteractions(parkingCellInfoService);
	}

	/**
	 * When a motorcycle tries to enter the parking lot it is rejected because
	 * Parking Lot capacity for motorcycle is full.
	 */
	@Test
	public void givenVehicleIsMotoryCycleAndCapacityIsFullThenReturnOpCodeVehicleMotorCycleCapacityFull() {
		// Arrange
		vehicle.setType(VEHICLE_TYPE_MOTORCYCLE);

		// vehicle
		when(parkingCellInfoService.find(vehicle.getPlate(), vehicle.getType())).thenReturn(null);
		when(parkingCellInfoService.takeCapacityFor(VEHICLE_TYPE_MOTORCYCLE)).thenReturn(VEHICLE_MOTORCYCLE_CAPACITY);

		// Act
		int value = parkinglotRegistrarService.register(vehicle);

		// Assert
		assertThat(value).isEqualTo(PARKING_LOT_REGISTRAR_VEHICLE_MOTORCYCLE_CAPACITY_FULL);
		verify(parkingCellInfoService, times(1)).find(vehicle.getPlate(), vehicle.getType());
		verify(parkingCellInfoService, times(1)).takeCapacityFor(VEHICLE_TYPE_MOTORCYCLE);
		verifyNoMoreInteractions(parkingCellInfoService);
	}

	// ICI

	/**
	 * Given a CAR may enter parking lot but cell assignment fails then returns a
	 * cell not assigned op code.
	 */
	@Test
	public void givenVehicleCarMayEnterAndCannnotAssignCellReturnsOpCodeVehicleCellNotAssigned() {
		// Arrange
		when(parkingCellInfoService.find(vehicle.getPlate(), vehicle.getType())).thenReturn(null);
		when(parkingCellInfoService.takeCapacityFor(VEHICLE_TYPE_CAR)).thenReturn(VEHICLE_CAR_CAPACITY - 2);
		when(parkingCellInfoService.assign(vehicle.getPlate(), vehicle.getType())).thenReturn(null);

		// Act
		int value = parkinglotRegistrarService.register(vehicle);

		// Assert
		assertThat(value).isEqualTo(PARKING_LOT_REGISTRAR_VEHICLE_CELL_NOT_ASSIGNED);
		verify(parkingCellInfoService, times(1)).find(vehicle.getPlate(), vehicle.getType());
		verify(parkingCellInfoService, times(1)).takeCapacityFor(VEHICLE_TYPE_CAR);
		verify(parkingCellInfoService, times(1)).assign(vehicle.getPlate(), vehicle.getType());
		verifyNoMoreInteractions(parkingCellInfoService);
	}

	/**
	 * Given a MOTORCYCLE may enter parking lot but cell assignment fails then
	 * returns a cell not assigned op code.
	 */
	@Test
	public void givenVehicleMotorCycleMayEnterAndCannotAssignCellReturnsOpCodeVehicleCellNotAssigned() {
		// Arrange
		vehicle.setType(VEHICLE_TYPE_MOTORCYCLE);
		when(parkingCellInfoService.find(vehicle.getPlate(), vehicle.getType())).thenReturn(null);
		when(parkingCellInfoService.takeCapacityFor(VEHICLE_TYPE_MOTORCYCLE))
				.thenReturn(VEHICLE_MOTORCYCLE_CAPACITY - 2);
		when(parkingCellInfoService.assign(vehicle.getPlate(), vehicle.getType())).thenReturn(null);

		// Act
		int value = parkinglotRegistrarService.register(vehicle);

		// Assert
		assertThat(value).isEqualTo(PARKING_LOT_REGISTRAR_VEHICLE_CELL_NOT_ASSIGNED);
		verify(parkingCellInfoService, times(1)).find(vehicle.getPlate(), vehicle.getType());
		verify(parkingCellInfoService, times(1)).takeCapacityFor(VEHICLE_TYPE_MOTORCYCLE);
		verify(parkingCellInfoService, times(1)).assign(vehicle.getPlate(), vehicle.getType());
		verifyNoMoreInteractions(parkingCellInfoService);
	}

	/**
	 * Given a CAR may enter parking lot but Parking lot Log fails then returns a
	 * Log Failure op code.
	 */
	@Test
	public void givenVehicleCarMayEnterAndCannotCreateLogReturnsOpCodeLogFailure() {
		// Arrange
		ParkinglotCellInfo parkingCellInfo = new ParkinglotCellInfoDataBuilder().withPlate(vehicle.getPlate())
				.withVehicleType(vehicle.getType()).build();

		when(parkingCellInfoService.find(vehicle.getPlate(), vehicle.getType())).thenReturn(null);
		when(parkingCellInfoService.takeCapacityFor(VEHICLE_TYPE_CAR)).thenReturn(VEHICLE_CAR_CAPACITY - 2);
		when(parkingCellInfoService.assign(vehicle.getPlate(), vehicle.getType())).thenReturn(parkingCellInfo);
		when(parkinglotLogService.save(vehicle)).thenReturn(null);

		// Act
		int value = parkinglotRegistrarService.register(vehicle);

		// Assert
		assertThat(value).isEqualTo(PARKING_LOT_REGISTRAR_VEHICLE_LOG_FAILURE);
		verify(parkingCellInfoService, times(1)).find(vehicle.getPlate(), vehicle.getType());
		verify(parkingCellInfoService, times(1)).takeCapacityFor(VEHICLE_TYPE_CAR);
		verify(parkingCellInfoService, times(1)).assign(vehicle.getPlate(), vehicle.getType());
		verify(parkinglotLogService, times(1)).save(vehicle);
		verifyNoMoreInteractions(parkingCellInfoService);
		verifyNoMoreInteractions(parkinglotLogService);
	}

	/**
	 * Given a MOTORCYCLE may enter parking lot but Parking lot Log fails then
	 * returns a Log Failure op code.
	 */
	@Test
	public void givenVehicleMotorcycleMayEnterAndCannotCreateLogReturnsOpCodeLogFailure() {
		// Arrange
		vehicle.setType(VEHICLE_TYPE_MOTORCYCLE);
		ParkinglotCellInfo parkingCellInfo = new ParkinglotCellInfoDataBuilder().withPlate(vehicle.getPlate())
				.withVehicleType(vehicle.getType()).build();

		when(parkingCellInfoService.find(vehicle.getPlate(), vehicle.getType())).thenReturn(null);
		when(parkingCellInfoService.takeCapacityFor(VEHICLE_TYPE_MOTORCYCLE))
				.thenReturn(VEHICLE_MOTORCYCLE_CAPACITY - 2);
		when(parkingCellInfoService.assign(vehicle.getPlate(), vehicle.getType())).thenReturn(parkingCellInfo);
		when(parkinglotLogService.save(vehicle)).thenReturn(null);

		// Act
		int value = parkinglotRegistrarService.register(vehicle);

		// Assert
		assertThat(value).isEqualTo(PARKING_LOT_REGISTRAR_VEHICLE_LOG_FAILURE);
		verify(parkingCellInfoService, times(1)).find(vehicle.getPlate(), vehicle.getType());
		verify(parkingCellInfoService, times(1)).takeCapacityFor(VEHICLE_TYPE_MOTORCYCLE);
		verify(parkingCellInfoService, times(1)).assign(vehicle.getPlate(), vehicle.getType());
		verify(parkinglotLogService, times(1)).save(vehicle);
		verifyNoMoreInteractions(parkingCellInfoService);
		verifyNoMoreInteractions(parkinglotLogService);
	}

	/**
	 * Given a Car then a successful registration is done. <br>
	 * <b>NOTE:</b> This is all the happy scene for CAR registration.
	 */
	@Test
	public void givenVehicleCarRegisterReturnsOpCodeOK() {
		// Arrange
		ParkinglotCellInfo parkingCellInfo = new ParkinglotCellInfoDataBuilder().withPlate(vehicle.getPlate())
				.withVehicleType(vehicle.getType()).build();
		Vehicle vehicleTest = new VehicleDataBuilder().withId(ID).withPlate(PLATE).withType(VEHICLE_TYPE)
				.withCylinder(CYLINDER).build();
		ParkinglotLog parkinglotLog = new ParkinglotLogDataBuilder().withPlate(vehicle.getPlate())
				.withVehicleType(vehicle.getType()).withAdmissionDate(LocalDateTime.now()).build();
		when(parkingCellInfoService.find(vehicleTest.getPlate(), vehicleTest.getType())).thenReturn(null);
		when(parkingCellInfoService.takeCapacityFor(VEHICLE_TYPE_CAR)).thenReturn(VEHICLE_CAR_CAPACITY - 2);
		when(parkingCellInfoService.assign(vehicleTest.getPlate(), vehicleTest.getType())).thenReturn(parkingCellInfo);
		when(parkinglotLogService.save(vehicleTest)).thenReturn(parkinglotLog);

		// Act
		int value = parkinglotRegistrarService.register(vehicleTest);

		// Assert
		assertThat(value).isEqualTo(PARKING_LOT_REGISTRAR_OK);
		verify(parkingCellInfoService, times(1)).find(vehicleTest.getPlate(), vehicleTest.getType());
		verify(parkingCellInfoService, times(1)).takeCapacityFor(VEHICLE_TYPE_CAR);
		verify(parkingCellInfoService, times(1)).assign(vehicleTest.getPlate(), vehicleTest.getType());
		verify(parkinglotLogService, times(1)).save(vehicleTest);
		verifyNoMoreInteractions(parkingCellInfoService);
		verifyNoMoreInteractions(parkinglotLogService);
	}

	/**
	 * Given a Motorcycle then a successful registration is done. <br>
	 * <b>NOTE:</b> This is all the happy scene for CAR registration.
	 */
	@Test
	public void givenVehicleMotorcycleRegisterReturnsOpCodeOK() {
		// Arrange
		vehicle.setType(VEHICLE_TYPE_MOTORCYCLE);
		ParkinglotCellInfo parkingCellInfo = new ParkinglotCellInfoDataBuilder().withPlate(vehicle.getPlate())
				.withVehicleType(vehicle.getType()).build();
		ParkinglotLog parkinglotLog = new ParkinglotLogDataBuilder().withPlate(vehicle.getPlate())
				.withVehicleType(vehicle.getType()).withAdmissionDate(LocalDateTime.now()).build();

		// vehicle
		when(parkingCellInfoService.find(vehicle.getPlate(), vehicle.getType())).thenReturn(null);
		when(parkingCellInfoService.takeCapacityFor(VEHICLE_TYPE_MOTORCYCLE))
				.thenReturn(VEHICLE_MOTORCYCLE_CAPACITY - 2);
		when(parkingCellInfoService.assign(vehicle.getPlate(), vehicle.getType())).thenReturn(parkingCellInfo);
		when(parkinglotLogService.save(vehicle)).thenReturn(parkinglotLog);

		// Act
		int value = parkinglotRegistrarService.register(vehicle);

		// Assert
		assertThat(value).isEqualTo(PARKING_LOT_REGISTRAR_OK);
		verify(parkingCellInfoService, times(1)).find(vehicle.getPlate(), vehicle.getType());
		verify(parkingCellInfoService, times(1)).takeCapacityFor(VEHICLE_TYPE_MOTORCYCLE);
		verify(parkingCellInfoService, times(1)).assign(vehicle.getPlate(), vehicle.getType());
		verify(parkinglotLogService, times(1)).save(vehicle);
		verifyNoMoreInteractions(parkingCellInfoService);
		verifyNoMoreInteractions(parkinglotLogService);
	}
}