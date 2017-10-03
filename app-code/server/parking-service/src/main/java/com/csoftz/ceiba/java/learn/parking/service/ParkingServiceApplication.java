/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGSERVICEAPPLICATIONTESTS.JAVA                         */
/* Description:   Parking Service (REST API) Application                      */
/* Author:        Carlos Adolfo Ortiz Quir�s (COQ)                            */
/* Date:          Sep.22/2017                                                 */
/* Last Modified: Oct.03/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Sep.22/2017 COQ  File created.
 -----------------------------------------------------------------------------*/

package com.csoftz.ceiba.java.learn.parking.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Parking Service (REST API) Application 
 *
 * @author Carlos Adolfo Ortiz Quir�s (COQ)
 * @version 1.1, Sep.22/2017
 * @since 1.8 (JDK), Sep.22/2017
 */

@SpringBootApplication
public class ParkingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingServiceApplication.class, args);
	}
}
