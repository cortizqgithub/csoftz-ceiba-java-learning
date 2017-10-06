/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTREGISTRARSERVICE.JAVA                             */
/* Description:   Implements contract for registration duties.                */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.06/2017                                                 */
/* Last Modified: Oct.06/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.06/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.ceiba.java.learn.parking.service;

import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_TYPE_CAR;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_TYPE_MOTORCYCLE;

import java.time.LocalDateTime;

import com.csoftz.ceiba.java.learn.parking.domain.Vehicle;
import com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotRegistrarService;

/**
 * Implements contract for registration duties.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.06/2017
 * @since 1.8 (JDK), Oct.06/2017
 */
public class ParkinglotRegistrarService implements IParkinglotRegistrarService {

	/**
	 * @see com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotRegistrarService#isValid(com.csoftz.ceiba.java.learn.parking.domain.Vehicle)
	 */
	@Override
	public boolean isValid(Vehicle vehicle) {
		if (vehicle == null) {
			return false;
		}
		int vehicleType = vehicle.getType();
		return (vehicleType == VEHICLE_TYPE_CAR || vehicleType == VEHICLE_TYPE_MOTORCYCLE);
	}

	/**
	 * @see com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotRegistrarService#isValidPlate(com.csoftz.ceiba.java.learn.parking.domain.Vehicle,
	 *      java.time.LocalDateTime)
	 */
	@Override
	public boolean isValidPlate(Vehicle vehicle, LocalDateTime dt) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @see com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotRegistrarService#register(com.csoftz.ceiba.java.learn.parking.domain.Vehicle)
	 */
	@Override
	public int register(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return 0;
	}
}
