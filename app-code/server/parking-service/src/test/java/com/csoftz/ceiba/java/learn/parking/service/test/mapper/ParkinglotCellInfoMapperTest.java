/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTCELLINFOMAPPERTEST.JAVA                           */
/* Description:   Test suite for ParkinglotCellInfoMapper.                    */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.05/2017                                                 */
/* Last Modified: Oct.06/2017                                                 */
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

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotCellInfo;
import com.csoftz.ceiba.java.learn.parking.service.entities.ParkinglotCellInfoEntity;
import com.csoftz.ceiba.java.learn.parking.service.mapper.ParkinglotCellInfoMapper;
import com.csoftz.ceiba.java.learn.parking.service.test.domain.data.builder.ParkinglotCellInfoDataBuilder;
import com.csoftz.ceiba.java.learn.parking.service.test.entities.data.builder.ParkinglotCellInfoEntityDataBuilder;

/**
 * Test suite for ParkinglotCellInfoMapper.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.06/2017
 * @since 1.8 (JDK), Oct.05/2017
 */
public class ParkinglotCellInfoMapperTest {
	private static final String PLATE = "KDF123";
	private static final int VEHICLE_TYPE = VEHICLE_TYPE_CAR;

	private static ParkinglotCellInfoMapper parkinglotCellInfoMapper;

	/**
	 * Prepare helpers.
	 */
	@BeforeClass
	public static void init() {
		parkinglotCellInfoMapper = new ParkinglotCellInfoMapper();
	}

	/**
	 * Validates that the mapper from ParkinglotCellInfo to ParkinglotCellInfoEntity
	 * works.
	 */
	@Test
	public void givenParkinglotCellInfoMapsToParkinglotCellInfoEntity() {
		// Arrange
		ParkinglotCellInfo parkinglotCellInfo = new ParkinglotCellInfoDataBuilder().withPlate(PLATE)
				.withVehicleType(VEHICLE_TYPE).build();

		// Act
		ParkinglotCellInfoEntity parkinglotCellInfoEntity = parkinglotCellInfoMapper
				.parkinglotCellInfoToParkinglotCellInfoEntity(parkinglotCellInfo);

		// Assert
		assertThat(parkinglotCellInfoEntity.getPlate()).isEqualTo(PLATE);
		assertThat(parkinglotCellInfoEntity.getVehicleType()).isEqualTo(VEHICLE_TYPE);
	}

	/**
	 * Validates that the mapper from ParkinglotCellInfoEntity to ParkinglotCellInfo
	 * works.
	 */
	@Test
	public void givenParkinglotCellInfoEntityMapsToParkinglotCellInfo() {
		// Arrange
		ParkinglotCellInfoEntity parkinglotCellInfoEntity = new ParkinglotCellInfoEntityDataBuilder().withPlate(PLATE)
				.withVehicleType(VEHICLE_TYPE).build();

		// Act
		ParkinglotCellInfo parkinglotCellInfo = parkinglotCellInfoMapper
				.parkinglotCellInfoEntityToParkinglotCellInfo(parkinglotCellInfoEntity);

		// Assert
		assertThat(parkinglotCellInfo.getPlate()).isEqualTo(PLATE);
		assertThat(parkinglotCellInfo.getVehicleType()).isEqualTo(VEHICLE_TYPE);
	}

	/**
	 * Validates that the mapper returns null for ParkinglotCellInfo source as null.
	 */
	@Test
	public void givenParkinglotCellInfoIsNullMapsToParkinglotCellInfoEntityAsNull() {
		// Arrange
		ParkinglotCellInfo parkinglotCellInfo = null;

		// Act
		ParkinglotCellInfoEntity parkinglotCellInfoEntity = parkinglotCellInfoMapper
				.parkinglotCellInfoToParkinglotCellInfoEntity(parkinglotCellInfo);

		// Assert
		assertThat(parkinglotCellInfoEntity).isNull();
	}

	/**
	 * Validates that the mapper returns null for ParkinglotCellInfoEntity source as
	 * null.
	 */
	@Test
	public void givenParkinglotCellInfoEntityIsNullMapsToParkinglotCellInfoAsNull() {
		// Arrange
		ParkinglotCellInfoEntity parkinglotCellInfoEntity = null;

		// Act
		ParkinglotCellInfo parkinglotCellInfo = parkinglotCellInfoMapper
				.parkinglotCellInfoEntityToParkinglotCellInfo(parkinglotCellInfoEntity);

		// Assert
		assertThat(parkinglotCellInfo).isNull();
	}

	/**
	 * Validates that given an empty ParkinglotCellInfo list maps to an empty
	 * ParkinglotCellInfoEntity list.
	 */
	@Test
	public void givenParkinglotCellInfoListIsEmptyMapsToParkinglotCellInfoEntitiesListEmpty() {
		// Arrange
		List<ParkinglotCellInfo> parkinglotCellInfosList = new ArrayList<>();

		// Act
		List<ParkinglotCellInfoEntity> parkinglotCellInfoEntitiesList = parkinglotCellInfoMapper
				.parkinglotCellInfosToParkinglotCellInfoEntities(parkinglotCellInfosList);

		// Assert
		assertThat(parkinglotCellInfoEntitiesList).hasSize(0);
	}

	/**
	 * Validates that given an empty ParkinglotCellInfoEntity list maps to an empty
	 * ParkinglotCellInfo list.
	 */
	@Test
	public void givenParkinglotCellInfoEntitiesListIsEmptyMapsToParkinglotCellInfoListEmpty() {
		// Arrange
		List<ParkinglotCellInfoEntity> parkinglotCellInfoEntitiesList = new ArrayList<>();

		// Act
		List<ParkinglotCellInfo> parkinglotCellInfosList = parkinglotCellInfoMapper
				.parkinglotCellInfoEntitiesToParkinglotCellInfos(parkinglotCellInfoEntitiesList);

		// Assert
		assertThat(parkinglotCellInfosList).hasSize(0);
	}
}