/*----------------------------------------------------------------------------*/
/* Source File:   VEHICLEMAPPERTEST.JAVA                                      */
/* Description:   Test suite for VehicleMapper.                               */
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

import com.csoftz.ceiba.java.learn.parking.domain.Vehicle;
import com.csoftz.ceiba.java.learn.parking.service.entities.VehicleEntity;
import com.csoftz.ceiba.java.learn.parking.service.mapper.VehicleMapper;
import com.csoftz.ceiba.java.learn.parking.service.test.domain.data.builder.VehicleDataBuilder;
import com.csoftz.ceiba.java.learn.parking.service.test.entities.data.builder.VehicleEntityDataBuilder;

/**
 * Test suite for VehicleMapper.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.12/2017
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

	/**
	 * Check VehicleEntity Getters/Setters, hashCode and equals methods.
	 */
	@Test
	public void givenVehicleEntityPassesObjectProperties() {
		// Arrange
		VehicleEntity vehicleEntity = new VehicleEntityDataBuilder().build();
		VehicleEntity vehicleEntityCopy = vehicleEntity;
		vehicleEntity.setId(ID);
		vehicleEntity.setPlate(PLATE);
		vehicleEntity.setType(VEHICLE_TYPE);
		vehicleEntity.setCylinder(CYLINDER);

		// Act
		Vehicle vehicle = vehicleMapper.vehicleEntityToVehicle(vehicleEntity);
		VehicleEntity vehicleEntityDup = vehicleMapper.vehicleToVehicleEntity(vehicle);
		boolean sameAsCopy = vehicleEntity.equals(vehicleEntityCopy);
		boolean sameDescription = vehicleEntityDup.toString().equals(vehicleEntity.toString());
		boolean sameHashCode = vehicleEntityDup.hashCode() == vehicleEntity.hashCode();
		boolean sameObjRef = vehicleEntityDup.equals(vehicleEntity);
		boolean sameObjRefToNull = vehicleEntityDup.equals(null);
		boolean sameEntityContents = vehicleEntityDup.equals(vehicleEntity);

		// Assert
		assertThat(sameAsCopy).isTrue();
		assertThat(sameDescription).isTrue();
		assertThat(sameHashCode).isTrue();
		assertThat(sameObjRef).isFalse(); // Mapper creates another instance
		assertThat(sameObjRefToNull).isFalse();
		assertThat(sameEntityContents).isFalse();

		/// Now with contents.
		assertThat(vehicleEntity.getId()).isEqualTo(vehicleEntityDup.getId());
		assertThat(vehicleEntity.getPlate()).isEqualTo(vehicleEntityDup.getPlate());
		assertThat(vehicleEntity.getType()).isEqualTo(vehicleEntityDup.getType());
		assertThat(vehicleEntity.getCylinder()).isEqualTo(vehicleEntityDup.getCylinder());
	}

	/**
	 * Check Vehicle Getters/Setters, hashCode and equals methods.
	 */
	@Test
	public void givenVehiclePassesObjectProperties() {
		// Arrange
		Vehicle vehicle = new Vehicle();
		Vehicle vehicleCopy = vehicle;
		vehicle.setId(ID);
		vehicle.setPlate(PLATE);
		vehicle.setType(VEHICLE_TYPE);
		vehicle.setCylinder(CYLINDER);

		// Act
		VehicleEntity vehicleEntity = vehicleMapper.vehicleToVehicleEntity(vehicle);
		Vehicle vehicleDup = vehicleMapper.vehicleEntityToVehicle(vehicleEntity);
		boolean sameAsCopy = vehicle.equals(vehicleCopy);
		boolean sameDescription = vehicleDup.toString().equals(vehicle.toString());
		boolean sameHashCode = vehicleDup.hashCode() == vehicle.hashCode();
		boolean sameObjRef = vehicleDup.equals(vehicle);
		boolean sameObjRefToNull = vehicleDup.equals(null);
		boolean sameEntityContents = vehicleDup.equals(vehicle);

		// Assert
		assertThat(sameAsCopy).isTrue();
		assertThat(sameDescription).isTrue();
		assertThat(sameHashCode).isTrue();
		assertThat(sameObjRef).isFalse(); // Mapper creates another instance
		assertThat(sameObjRefToNull).isFalse();
		assertThat(sameEntityContents).isFalse();

		/// Now with contents.
		assertThat(vehicle.getId()).isEqualTo(vehicleDup.getId());
		assertThat(vehicle.getPlate()).isEqualTo(vehicleDup.getPlate());
		assertThat(vehicle.getType()).isEqualTo(vehicleDup.getType());
		assertThat(vehicle.getCylinder()).isEqualTo(vehicleDup.getCylinder());
	}
}
