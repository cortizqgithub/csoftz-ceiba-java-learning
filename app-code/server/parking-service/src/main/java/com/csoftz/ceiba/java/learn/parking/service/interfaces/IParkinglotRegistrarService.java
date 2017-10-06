/*----------------------------------------------------------------------------*/
/* Source File:   IPARKINGLOTREGISTRARSERVICE.JAVA                            */
/* Description:   Contract for registration duties.                           */
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
package com.csoftz.ceiba.java.learn.parking.service.interfaces;

import java.time.LocalDateTime;

import com.csoftz.ceiba.java.learn.parking.domain.Vehicle;

/**
 * Contract for registration duties.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.06/2017
 * @since 1.8 (JDK), Oct.06/2017
 */
public interface IParkinglotRegistrarService {

	/**
	 * Checks if a vehicle is a car or a motorcycle.
	 * 
	 * @param vehicle
	 *            Info to check.
	 * @return true if car or motorcycle. Otherwise false.
	 */
	boolean isValid(Vehicle vehicle);

	/**
	 * Checks for the vehicle's plates to start with "A" and if so it must check
	 * that if day of week is a Monday or a Sunday then Vehicle should not be
	 * allowed to enter.
	 * 
	 * @param vehicle
	 *            Information to check.
	 * @param dt
	 *            A LocalDateTime object for the date to check.
	 * @see LocalDateTime
	 * @return true if plate does not start with an "A" and it is not Monday or
	 *         Sunday.
	 */
	boolean isValidPlate(Vehicle vehicle, LocalDateTime dt);

	/**
	 * When a Vehicle which is a Car or a Motorcycle wants to enter the parking lot,
	 * it is registered and the assigned a cell to manage the parking lot
	 * occupation.
	 * 
	 * @param vehicle
	 *            Required information to process a vehicle registration.
	 * @return A status code for the operation.
	 */
	int register(Vehicle vehicle);
}
