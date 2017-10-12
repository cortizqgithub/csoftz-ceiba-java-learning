/*----------------------------------------------------------------------------*/
/* Source File:   UTILHELPER.JAVA                                             */
/* Description:   Helper utilities for project.                               */
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
package com.csoftz.ceiba.java.learn.parking.commons.helper;

import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_OK;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_OK_DESCRIPTION;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_ALREADY_IN_CELL;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_ALREADY_IN_CELL_DESCRIPTION;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_CANNOT_ENTER;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_CANNOT_ENTER_DESCRIPTION;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_CAR_CAPACITY_FULL;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_CAR_CAPACITY_FULL_DESCRIPTION;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_CELL_NOT_ASSIGNED;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_CELL_NOT_ASSIGNED_DESCRIPTION;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_INVALID_TYPE;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_INVALID_TYPE_DESCRIPTION;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_LOG_FAILURE;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_LOG_FAILURE_DESCRIPTION;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_MOTORCYCLE_CAPACITY_FULL;
import static com.csoftz.ceiba.java.learn.parking.commons.consts.ParkinglotRegisterOpCodeConstants.PARKING_LOT_REGISTRAR_VEHICLE_MOTORCYCLE_CAPACITY_FULL_DESCRIPTION;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Helper utilities for project.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.11/2017
 * @since 1.8 (JDK), Oct.11/2017
 */
public class UtilHelper {

	/**
	 * Serializes to JSON format the given object.
	 * 
	 * @param object
	 *            Data to serialize
	 * @return Object represented in JSON format.
	 * @throws IOException
	 */
	public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsBytes(object);
	}

	/**
	 * Given the op code, returns its description.
	 * 
	 * @param opCode
	 *            Number to describe.
	 * @return Description for given opCode.
	 */
	public static String mapOpCodeToDescription(int opCode) {
		String rslt = "";
		switch (opCode) {
		case PARKING_LOT_REGISTRAR_OK:
			rslt = PARKING_LOT_REGISTRAR_OK_DESCRIPTION;
			break;
		case PARKING_LOT_REGISTRAR_VEHICLE_ALREADY_IN_CELL:
			rslt = PARKING_LOT_REGISTRAR_VEHICLE_ALREADY_IN_CELL_DESCRIPTION;
			break;
		case PARKING_LOT_REGISTRAR_VEHICLE_CAR_CAPACITY_FULL:
			rslt = PARKING_LOT_REGISTRAR_VEHICLE_CAR_CAPACITY_FULL_DESCRIPTION;
			break;
		case PARKING_LOT_REGISTRAR_VEHICLE_MOTORCYCLE_CAPACITY_FULL:
			rslt = PARKING_LOT_REGISTRAR_VEHICLE_MOTORCYCLE_CAPACITY_FULL_DESCRIPTION;
			break;
		case PARKING_LOT_REGISTRAR_VEHICLE_CELL_NOT_ASSIGNED:
			rslt = PARKING_LOT_REGISTRAR_VEHICLE_CELL_NOT_ASSIGNED_DESCRIPTION;
			break;
		case PARKING_LOT_REGISTRAR_VEHICLE_LOG_FAILURE:
			rslt = PARKING_LOT_REGISTRAR_VEHICLE_LOG_FAILURE_DESCRIPTION;
			break;
		case PARKING_LOT_REGISTRAR_VEHICLE_INVALID_TYPE:
			rslt = PARKING_LOT_REGISTRAR_VEHICLE_INVALID_TYPE_DESCRIPTION;
			break;
		case PARKING_LOT_REGISTRAR_VEHICLE_CANNOT_ENTER:
			rslt = PARKING_LOT_REGISTRAR_VEHICLE_CANNOT_ENTER_DESCRIPTION;
			break;
		default:
			rslt = "";
			break;
		}
		return rslt;
	}

	/**
	 * To make Sonar Compliant.
	 */
	private UtilHelper() {
		throw new IllegalStateException("Utility class");
	}
}
