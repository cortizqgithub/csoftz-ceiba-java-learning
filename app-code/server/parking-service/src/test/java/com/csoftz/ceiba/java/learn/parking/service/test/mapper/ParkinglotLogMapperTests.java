/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTLOGMAPPERTESTS.JAVA                               */
/* Description:   Test suite for ParkinglotLogMapper.                         */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.05/2017                                                 */
/* Last Modified: Oct.12/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.05/2017 COQ  File created.
 -----------------------------------------------------------------------------*/

package com.csoftz.ceiba.java.learn.parking.service.test.mapper;

import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_TYPE_CAR;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotLog;
import com.csoftz.ceiba.java.learn.parking.service.entities.ParkinglotLogEntity;
import com.csoftz.ceiba.java.learn.parking.service.mapper.ParkinglotLogMapper;
import com.csoftz.ceiba.java.learn.parking.service.test.domain.data.builder.ParkinglotLogDataBuilder;
import com.csoftz.ceiba.java.learn.parking.service.test.entities.data.builder.ParkinglotLogEntityDataBuilder;

/**
 * Test suite for ParkinglotLogMapper.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.12/2017
 * @since 1.8 (JDK), Oct.05/2017
 */
public class ParkinglotLogMapperTests {
	private static final Long ID = 1L;
	private static final String PLATE = "KDF123";
	private static final int VEHICLE_TYPE = VEHICLE_TYPE_CAR;
	private static final LocalDateTime ADMISSION_DATE = LocalDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIN);
	private static final LocalDateTime DEPARTURE_DATE = LocalDateTime.of(LocalDate.of(1970, 1, 1), LocalTime.MIN);

	private static ParkinglotLogMapper parkinglotLogMapper;

	/**
	 * Prepare helpers.
	 */
	@BeforeClass
	public static void init() {
		parkinglotLogMapper = new ParkinglotLogMapper();
	}

	/**
	 * Validates that the mapper from ParkinglotLog to ParkinglotLogEntity works.
	 */
	@Test
	public void givenParkinglotLogMapsToParkinglotLogEntity() {
		// Arrange
		ParkinglotLog parkinglotLog = new ParkinglotLogDataBuilder().withId(ID).withPlate(PLATE)
				.withVehicleType(VEHICLE_TYPE).withAdmissionDate(ADMISSION_DATE).withDepartureDate(DEPARTURE_DATE)
				.build();

		// Act
		ParkinglotLogEntity parkinglotLogEntity = parkinglotLogMapper.parkinglotLogToParkinglotLogEntity(parkinglotLog);

		// Assert
		assertThat(parkinglotLogEntity.getId()).isEqualTo(ID);
		assertThat(parkinglotLogEntity.getPlate()).isEqualTo(PLATE);
		assertThat(parkinglotLogEntity.getVehicleType()).isEqualTo(VEHICLE_TYPE);
		assertThat(parkinglotLogEntity.getAdmissionDate()).isEqualTo(ADMISSION_DATE);
		assertThat(parkinglotLogEntity.getDepartureDate()).isEqualTo(DEPARTURE_DATE);
	}

	/**
	 * Validates that the mapper from ParkinglotLogEntity to ParkinglotLog works.
	 */
	@Test
	public void givenParkinglotLogEntityMapsToParkinglotLog() {
		// Arrange
		ParkinglotLogEntity parkinglotLogEntity = new ParkinglotLogEntityDataBuilder().withId(ID).withPlate(PLATE)
				.withVehicleType(VEHICLE_TYPE).withAdmissionDate(ADMISSION_DATE).withDepartureDate(DEPARTURE_DATE)
				.build();

		// Act
		ParkinglotLog parkinglotLog = parkinglotLogMapper.parkinglotLogEntityToParkinglotLog(parkinglotLogEntity);

		// Assert
		assertThat(parkinglotLog.getId()).isEqualTo(ID);
		assertThat(parkinglotLog.getPlate()).isEqualTo(PLATE);
		assertThat(parkinglotLog.getVehicleType()).isEqualTo(VEHICLE_TYPE);
		assertThat(parkinglotLog.getAdmissionDate()).isEqualTo(ADMISSION_DATE);
		assertThat(parkinglotLog.getDepartureDate()).isEqualTo(DEPARTURE_DATE);
	}

	/**
	 * Validates that the mapper returns null for ParkinglotLog source as null.
	 */
	@Test
	public void givenParkinglotLogIsNullMapsToParkinglotLogEntityAsNull() {
		// Arrange
		ParkinglotLog parkinglotLog = null;

		// Act
		ParkinglotLogEntity parkinglotLogEntity = parkinglotLogMapper.parkinglotLogToParkinglotLogEntity(parkinglotLog);

		// Assert
		assertThat(parkinglotLogEntity).isNull();
	}

	/**
	 * Validates that the mapper returns null for ParkinglotLogEntity source as
	 * null.
	 */
	@Test
	public void givenParkinglotLogEntityIsNullMapsToParkinglotLogAsNull() {
		// Arrange
		ParkinglotLogEntity parkinglotLogEntity = null;

		// Act
		ParkinglotLog parkinglotLog = parkinglotLogMapper.parkinglotLogEntityToParkinglotLog(parkinglotLogEntity);

		// Assert
		assertThat(parkinglotLog).isNull();
	}

	/**
	 * Validates that given an empty ParkinglotLog list maps to an empty
	 * ParkinglotLogEntity list.
	 */
	@Test
	public void givenParkinglotLogListIsEmptyMapsToParkinglotLogEntitiesListEmpty() {
		// Arrange
		List<ParkinglotLog> parkinglotLogsList = new ArrayList<>();

		// Act
		List<ParkinglotLogEntity> parkinglotLogEntitiesList = parkinglotLogMapper
				.parkinglotLogsToParkinglotLogEntities(parkinglotLogsList);

		// Assert
		assertThat(parkinglotLogEntitiesList).hasSize(0);
	}

	/**
	 * Validates that given an empty ParkinglotLogEntity list maps to an empty
	 * ParkinglotLog list.
	 */
	@Test
	public void givenParkinglotLogEntitiesListIsEmptyMapsToParkinglotLogListEmpty() {
		// Arrange
		List<ParkinglotLogEntity> parkinglotLogEntitiesList = new ArrayList<>();

		// Act
		List<ParkinglotLog> parkinglotLogsList = parkinglotLogMapper
				.parkinglotLogEntitiesToParkinglotLogs(parkinglotLogEntitiesList);

		// Assert
		assertThat(parkinglotLogsList).hasSize(0);
	}

	/**
	 * Check ParkinglotLogEntity Getters/Setters, hashCode and equals methods.
	 */
	@Test
	public void givenParkinglotLogEntityPassesObjectProperties() {
		// Arrange
		ParkinglotLogEntity parkinglotLogEntity = new ParkinglotLogEntityDataBuilder().build();
		ParkinglotLogEntity parkinglotLogEntityCopy = parkinglotLogEntity;
		parkinglotLogEntity.setId(ID);
		parkinglotLogEntity.setPlate(PLATE);
		parkinglotLogEntity.setVehicleType(VEHICLE_TYPE);
		parkinglotLogEntity.setAdmissionDate(LocalDateTime.MIN);
		parkinglotLogEntity.setDepartureDate(LocalDateTime.MIN);

		// Act
		ParkinglotLog parkinglotLog = parkinglotLogMapper.parkinglotLogEntityToParkinglotLog(parkinglotLogEntity);
		ParkinglotLogEntity parkinglotLogEntityDup = parkinglotLogMapper
				.parkinglotLogToParkinglotLogEntity(parkinglotLog);
		boolean sameAsCopy = parkinglotLogEntity.equals(parkinglotLogEntityCopy);
		boolean sameDescription = parkinglotLogEntityDup.toString().equals(parkinglotLogEntity.toString());
		boolean sameHashCode = parkinglotLogEntityDup.hashCode() == parkinglotLogEntity.hashCode();
		boolean sameObjRef = parkinglotLogEntityDup.equals(parkinglotLogEntity);
		boolean sameObjRefToNull = parkinglotLogEntityDup.equals(null);
		boolean sameEntityContents = parkinglotLogEntityDup.equals(parkinglotLogEntity);

		// Assert
		assertThat(sameAsCopy).isTrue();
		assertThat(sameDescription).isTrue();
		assertThat(sameHashCode).isTrue();
		assertThat(sameObjRef).isFalse(); // Mapper creates another instance
		assertThat(sameObjRefToNull).isFalse();
		assertThat(sameEntityContents).isFalse();

		/// Now with contents.
		assertThat(parkinglotLogEntity.getId()).isEqualTo(parkinglotLogEntityDup.getId());
		assertThat(parkinglotLogEntity.getPlate()).isEqualTo(parkinglotLogEntityDup.getPlate());
		assertThat(parkinglotLogEntity.getVehicleType()).isEqualTo(parkinglotLogEntityDup.getVehicleType());
		assertThat(parkinglotLogEntity.getAdmissionDate()).isEqualTo(parkinglotLogEntityDup.getAdmissionDate());
		assertThat(parkinglotLogEntity.getDepartureDate()).isEqualTo(parkinglotLogEntityDup.getDepartureDate());
	}

	/**
	 * Check ParkinglotLog Getters/Setters, hashCode and equals methods.
	 */
	@Test
	public void givenParkinglotLogPassesObjectProperties() {
		// Arrange
		ParkinglotLog parkinglotLog = new ParkinglotLog();
		ParkinglotLog parkinglotLogCopy = parkinglotLog;
		parkinglotLog.setId(ID);
		parkinglotLog.setPlate(PLATE);
		parkinglotLog.setVehicleType(VEHICLE_TYPE);
		parkinglotLog.setAdmissionDate(LocalDateTime.MIN);
		parkinglotLog.setDepartureDate(LocalDateTime.MIN);

		// Act
		ParkinglotLogEntity parkinglotLogEntity = parkinglotLogMapper.parkinglotLogToParkinglotLogEntity(parkinglotLog);
		ParkinglotLog parkinglotLogDup = parkinglotLogMapper.parkinglotLogEntityToParkinglotLog(parkinglotLogEntity);
		boolean sameAsCopy = parkinglotLog.equals(parkinglotLogCopy);
		boolean sameDescription = parkinglotLogDup.toString().equals(parkinglotLog.toString());
		boolean sameHashCode = parkinglotLogDup.hashCode() == parkinglotLog.hashCode();
		boolean sameObjRef = parkinglotLogDup.equals(parkinglotLog);
		boolean sameObjRefToNull = parkinglotLogDup.equals(null);
		boolean sameEntityContents = parkinglotLogDup.equals(parkinglotLog);

		// Assert
		assertThat(sameAsCopy).isTrue();
		assertThat(sameDescription).isTrue();
		assertThat(sameHashCode).isTrue();
		assertThat(sameObjRef).isFalse(); // Mapper creates another instance
		assertThat(sameObjRefToNull).isFalse();
		assertThat(sameEntityContents).isFalse();

		/// Now with contents.
		assertThat(parkinglotLog.getId()).isEqualTo(parkinglotLogDup.getId());
		assertThat(parkinglotLog.getPlate()).isEqualTo(parkinglotLogDup.getPlate());
		assertThat(parkinglotLog.getVehicleType()).isEqualTo(parkinglotLogDup.getVehicleType());
		assertThat(parkinglotLog.getAdmissionDate()).isEqualTo(parkinglotLogDup.getAdmissionDate());
		assertThat(parkinglotLog.getDepartureDate()).isEqualTo(parkinglotLogDup.getDepartureDate());
	}
}
