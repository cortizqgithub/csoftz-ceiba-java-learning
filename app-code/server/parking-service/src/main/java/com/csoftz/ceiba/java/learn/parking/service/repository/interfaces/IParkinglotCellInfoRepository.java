/*----------------------------------------------------------------------------*/
/* Source File:   IPARKINGLOTCELLINFOREPOSITORY.JAVA                          */
/* Description:   Parkinglot Cell Info repository contract for accessing      */
/*                ParkinglotCellInfoEntity entity objects.                    */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.09/2017                                                 */
/* Last Modified: Oct.10/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.09/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.ceiba.java.learn.parking.service.repository.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csoftz.ceiba.java.learn.parking.service.entities.ParkinglotCellInfoEntity;

/**
 * Parkinglot Cell Info repository contract for accessing
 * ParkinglotCellInfoEntity entity objects. <br>
 * <b>NOTE:<b> Delegates to Spring Data JPA framework.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.10/2017
 * @since 1.8 (JDK), Oct.09/2017
 */
@Repository
public interface IParkinglotCellInfoRepository extends CrudRepository<ParkinglotCellInfoEntity, Long> {
	/**
	 * Locates a parking lot cell info for plate/vehicleType key.
	 * 
	 * @param plate
	 *            Vehicle plate
	 * @param vehicleType
	 *            Holds 1:Car, 2:Motorcycle.
	 * @return Null if not found.
	 */
	public ParkinglotCellInfoEntity findByPlateAndVehicleType(String plate, int vehicleType);

	/**
	 * Looks for the capacity of cars or motorcycles. If Car is set, then the
	 * maximun allowed slots are 30 and if Motorcycle is set, then the maximun
	 * allows slots are 10.
	 * 
	 * @param vehicleType
	 *            Holds 1:Car, 2:Motorcycle.
	 * @return Number of slots actually used.
	 */
	public int countByVehicleType(int vehicleType);
}
