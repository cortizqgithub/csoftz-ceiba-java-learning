/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTREGISTRARCONTROLLERTESTS.JAVA                     */
/* Description:   Controller to register a Vehicle to Parking lot (Tests)     */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.11/2017                                                 */
/* Last Modified: Oct.11/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.11/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.ceiba.java.learn.parking.service.controller;

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
 * Controller to register a Vehicle to Parking lot (Tests).
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.11/2017
 * @since 1.8 (JDK), Oct.11/2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = ParkingServiceApplication.class)
@AutoConfigureMockMvc
public class ParkinglotRegistrarControllerTests {
	@Autowired
	private MockMvc restRegistarMocMvc;

	/**
	 * Perform an END point test for /
	 * 
	 * @throws Exception
	 */
	@Test
	public void testVehicleRegistersSuccessfully() throws Exception {
		// Arrange
		Vehicle vehicle = new VehicleDataBuilder().withPlate("ABC123").withType(1).build();

		// Act
		restRegistarMocMvc.perform(post("/api/v1/parking/registrar").contentType(MediaType.APPLICATION_JSON)
				.content(UtilHelper.convertObjectToJsonBytes(vehicle))).andExpect(status().isOk());

		// Assert
	}
}
