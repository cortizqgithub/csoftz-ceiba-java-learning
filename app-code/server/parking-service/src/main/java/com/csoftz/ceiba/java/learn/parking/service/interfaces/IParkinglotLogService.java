/*----------------------------------------------------------------------------*/
/* Source File:   IPARKINGLOTLOGSERVICE.JAVA                                  */
/* Description:   Contract to show parkinglot log activities.                 */
/* Author:        Carlos Adolfo Ortiz Quir�s (COQ)                            */
/* Date:          Oct.06/2017                                                 */
/* Last Modified: Oct.09/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.06/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.ceiba.java.learn.parking.service.interfaces;

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotLog;
import com.csoftz.ceiba.java.learn.parking.domain.Vehicle;

/**
 * Contract to show parkinglot log activities.
 *
 * @author Carlos Adolfo Ortiz Quir�s (COQ)
 * @version 1.1, Oct.06/2017
 * @since 1.8 (JDK), Oct.06/2017
 */
public interface IParkinglotLogService {

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