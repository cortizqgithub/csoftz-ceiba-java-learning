/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTCELLINFOMAPPERTESTS.JAVA                          */
/* Description:   Test suite for ParkinglotCellInfoMapper.                    */
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
 * @version 1.1, Oct.12/2017
 * @since 1.8 (JDK), Oct.05/2017
 */
public class ParkinglotCellInfoMapperTests {
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

	/**
	 * Check ParkinglotCellInfoEntity Getters/Setters, hashCode and equals methods.
	 */
	@Test
	public void givenParkinglotConfigEntityPassesObjectProperties() {
		// Arrange
		ParkinglotCellInfoEntity parkinglotCellInfoEntity = new ParkinglotCellInfoEntityDataBuilder().build();
		ParkinglotCellInfoEntity parkinglotCellInfoEntityCopy = parkinglotCellInfoEntity;
		parkinglotCellInfoEntity.setPlate(PLATE);
		parkinglotCellInfoEntity.setVehicleType(VEHICLE_TYPE);

		// Act
		ParkinglotCellInfo parkinglotCellInfo = parkinglotCellInfoMapper
				.parkinglotCellInfoEntityToParkinglotCellInfo(parkinglotCellInfoEntity);
		ParkinglotCellInfoEntity parkinglotCellInfoEntityDup = parkinglotCellInfoMapper
				.parkinglotCellInfoToParkinglotCellInfoEntity(parkinglotCellInfo);
		boolean sameAsCopy = parkinglotCellInfoEntity.equals(parkinglotCellInfoEntityCopy);
		boolean sameDescription = parkinglotCellInfoEntityDup.toString().equals(parkinglotCellInfoEntity.toString());
		boolean sameHashCode = parkinglotCellInfoEntityDup.hashCode() == parkinglotCellInfoEntity.hashCode();
		boolean sameObjRef = parkinglotCellInfoEntityDup.equals(parkinglotCellInfoEntity);
		boolean sameObjRefToNull = parkinglotCellInfoEntityDup.equals(null);
		boolean sameEntityContents = parkinglotCellInfoEntityDup.equals(parkinglotCellInfoEntity);

		// Assert
		assertThat(sameAsCopy).isTrue();
		assertThat(sameDescription).isTrue();
		assertThat(sameHashCode).isTrue();
		assertThat(sameObjRef).isFalse(); // Mapper creates another instance
		assertThat(sameObjRefToNull).isFalse();
		assertThat(sameEntityContents).isFalse();

		/// Now with contents.
		assertThat(parkinglotCellInfoEntity.getPlate()).isEqualTo(parkinglotCellInfoEntityDup.getPlate());
		assertThat(parkinglotCellInfoEntity.getVehicleType()).isEqualTo(parkinglotCellInfoEntityDup.getVehicleType());
	}

	/**
	 * Check ParkinglotCellInfo Getters/Setters, hashCode and equals methods.
	 */
	@Test
	public void givenParkinglotCellInfoPassesObjectProperties() {
		// Arrange
		ParkinglotCellInfo parkinglotCellInfo = new ParkinglotCellInfo();
		ParkinglotCellInfo parkinglotCellInfoCopy = parkinglotCellInfo;
		parkinglotCellInfo.setPlate(PLATE);
		parkinglotCellInfo.setVehicleType(VEHICLE_TYPE);

		// Act
		ParkinglotCellInfoEntity parkinglotCellInfoEntity = parkinglotCellInfoMapper
				.parkinglotCellInfoToParkinglotCellInfoEntity(parkinglotCellInfo);
		ParkinglotCellInfo parkinglotCellInfoDup = parkinglotCellInfoMapper
				.parkinglotCellInfoEntityToParkinglotCellInfo(parkinglotCellInfoEntity);
		boolean sameAsCopy = parkinglotCellInfo.equals(parkinglotCellInfoCopy);
		boolean sameDescription = parkinglotCellInfoDup.toString().equals(parkinglotCellInfo.toString());
		boolean sameHashCode = parkinglotCellInfoDup.hashCode() == parkinglotCellInfo.hashCode();
		boolean sameObjRef = parkinglotCellInfoDup.equals(parkinglotCellInfo);
		boolean sameObjRefToNull = parkinglotCellInfoDup.equals(null);
		boolean sameEntityContents = parkinglotCellInfoDup.equals(parkinglotCellInfo);

		// Assert
		assertThat(sameAsCopy).isTrue();
		assertThat(sameDescription).isTrue();
		assertThat(sameHashCode).isTrue();
		assertThat(sameObjRef).isFalse(); // Mapper creates another instance
		assertThat(sameObjRefToNull).isFalse();
		assertThat(sameEntityContents).isFalse();

		/// Now with contents.
		assertThat(parkinglotCellInfo.getPlate()).isEqualTo(parkinglotCellInfoDup.getPlate());
		assertThat(parkinglotCellInfo.getVehicleType()).isEqualTo(parkinglotCellInfoDup.getVehicleType());
	}
}