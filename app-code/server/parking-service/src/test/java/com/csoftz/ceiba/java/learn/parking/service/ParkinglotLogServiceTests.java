/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTLOGSERVICETESTS.JAVA                              */
/* Description:   Tests for the Parkinglot Log service.                       */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.06/2017                                                 */
/* Last Modified: Oct.10/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.06/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.ceiba.java.learn.parking.service;

import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_TYPE_CAR;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotLog;
import com.csoftz.ceiba.java.learn.parking.domain.Vehicle;
import com.csoftz.ceiba.java.learn.parking.service.entities.ParkinglotLogEntity;
import com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotLogService;
import com.csoftz.ceiba.java.learn.parking.service.mapper.ParkinglotLogMapper;
import com.csoftz.ceiba.java.learn.parking.service.repository.interfaces.IParkinglotLogRepository;
import com.csoftz.ceiba.java.learn.parking.service.test.domain.data.builder.ParkinglotLogDataBuilder;
import com.csoftz.ceiba.java.learn.parking.service.test.domain.data.builder.VehicleDataBuilder;

/**
 * Tests for the Parkinglot Log service.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.06/2017
 * @since 1.8 (JDK), Oct.10/2017
 */
public class ParkinglotLogServiceTests {
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
	private ParkinglotLog parkinglotLog;
	private ParkinglotLogEntity parkinglotLogEntity;
	private static IParkinglotLogRepository parkinglotLogRepository;
	private static IParkinglotLogService parkinglotLogService;
	private static ParkinglotLogMapper parkinglotLogMapper;

	/**
	 * Prepare helpers.
	 */
	@BeforeClass
	public static void init() {
		parkinglotLogMapper = new ParkinglotLogMapper();
		parkinglotLogRepository = mock(IParkinglotLogRepository.class);
		parkinglotLogService = new ParkinglotLogService(parkinglotLogRepository, parkinglotLogMapper);
	}

	/**
	 * Prepare data for each test.
	 */
	@Before
	public void setup() {
		reset(parkinglotLogRepository);
		vehicle = new VehicleDataBuilder().withId(ID).withPlate(PLATE).withType(VEHICLE_TYPE).withCylinder(CYLINDER)
				.build();
		parkinglotLog = new ParkinglotLogDataBuilder().withPlate(PLATE).withVehicleType(VEHICLE_TYPE).build();
		parkinglotLogEntity = new ParkinglotLogEntity(0L, vehicle.getPlate(), vehicle.getType(), LocalDateTime.now(),
				null);
	}

	/**
	 * If parameter to save is set to NULL then NULL is returned.
	 */
	@Test
	public void givenVehicleNullSaveReturnNull() {
		// Arrange
		vehicle = null;
		when(parkinglotLogRepository.save(any(ParkinglotLogEntity.class))).thenReturn(null);

		// Act
		ParkinglotLog parkinglotLog = parkinglotLogService.save(vehicle);

		// Assert
		assertThat(parkinglotLog).isNull();

		// Here parkinglotLogRepository is not invoked.
		verify(parkinglotLogRepository, times(0)).save(any(ParkinglotLogEntity.class));
		verifyNoMoreInteractions(parkinglotLogRepository);
	}

	/**
	 * If parameter to save is not NULL then return saved ParkinglotLog domain
	 * object.
	 */
	@Test
	public void givenVehicleNotNullSaveReturnsSavedObjectRef() {
		// Arrange
		when(parkinglotLogRepository.save(any(ParkinglotLogEntity.class))).thenReturn(parkinglotLogEntity);

		// Act
		ParkinglotLog parkinglotLog = parkinglotLogService.save(vehicle);

		// Assert
		assertThat(parkinglotLog).isNotNull();
		verify(parkinglotLogRepository, times(1)).save(any(ParkinglotLogEntity.class));
		verifyNoMoreInteractions(parkinglotLogRepository);
	}
}