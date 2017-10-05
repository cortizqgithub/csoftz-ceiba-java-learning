/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGSERVICEAPPLICATIONTESTS.JAVA                         */
/* Description:   Parking Web Application                                     */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Sep.22/2017                                                 */
/* Last Modified: Oct.05/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Sep.22/2017 COQ  File created.
 -----------------------------------------------------------------------------*/

package com.csoftz.ceiba.java.learn.parking.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Parking Web Application Tests
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.05/2017
 * @since 1.8 (JDK), Sep.22/2017
 */
@SpringBootApplication
public class ParkingWebApplication {

	/**
	 * Entry point for Spring Boot App.
	 * 
	 * @param args
	 *            Command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ParkingWebApplication.class, args);
	}
}
