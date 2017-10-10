/*----------------------------------------------------------------------------*/
/* Source File:   IPARKINGLOTLOGREPOSITORY.JAVA                               */
/* Description:   Parking lot Log Repository contract for accessing           */
/*                ParkinglotLogEntity entity objects.                         */
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
package com.csoftz.ceiba.java.learn.parking.service.repository.interfaces;

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotLog;
import com.csoftz.ceiba.java.learn.parking.domain.Vehicle;

/**
 * Parking lot Log Repository contract for accessing ParkinglotLogEntity entity
 * objects.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.09/2017
 * @since 1.8 (JDK), Oct.06/2017
 */
public interface IParkinglotLogRepository {
	/**
	 * When a vehicle is allowed to enter the parking lot, a record of this event is
	 * logged in the ParkinglotLog domain object.
	 * 
	 * @param vehicle
	 *            Information to record.
	 * @return A ParkinglotLog domain object indicating a success operation, NULL
	 *         otherwise.
	 */
	public ParkinglotLog save(Vehicle vehicle);
}
