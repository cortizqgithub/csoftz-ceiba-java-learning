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

import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_PLATE_START_WITH_A;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_TYPE_CAR;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_TYPE_MOTORCYCLE;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_INVALID_ARGUMENT;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_OK;

import java.time.DayOfWeek;
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
		if (vehicle == null || dt == null) {
			return false;
		}
		boolean plateStartsWithA = vehicle.getPlate().startsWith(VEHICLE_PLATE_START_WITH_A);
		if (plateStartsWithA) {
			// Now let's check if Sunday or Monday
			DayOfWeek dayOfWeek = dt.getDayOfWeek();
			if (dayOfWeek == DayOfWeek.MONDAY || dayOfWeek == DayOfWeek.SUNDAY) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @see com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotRegistrarService#register(com.csoftz.ceiba.java.learn.parking.domain.Vehicle)
	 */
	@Override
	public int register(Vehicle vehicle) {
		if (vehicle == null) {
			return PARKING_LOT_REGISTRAR_INVALID_ARGUMENT;
		}

		return PARKING_LOT_REGISTRAR_OK;
	}
}
