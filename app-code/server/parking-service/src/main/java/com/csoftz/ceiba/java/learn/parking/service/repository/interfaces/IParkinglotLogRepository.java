/*----------------------------------------------------------------------------*/
/* Source File:   IPARKINGLOTLOGREPOSITORY.JAVA                               */
/* Description:   Parking lot Log Repository contract for accessing           */
/*                ParkinglotLogEntity entity objects.                         */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.06/2017                                                 */
/* Last Modified: Oct.10/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.06/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.ceiba.java.learn.parking.service.repository.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.csoftz.ceiba.java.learn.parking.service.entities.ParkinglotLogEntity;

/**
 * Parking lot Log Repository contract for accessing ParkinglotLogEntity entity
 * objects. <br>
 * <b>NOTE:<b> Delegates to Spring Data JPA framework.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.09/2017
 * @since 1.8 (JDK), Oct.10/2017
 */
@Repository
public interface IParkinglotLogRepository extends CrudRepository<ParkinglotLogEntity, Long> {
}