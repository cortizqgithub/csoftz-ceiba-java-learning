/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTREGISTEROPCODES.JAVA                              */
/* Description:   Defines the operation codes used in the parking lot         */
/*                registration process.                                       */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.06/2017                                                 */
/* Last Modified: Oct.11/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.06/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.ceiba.java.learn.parking.commons.consts;

/**
 * Defines the operation codes used in the parking lot registration process.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.11/2017
 * @since 1.8 (JDK), Oct.06/2017
 */
public class ParkinglotRegisterOpCodeConstants {

	//
	public static final int PARKING_LOT_REGISTRAR_INVALID_ARGUMENT = -1;

	// OP Code to indicate a success in the registration process.
	public static final int PARKING_LOT_REGISTRAR_OK = 100;
	public static final int PARKING_LOT_REGISTRAR_VEHICLE_ALREADY_IN_CELL = PARKING_LOT_REGISTRAR_OK + 1;
	public static final int PARKING_LOT_REGISTRAR_VEHICLE_CAR_CAPACITY_FULL = PARKING_LOT_REGISTRAR_OK + 2;
	public static final int PARKING_LOT_REGISTRAR_VEHICLE_MOTORCYCLE_CAPACITY_FULL = PARKING_LOT_REGISTRAR_OK + 3;
	public static final int PARKING_LOT_REGISTRAR_VEHICLE_CELL_NOT_ASSIGNED = PARKING_LOT_REGISTRAR_OK + 4;
	public static final int PARKING_LOT_REGISTRAR_VEHICLE_LOG_FAILURE = PARKING_LOT_REGISTRAR_OK + 5;
	public static final int PARKING_LOT_REGISTRAR_VEHICLE_INVALID_TYPE = PARKING_LOT_REGISTRAR_OK + 6;
	public static final int PARKING_LOT_REGISTRAR_VEHICLE_CANNOT_ENTER = PARKING_LOT_REGISTRAR_OK + 7;

	// Op Codes descriptions
	public static final String PARKING_LOT_REGISTRAR_OK_DESCRIPTION = "OK";
	public static final String PARKING_LOT_REGISTRAR_VEHICLE_ALREADY_IN_CELL_DESCRIPTION = "Vehicle already in cell description";
	public static final String PARKING_LOT_REGISTRAR_VEHICLE_CAR_CAPACITY_FULL_DESCRIPTION = "Car capacity is full";
	public static final String PARKING_LOT_REGISTRAR_VEHICLE_MOTORCYCLE_CAPACITY_FULL_DESCRIPTION = "Motorcycle capacity is full";
	public static final String PARKING_LOT_REGISTRAR_VEHICLE_CELL_NOT_ASSIGNED_DESCRIPTION = "Vehicle cell not assigned";
	public static final String PARKING_LOT_REGISTRAR_VEHICLE_LOG_FAILURE_DESCRIPTION = "Vehicle log failure";
	public static final String PARKING_LOT_REGISTRAR_VEHICLE_INVALID_TYPE_DESCRIPTION = "Vehicle Type is not allowed to enter, only Cars or Motorcycles";
	public static final String PARKING_LOT_REGISTRAR_VEHICLE_CANNOT_ENTER_DESCRIPTION = "Car/Motorcycle with plate starting in 'A' cannot enter on Mondays/Sundays";

	/**
	 * Defined to make SonarLint compliant.
	 */
	private ParkinglotRegisterOpCodeConstants() {
		throw new IllegalStateException("Utility class");
	}
}