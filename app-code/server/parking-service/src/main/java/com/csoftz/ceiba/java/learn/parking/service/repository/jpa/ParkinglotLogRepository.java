/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTLOGREPOSITORY.JAVA                                */
/* Description:   Implements JPA Repository for ParkinglotLog domain.         */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.10/2017                                                 */
/* Last Modified: Oct.10/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.09/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.ceiba.java.learn.parking.service.repository.jpa;

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotLog;
import com.csoftz.ceiba.java.learn.parking.domain.Vehicle;
import com.csoftz.ceiba.java.learn.parking.service.repository.interfaces.IParkinglotLogRepository;

/**
 * Implements JPA Repository for ParkinglotLog domain.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.10/2017
 * @since 1.8 (JDK), Oct.10/2017
 */
public class ParkinglotLogRepository implements IParkinglotLogRepository {

	@Override
	public ParkinglotLog save(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}
}