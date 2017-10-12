/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTCONFIGMAPPERTESTS.JAVA                            */
/* Description:   Test suite for ParkinglotConfig.                            */
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

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotConfig;
import com.csoftz.ceiba.java.learn.parking.service.entities.ParkinglotConfigEntity;
import com.csoftz.ceiba.java.learn.parking.service.mapper.ParkinglotConfigMapper;
import com.csoftz.ceiba.java.learn.parking.service.test.domain.data.builder.ParkinglotConfigDataBuilder;
import com.csoftz.ceiba.java.learn.parking.service.test.entities.data.builder.ParkinglotConfigEntityDataBuilder;

/**
 * Test suite for ParkinglotConfig.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.12/2017
 * @since 1.8 (JDK), Oct.05/2017
 */
public class ParkinglotConfigMapperTests {
	private static final Long ID = 1L;
	private static final String NAME = "ConfigKey";
	private static final String VALUE = "value";
	private static final String DESCRIPTION = "Description";

	private static ParkinglotConfigMapper parkinglotConfigMapper;

	/**
	 * Prepare helpers.
	 */
	@BeforeClass
	public static void init() {
		parkinglotConfigMapper = new ParkinglotConfigMapper();
	}

	/**
	 * Validates that the mapper from ParkinglotConfig to ParkinglotConfigEntity
	 * works.
	 */
	@Test
	public void givenParkinglotConfigMapsToParkinglotConfigEntity() {
		// Arrange
		ParkinglotConfig parkinglotConfig = new ParkinglotConfigDataBuilder().withId(ID).withName(NAME).withValue(VALUE)
				.withDescription(DESCRIPTION).build();

		// Act
		ParkinglotConfigEntity parkinglotConfigEntity = parkinglotConfigMapper
				.parkinglotConfigToParkinglotConfigEntity(parkinglotConfig);

		// Assert
		assertThat(parkinglotConfigEntity.getId()).isEqualTo(ID);
		assertThat(parkinglotConfigEntity.getValue()).isEqualTo(VALUE);
		assertThat(parkinglotConfigEntity.getName()).isEqualTo(NAME);
		assertThat(parkinglotConfigEntity.getDescription()).isEqualTo(DESCRIPTION);
	}

	/**
	 * Validates that the mapper from ParkinglotConfigEntity to ParkinglotConfig
	 * works.
	 */
	@Test
	public void givenParkinglotConfigEntityMapsToParkinglotConfig() {
		// Arrange
		ParkinglotConfigEntity parkinglotConfigEntity = new ParkinglotConfigEntityDataBuilder().withId(ID)
				.withName(NAME).withValue(VALUE).withDescription(DESCRIPTION).build();

		// Act
		ParkinglotConfig parkinglotConfig = parkinglotConfigMapper
				.parkinglotConfigEntityToParkinglotConfig(parkinglotConfigEntity);

		// Assert
		assertThat(parkinglotConfig.getId()).isEqualTo(ID);
		assertThat(parkinglotConfig.getName()).isEqualTo(NAME);
		assertThat(parkinglotConfig.getValue()).isEqualTo(VALUE);
		assertThat(parkinglotConfig.getDescription()).isEqualTo(DESCRIPTION);
	}

	/**
	 * Validates that the mapper returns null for ParkinglotConfig source as null.
	 */
	@Test
	public void givenParkinglotConfigIsNullMapsToParkinglotConfigEntityAsNull() {
		// Arrange
		ParkinglotConfig parkinglotConfig = null;

		// Act
		ParkinglotConfigEntity parkinglotConfigEntity = parkinglotConfigMapper
				.parkinglotConfigToParkinglotConfigEntity(parkinglotConfig);

		// Assert
		assertThat(parkinglotConfigEntity).isNull();
	}

	/**
	 * Validates that the mapper returns null for ParkinglotConfigEntity source as
	 * null.
	 */
	@Test
	public void givenParkinglotConfigEntityIsNullMapsToParkinglotConfigAsNull() {
		// Arrange
		ParkinglotConfigEntity parkinglotConfigEntity = null;

		// Act
		ParkinglotConfig parkinglotConfig = parkinglotConfigMapper
				.parkinglotConfigEntityToParkinglotConfig(parkinglotConfigEntity);

		// Assert
		assertThat(parkinglotConfig).isNull();
	}

	/**
	 * Validates that given an empty ParkinglotConfig list maps to an empty
	 * ParkinglotConfigEntity list.
	 */
	@Test
	public void givenParkinglotConfigListIsEmptyMapsToParkinglotConfigEntitiesListEmpty() {
		// Arrange
		List<ParkinglotConfig> parkinglotConfigList = new ArrayList<>();

		// Act
		List<ParkinglotConfigEntity> parkinglotConfigEntitiesList = parkinglotConfigMapper
				.parkinglotConfigsToParkinglotConfigEntities(parkinglotConfigList);

		// Assert
		assertThat(parkinglotConfigEntitiesList).hasSize(0);
	}

	/**
	 * Validates that given an empty ParkinglotConfigEntity list maps to an empty
	 * ParkinglotConfig list.
	 */
	@Test
	public void givenParkinglotConfigEntitiesListIsEmptyMapsToParkinglotConfigListEmpty() {
		// Arrange
		List<ParkinglotConfigEntity> parkinglotConfigEntitiesList = new ArrayList<>();

		// Act
		List<ParkinglotConfig> parkinglotConfigList = parkinglotConfigMapper
				.parkinglotConfigEntitiesToParkinglotConfigs(parkinglotConfigEntitiesList);

		// Assert
		assertThat(parkinglotConfigList).hasSize(0);
	}

	/**
	 * Check ParkinglotConfigEntity Getters/Setters, hashCode and equals methods.
	 */
	@Test
	public void givenParkinglotConfigEntityPassesObjectProperties() {
		// Arrange
		ParkinglotConfigEntity parkinglotConfigEntity = new ParkinglotConfigEntityDataBuilder().build();
		ParkinglotConfigEntity parkinglotConfigEntityCopy = parkinglotConfigEntity;
		parkinglotConfigEntity.setId(ID);
		parkinglotConfigEntity.setName(NAME);
		parkinglotConfigEntity.setValue(VALUE);
		parkinglotConfigEntity.setDescription(DESCRIPTION);

		// Act
		ParkinglotConfig parkinglotConfig = parkinglotConfigMapper
				.parkinglotConfigEntityToParkinglotConfig(parkinglotConfigEntity);
		ParkinglotConfigEntity parkinglotConfigEntityDup = parkinglotConfigMapper
				.parkinglotConfigToParkinglotConfigEntity(parkinglotConfig);
		boolean sameAsCopy = parkinglotConfigEntity.equals(parkinglotConfigEntityCopy);
		boolean sameDescription = parkinglotConfigEntityDup.toString().equals(parkinglotConfigEntity.toString());
		boolean sameHashCode = parkinglotConfigEntityDup.hashCode() == parkinglotConfigEntity.hashCode();
		boolean sameObjRef = parkinglotConfigEntityDup.equals(parkinglotConfigEntity);
		boolean sameObjRefToNull = parkinglotConfigEntityDup.equals(null);
		boolean sameEntityContents = parkinglotConfigEntityDup.equals(parkinglotConfigEntity);

		// Assert
		assertThat(sameAsCopy).isTrue();
		assertThat(sameDescription).isTrue();
		assertThat(sameHashCode).isTrue();
		assertThat(sameObjRef).isFalse(); // Mapper creates another instance
		assertThat(sameObjRefToNull).isFalse();
		assertThat(sameEntityContents).isFalse();

		/// Now with contents.
		assertThat(parkinglotConfigEntity.getId()).isEqualTo(parkinglotConfigEntityDup.getId());
		assertThat(parkinglotConfigEntity.getName()).isEqualTo(parkinglotConfigEntityDup.getName());
		assertThat(parkinglotConfigEntity.getValue()).isEqualTo(parkinglotConfigEntityDup.getValue());
		assertThat(parkinglotConfigEntity.getDescription()).isEqualTo(parkinglotConfigEntityDup.getDescription());
	}

	/**
	 * Check ParkinglotConfig Getters/Setters, hashCode and equals methods.
	 */
	@Test
	public void givenParkinglotConfigPassesObjectProperties() {
		// Arrange
		ParkinglotConfig parkinglotConfig = new ParkinglotConfig();
		ParkinglotConfig parkinglotConfigCopy = parkinglotConfig;
		parkinglotConfig.setId(ID);
		parkinglotConfig.setName(NAME);
		parkinglotConfig.setValue(VALUE);
		parkinglotConfig.setDescription(DESCRIPTION);

		// Act
		ParkinglotConfigEntity parkinglotConfigEntity = parkinglotConfigMapper
				.parkinglotConfigToParkinglotConfigEntity(parkinglotConfig);
		ParkinglotConfig parkinglotConfigDup = parkinglotConfigMapper
				.parkinglotConfigEntityToParkinglotConfig(parkinglotConfigEntity);
		boolean sameAsCopy = parkinglotConfig.equals(parkinglotConfigCopy);
		boolean sameDescription = parkinglotConfigDup.toString().equals(parkinglotConfig.toString());
		boolean sameHashCode = parkinglotConfigDup.hashCode() == parkinglotConfig.hashCode();
		boolean sameObjRef = parkinglotConfigDup.equals(parkinglotConfig);
		boolean sameObjRefToNull = parkinglotConfigDup.equals(null);
		boolean sameEntityContents = parkinglotConfigDup.equals(parkinglotConfig);

		// Assert
		assertThat(sameAsCopy).isTrue();
		assertThat(sameDescription).isTrue();
		assertThat(sameHashCode).isTrue();
		assertThat(sameObjRef).isFalse(); // Mapper creates another instance
		assertThat(sameObjRefToNull).isFalse();
		assertThat(sameEntityContents).isFalse();

		/// Now with contents.
		assertThat(parkinglotConfig.getId()).isEqualTo(parkinglotConfigDup.getId());
		assertThat(parkinglotConfig.getName()).isEqualTo(parkinglotConfigDup.getName());
		assertThat(parkinglotConfig.getValue()).isEqualTo(parkinglotConfigDup.getValue());
		assertThat(parkinglotConfig.getDescription()).isEqualTo(parkinglotConfigDup.getDescription());
	}
}
