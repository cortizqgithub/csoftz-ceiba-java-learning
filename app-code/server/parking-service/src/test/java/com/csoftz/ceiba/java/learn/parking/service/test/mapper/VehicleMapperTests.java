/*----------------------------------------------------------------------------*/
/* Source File:   VEHICLEMAPPERTEST.JAVA                                      */
/* Description:   Test suite for VehicleMapper.                               */
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

import com.csoftz.ceiba.java.learn.parking.domain.Vehicle;
import com.csoftz.ceiba.java.learn.parking.service.entities.VehicleEntity;
import com.csoftz.ceiba.java.learn.parking.service.mapper.VehicleMapper;
import com.csoftz.ceiba.java.learn.parking.service.test.domain.data.builder.VehicleDataBuilder;
import com.csoftz.ceiba.java.learn.parking.service.test.entities.data.builder.VehicleEntityDataBuilder;

/**
 * Test suite for VehicleMapper.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.06/2017
 * @since 1.8 (JDK), Oct.05/2017
 */
public class VehicleMapperTests {
	private static final Long ID = 1L;
	private static final String PLATE = "KDF123";
	private static final int VEHICLE_TYPE = VEHICLE_TYPE_CAR;
	private static final int CYLINDER = 120;

	private static VehicleMapper vehicleMapper;

	/**
	 * Prepare helpers.
	 */
	@BeforeClass
	public static void init() {
		vehicleMapper = new VehicleMapper();
	}

	/**
	 * Validates that the mapper from Vehicle to VehicleEntity works.
	 */
	@Test
	public void givenVehicleMapsToVehicleEntity() {
		// Arrange
		Vehicle vehicle = new VehicleDataBuilder().withId(ID).withPlate(PLATE).withType(VEHICLE_TYPE)
				.withCylinder(CYLINDER).build();

		// Act
		VehicleEntity vehicleEntity = vehicleMapper.vehicleToVehicleEntity(vehicle);

		// Assert
		assertThat(vehicleEntity.getId()).isEqualTo(ID);
		assertThat(vehicleEntity.getPlate()).isEqualTo(PLATE);
		assertThat(vehicleEntity.getType()).isEqualTo(VEHICLE_TYPE);
		assertThat(vehicleEntity.getCylinder()).isEqualTo(CYLINDER);
	}

	/**
	 * Validates that the mapper from VehicleEntity to Vehicle works.
	 */
	@Test
	public void givenVehicleEntityMapsToVehicle() {
		// Arrange
		VehicleEntity vehicleEntity = new VehicleEntityDataBuilder().withId(ID).withPlate(PLATE).withType(VEHICLE_TYPE)
				.withCylinder(CYLINDER).build();

		// Act
		Vehicle vehicle = vehicleMapper.vehicleEntityToVehicle(vehicleEntity);

		// Assert
		assertThat(vehicle.getId()).isEqualTo(ID);
		assertThat(vehicle.getPlate()).isEqualTo(PLATE);
		assertThat(vehicle.getType()).isEqualTo(VEHICLE_TYPE);
		assertThat(vehicle.getCylinder()).isEqualTo(CYLINDER);
	}

	/**
	 * Validates that the mapper returns null for Vehicle source as null.
	 */
	@Test
	public void givenVehicleIsNullMapsToVehicleEntityAsNull() {
		// Arrange
		Vehicle vehicle = null;

		// Act
		VehicleEntity vehicleEntity = vehicleMapper.vehicleToVehicleEntity(vehicle);

		// Assert
		assertThat(vehicleEntity).isNull();
	}

	/**
	 * Validates that the mapper returns null for VehicleEntity source as null.
	 */
	@Test
	public void givenVehicleEntityIsNullMapsToVehicleAsNull() {
		// Arrange
		VehicleEntity vehicleEntity = null;

		// Act
		Vehicle vehicle = vehicleMapper.vehicleEntityToVehicle(vehicleEntity);

		// Assert
		assertThat(vehicle).isNull();
	}

	/**
	 * Validates that given an empty Vehicle list maps to an empty VehicleEntity
	 * list.
	 */
	@Test
	public void givenVehicleListIsEmptyMapsToVehicleEntitiesListEmpty() {
		// Arrange
		List<Vehicle> vehicleList = new ArrayList<>();

		// Act
		List<VehicleEntity> vehicleEntitiesList = vehicleMapper.vehiclesToVehicleEntities(vehicleList);

		// Assert
		assertThat(vehicleEntitiesList).hasSize(0);
	}

	/**
	 * Validates that given an empty VehicleEntity list maps to an emtpye Vehicle
	 * list.
	 */
	@Test
	public void givenVehicleEntitiesListIsEmptyMapsToVehicleListEmpty() {
		// Arrange
		List<VehicleEntity> vehicleEntitiesList = new ArrayList<>();

		// Act
		List<Vehicle> vehiclesList = vehicleMapper.vehicleEntitiesToVehicles(vehicleEntitiesList);

		// Assert
		assertThat(vehiclesList).hasSize(0);
	}
}
