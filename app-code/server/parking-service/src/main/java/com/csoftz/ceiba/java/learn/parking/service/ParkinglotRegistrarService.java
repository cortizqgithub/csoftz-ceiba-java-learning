/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTREGISTRARSERVICE.JAVA                             */
/* Description:   Implements contract for registration duties.                */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.06/2017                                                 */
/* Last Modified: Oct.09/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.06/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.ceiba.java.learn.parking.service;

import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_CAR_CAPACITY;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_MOTORCYCLE_CAPACITY;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_PLATE_START_WITH_A;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_TYPE_CAR;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_TYPE_MOTORCYCLE;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_INVALID_ARGUMENT;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_OK;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_ALREADY_IN_CELL;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_CAR_CAPACITY_FULL;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_CELL_NOT_ASSIGNED;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_LOG_FAILURE;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_MOTORCYCLE_CAPACITY_FULL;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotCellInfo;
import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotLog;
import com.csoftz.ceiba.java.learn.parking.domain.Vehicle;
import com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotCellInfoService;
import com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotLogService;
import com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotRegistrarService;

/**
 * Implements contract for registration duties.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.09/2017
 * @since 1.8 (JDK), Oct.06/2017
 */
@Service
public class ParkinglotRegistrarService implements IParkinglotRegistrarService {
	/*
	 * Dependencies
	 */
	private IParkinglotCellInfoService parkingCellInfoService;
	private IParkinglotLogService parkinglotLogService;

	/**
	 * Constructor
	 * 
	 * @param parkingCellInfoService
	 *            Inject a parking cell info service.
	 * @param parkinglotLogService
	 *            Inject a Parking lot Log Service
	 */
	public ParkinglotRegistrarService(IParkinglotCellInfoService parkingCellInfoService,
			IParkinglotLogService parkinglotLogService) {
		this.parkingCellInfoService = parkingCellInfoService;
		this.parkinglotLogService = parkinglotLogService;
	}

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

		// Steps required to make a registration.
		// 1. Vehicle Plate is not already present in Parking-Lot.
		ParkinglotCellInfo parkinglotCellInfo = parkingCellInfoService.findParkinglotCellInfo(vehicle.getPlate(),
				vehicle.getType());
		if (parkinglotCellInfo != null) {
			return PARKING_LOT_REGISTRAR_VEHICLE_ALREADY_IN_CELL;
		}

		// 2. Parking lot has capacity for vehicle type.
		int vehicleType = vehicle.getType();
		int vehicleSlotCapacitySoFar = parkingCellInfoService.takeCapacityFor(vehicleType);
		if (vehicleType == VEHICLE_TYPE_CAR) {
			if (vehicleSlotCapacitySoFar == VEHICLE_CAR_CAPACITY) {
				return PARKING_LOT_REGISTRAR_VEHICLE_CAR_CAPACITY_FULL;
			}
		}
		if (vehicleType == VEHICLE_TYPE_MOTORCYCLE) {
			if (vehicleSlotCapacitySoFar == VEHICLE_MOTORCYCLE_CAPACITY) {
				return PARKING_LOT_REGISTRAR_VEHICLE_MOTORCYCLE_CAPACITY_FULL;
			}
		}

		// 3. Make a cell reservation for supplied vehicle type.
		parkinglotCellInfo = parkingCellInfoService.assign(vehicle.getPlate(), vehicle.getType());
		if (parkinglotCellInfo == null) {
			return PARKING_LOT_REGISTRAR_VEHICLE_CELL_NOT_ASSIGNED;
		} else {
			ParkinglotLog parkinglotLog = parkinglotLogService.save(vehicle);
			if (parkinglotLog == null) {
				return PARKING_LOT_REGISTRAR_VEHICLE_LOG_FAILURE;
			}
		}

		return PARKING_LOT_REGISTRAR_OK;
	}
}