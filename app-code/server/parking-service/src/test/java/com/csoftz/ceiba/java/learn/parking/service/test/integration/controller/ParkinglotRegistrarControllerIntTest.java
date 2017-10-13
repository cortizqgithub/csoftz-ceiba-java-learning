/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTREGISTRARCONTROLLERIntTest.JAVA                   */
/* Description:   Controller to register a Vehicle to Parking lot             */
/*                (Integration test).                                         */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.11/2017                                                 */
/* Last Modified: Oct.13/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.11/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.ceiba.java.learn.parking.service.test.integration.controller;

import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_TYPE_CAR;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_TYPE_OTHER;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.csoftz.ceiba.java.learn.parking.commons.helper.UtilHelper;
import com.csoftz.ceiba.java.learn.parking.domain.Vehicle;
import com.csoftz.ceiba.java.learn.parking.service.ParkingServiceApplication;
import com.csoftz.ceiba.java.learn.parking.service.test.domain.data.builder.VehicleDataBuilder;

/**
 * Controller to register a Vehicle to Parking lot. This is an integration test.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.13/2017
 * @since 1.8 (JDK), Oct.11/2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = ParkingServiceApplication.class)
@AutoConfigureMockMvc
public class ParkinglotRegistrarControllerIntTest {
	/*
	 * Test data constants.
	 */
	private static final String PLATE = "KDF123";
	private static final int VEHICLE_TYPE = VEHICLE_TYPE_CAR;
	private static final String REGISTRAR_END_POINT = "/api/v1/parking/registrar";

	@Autowired
	private MockMvc restRegistarMocMvc;

	/**
	 * Perform an END point test for registration with all valid data.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testVehicleRegistersSuccessfully() throws Exception {
		// Arrange
		Vehicle vehicle = new VehicleDataBuilder().withPlate(PLATE).withType(VEHICLE_TYPE).build();

		// Act
		restRegistarMocMvc.perform(post(REGISTRAR_END_POINT).contentType(MediaType.APPLICATION_JSON)
				.content(UtilHelper.convertObjectToJsonBytes(vehicle))).andExpect(status().isOk());

		// Assert
	}

	/**
	 * Perform an END point test for registration with invalid vehicleType.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testVehicleRegisterFailVehicleType() throws Exception {
		// Arrange
		Vehicle vehicle = new VehicleDataBuilder().withPlate(PLATE).withType(VEHICLE_TYPE_OTHER).build();

		// Act
		restRegistarMocMvc.perform(post(REGISTRAR_END_POINT).contentType(MediaType.APPLICATION_JSON)
				.content(UtilHelper.convertObjectToJsonBytes(vehicle))).andExpect(status().isNotAcceptable());

		// Assert
	}

	/**
	 * Perform and END point test for registration with no data supplied
	 */
	@Test
	public void testVehicleRegisterNoDataReturnsError400() throws Exception {
		// Arrange

		// Act
		restRegistarMocMvc.perform(post(REGISTRAR_END_POINT).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());

		// Assert
	}

}
