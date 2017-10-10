/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTCELLINFOREPOSITORY.JAVA                           */
/* Description:   Implements JPA repository for ParkingLotCellInfo domain.     */
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

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotCellInfo;
import com.csoftz.ceiba.java.learn.parking.service.repository.interfaces.IParkinglotCellInfoRepository;

/**
 * Implements JPA repository for ParkingLotCellInfo domain.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.10/2017
 * @since 1.8 (JDK), Oct.10/2017
 */
public class ParkinglotCellInfoRepository implements IParkinglotCellInfoRepository {

	@Override
	public ParkinglotCellInfo find(String plate, int vehicleType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int takeCapacityFor(int vehicleType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ParkinglotCellInfo assign(String plate, int vehicleType) {
		// TODO Auto-generated method stub
		return null;
	}

}
