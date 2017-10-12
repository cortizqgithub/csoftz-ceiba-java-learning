/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTCELLINFOSERVICETESTS.JAVA                         */
/* Description:   Test suite for Parking lot Cell Info Service.               */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.09/2017                                                 */
/* Last Modified: Oct.12/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.09/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.ceiba.java.learn.parking.service.test;

import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_CAR_CAPACITY;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_MOTORCYCLE_CAPACITY;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_TYPE_CAR;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_TYPE_MOTORCYCLE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotCellInfo;
import com.csoftz.ceiba.java.learn.parking.service.ParkinglotCellInfoService;
import com.csoftz.ceiba.java.learn.parking.service.entities.ParkinglotCellInfoEntity;
import com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotCellInfoService;
import com.csoftz.ceiba.java.learn.parking.service.mapper.ParkinglotCellInfoMapper;
import com.csoftz.ceiba.java.learn.parking.service.repository.interfaces.IParkinglotCellInfoRepository;
import com.csoftz.ceiba.java.learn.parking.service.test.domain.data.builder.ParkinglotCellInfoDataBuilder;

/**
 * Implements Parking lot Cell Info service contract for accessing
 * ParkinglotCellInfo domain objects.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.12/2017
 * @since 1.8 (JDK), Oct.09/2017
 */
public class ParkinglotCellInfoServiceTests {
	/*
	 * Test data constants.
	 */
	private static final String PLATE = "KDF123";
	private static final int VEHICLE_TYPE = VEHICLE_TYPE_CAR;

	/*
	 * Test working data.
	 */
	private ParkinglotCellInfo parkinglotCellInfoTest;
	private static IParkinglotCellInfoRepository parkinglotCellInfoRepository;
	private static IParkinglotCellInfoService parkinglotCellInfoService;
	private static ParkinglotCellInfoMapper parkinglotCellInfoMapper;

	/**
	 * Prepare helpers.
	 */
	@BeforeClass
	public static void init() {
		parkinglotCellInfoMapper = new ParkinglotCellInfoMapper();
		parkinglotCellInfoRepository = mock(IParkinglotCellInfoRepository.class);
		parkinglotCellInfoService = new ParkinglotCellInfoService(parkinglotCellInfoRepository,
				parkinglotCellInfoMapper);
	}

	/**
	 * Prepare data for each test.
	 */
	@Before
	public void setup() {
		reset(parkinglotCellInfoRepository);
		parkinglotCellInfoTest = new ParkinglotCellInfoDataBuilder().withPlate(PLATE).withVehicleType(VEHICLE_TYPE)
				.build();
	}

	/**
	 * When we try to find a vehicle with plate and vehicle type (1:Car,
	 * 2:MotorCycle), test when not found returns Cell object as null.
	 */
	@Test
	public void givenPlateAndVehicleTypeFindIfInCellReturnsNotFoundNull() {
		// Arrange
		when(parkinglotCellInfoRepository.findByPlateAndVehicleType(PLATE, VEHICLE_TYPE)).thenReturn(null);

		// Act
		ParkinglotCellInfo parkinglotCellInfo = parkinglotCellInfoService.find(PLATE, VEHICLE_TYPE);

		// Assert
		assertThat(parkinglotCellInfo).isNull();
		verify(parkinglotCellInfoRepository, times(1)).findByPlateAndVehicleType(PLATE, VEHICLE_TYPE);
		verifyNoMoreInteractions(parkinglotCellInfoRepository);
	}

	/**
	 * When we try to find a vehicle with plate and vehicle type (1:Car,
	 * 2:MotorCycle), test when found returns Cell object as not null.
	 */
	@Test
	public void givenPlateAndVehicleTypeFindIfInCellReturnsFoundNotNull() {
		// Arrange
		ParkinglotCellInfoEntity parkinglotCellInfoEntityTest = parkinglotCellInfoMapper
				.parkinglotCellInfoToParkinglotCellInfoEntity(parkinglotCellInfoTest);
		when(parkinglotCellInfoRepository.findByPlateAndVehicleType(PLATE, VEHICLE_TYPE))
				.thenReturn(parkinglotCellInfoEntityTest);

		// Act
		ParkinglotCellInfo parkinglotCellInfo = parkinglotCellInfoService.find(PLATE, VEHICLE_TYPE);

		// Assert
		assertThat(parkinglotCellInfo).isNotNull();
		verify(parkinglotCellInfoRepository, times(1)).findByPlateAndVehicleType(PLATE, VEHICLE_TYPE);
		verifyNoMoreInteractions(parkinglotCellInfoRepository);
	}

	/**
	 * Check for not full Car capacity.
	 */
	@Test
	public void givenVehicleTypeCarAndTakeCapacityForReturnsLessThanCarCapacity() {
		// Arrange
		when(parkinglotCellInfoRepository.countByVehicleType(VEHICLE_TYPE)).thenReturn(0);

		// Act
		int capacity = parkinglotCellInfoService.takeCapacityFor(VEHICLE_TYPE);

		// Assert
		assertThat(capacity).isEqualTo(0);
		verify(parkinglotCellInfoRepository, times(1)).countByVehicleType(VEHICLE_TYPE);
		verifyNoMoreInteractions(parkinglotCellInfoRepository);
	}

	/**
	 * Check for full Car capacity.
	 */
	@Test
	public void givenVehicleTypeCarAndTakeCapacityForReturnsFullCarCapacity() {
		// Arrange
		when(parkinglotCellInfoRepository.countByVehicleType(VEHICLE_TYPE)).thenReturn(VEHICLE_CAR_CAPACITY);

		// Act
		int capacity = parkinglotCellInfoService.takeCapacityFor(VEHICLE_TYPE);

		// Assert
		assertThat(capacity).isEqualTo(VEHICLE_CAR_CAPACITY);
		verify(parkinglotCellInfoRepository, times(1)).countByVehicleType(VEHICLE_TYPE);
		verifyNoMoreInteractions(parkinglotCellInfoRepository);
	}

	/**
	 * Check for not full Motorcycle capacity
	 */
	@Test
	public void givenVehicleTypeMotorycycleAndTakeCapacityForReturnsLessThanMotorycycleCapacity() {
		// Arrange
		when(parkinglotCellInfoRepository.countByVehicleType(VEHICLE_TYPE_MOTORCYCLE)).thenReturn(0);

		// Act
		int capacity = parkinglotCellInfoService.takeCapacityFor(VEHICLE_TYPE_MOTORCYCLE);

		// Assert
		assertThat(capacity).isEqualTo(0);
		verify(parkinglotCellInfoRepository, times(1)).countByVehicleType(VEHICLE_TYPE_MOTORCYCLE);
		verifyNoMoreInteractions(parkinglotCellInfoRepository);
	}

	/**
	 * Check for full Motorcycle capacity.
	 */
	@Test
	public void givenVehicleTypeMotorycycleAndTakeCapacityForReturnsFullMotorycycleCapacity() {
		// Arrange
		when(parkinglotCellInfoRepository.countByVehicleType(VEHICLE_TYPE_MOTORCYCLE))
				.thenReturn(VEHICLE_MOTORCYCLE_CAPACITY);

		// Act
		int capacity = parkinglotCellInfoService.takeCapacityFor(VEHICLE_TYPE_MOTORCYCLE);

		// Assert
		assertThat(capacity).isEqualTo(VEHICLE_MOTORCYCLE_CAPACITY);
		verify(parkinglotCellInfoRepository, times(1)).countByVehicleType(VEHICLE_TYPE_MOTORCYCLE);
		verifyNoMoreInteractions(parkinglotCellInfoRepository);
	}

	/**
	 * When trying to assign a cell for a parking lot and some error occurs, it is
	 * expected a NULL indicating this situation.
	 */
	@Test
	public void givenPlateAndVehicleTypeThenAssignCellReturnsNull() {
		// Arrange
		when(parkinglotCellInfoRepository.save(any(ParkinglotCellInfoEntity.class))).thenReturn(null);

		// Act
		ParkinglotCellInfo parkingCellInfo = parkinglotCellInfoService.assign(PLATE, VEHICLE_TYPE);

		// Assert
		assertThat(parkingCellInfo).isNull();
		verify(parkinglotCellInfoRepository, times(1)).save(any(ParkinglotCellInfoEntity.class));
		verifyNoMoreInteractions(parkinglotCellInfoRepository);
	}

	/**
	 * When trying to assign a cell for a parking lot returns the newly created
	 * object indicating a successful operation.
	 */
	@Test
	public void givenPlateAndVehicleTypeThenAssignCellReturnsNotNull() {
		// Arrange
		ParkinglotCellInfoEntity parkinglotCellInfoEntity = new ParkinglotCellInfoEntity(PLATE, VEHICLE_TYPE);
		when(parkinglotCellInfoRepository.save(any(ParkinglotCellInfoEntity.class)))
				.thenReturn(parkinglotCellInfoEntity);

		// Act
		ParkinglotCellInfo parkingCellInfo = parkinglotCellInfoService.assign(PLATE, VEHICLE_TYPE);

		// Assert
		assertThat(parkingCellInfo).isNotNull();
		verify(parkinglotCellInfoRepository, times(1)).save(any(ParkinglotCellInfoEntity.class));
		verifyNoMoreInteractions(parkinglotCellInfoRepository);
	}
}