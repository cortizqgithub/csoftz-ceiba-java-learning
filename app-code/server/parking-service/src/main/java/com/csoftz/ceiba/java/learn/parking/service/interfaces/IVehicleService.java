/*----------------------------------------------------------------------------*/
/* Source File:   IVEHICLESERVICE.JAVA                                        */
/* Description:   Vehicle Service contract to access Vehicle domain objects.  */
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

import com.csoftz.ceiba.java.learn.parking.domain.Vehicle;

/**
 * Vehicle Service contract to access Vehicle domain objects.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.06/2017
 * @since 1.8 (JDK), Oct.06/2017
 */
public interface IVehicleService {

	/**
	 * Locates a record with given id.
	 * 
	 * @param id
	 *            Identifier of the Vehicle to find.
	 * @return Null reference if not found.
	 */
	Vehicle findVehicle(Long id);
}