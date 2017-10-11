/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTREGISTRARCONTROLLER.JAVA                          */
/* Description:   Controller to register a Vehicle to Parking lot             */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.10/2017                                                 */
/* Last Modified: Oct.11/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.10/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.ceiba.java.learn.parking.service.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csoftz.ceiba.java.learn.parking.domain.Vehicle;
import com.csoftz.ceiba.java.learn.parking.domain.result.ParkinglotResult;
import com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotRegistrarService;

/**
 * Controller to register a Vehicle to Parking lot.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.11/2017
 * @since 1.8 (JDK), Oct.10/2017
 */
@RestController
@RequestMapping("/api/v1/parking/registrar")
public class ParkinglotRegistrarController {

	/**
	 * Injected by IoC
	 */
	private IParkinglotRegistrarService parkinglotRegistrarService;

	/**
	 * Constructor
	 * 
	 * @param parkinglotRegistrarService
	 */
	public ParkinglotRegistrarController(IParkinglotRegistrarService parkinglotRegistrarService) {
		this.parkinglotRegistrarService = parkinglotRegistrarService;
	}

	/**
	 * @param plate
	 * @param vehicleType
	 * @return
	 */
	@GetMapping("/{plate}/{vehicleType}")
	public ResponseEntity<ParkinglotResult> registerVehicle(@PathVariable String plate, @PathVariable int vehicleType) {
		Vehicle vehicle = new Vehicle(0L, plate, vehicleType, 120);
		ParkinglotResult parkinglotResult = new ParkinglotResult(0, "", vehicle);

		if (!parkinglotRegistrarService.isValid(vehicle)) {
			parkinglotResult.setResultCode(999);
			return new ResponseEntity<>(parkinglotResult, HttpStatus.OK);
		}
		if (!parkinglotRegistrarService.isValidPlate(vehicle, LocalDateTime.now())) {
			parkinglotResult.setResultCode(998);
			return new ResponseEntity<>(parkinglotResult, HttpStatus.OK);
		}

		int value = parkinglotRegistrarService.register(vehicle);
		parkinglotResult.setResultCode(value);
		return new ResponseEntity<>(parkinglotResult, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ParkinglotResult> registerPost(@RequestBody Vehicle vehicle) {
		ParkinglotResult parkinglotResult = new ParkinglotResult(0, "", vehicle);

		if (!parkinglotRegistrarService.isValid(vehicle)) {
			parkinglotResult.setResultCode(999);
			return new ResponseEntity<>(parkinglotResult, HttpStatus.OK);
		}
		if (!parkinglotRegistrarService.isValidPlate(vehicle, LocalDateTime.now())) {
			parkinglotResult.setResultCode(998);
			return new ResponseEntity<>(parkinglotResult, HttpStatus.OK);
		}

		int value = parkinglotRegistrarService.register(vehicle);
		parkinglotResult.setResultCode(value);
		return new ResponseEntity<>(parkinglotResult, HttpStatus.OK);
	}
}
