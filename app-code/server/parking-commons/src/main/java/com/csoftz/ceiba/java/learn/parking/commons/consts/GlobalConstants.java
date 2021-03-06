/*----------------------------------------------------------------------------*/
/* Source File:   GLOBALCONSTANTS.JAVA                                        */
/* Description:   General constants definitions.                              */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.05/2017                                                 */
/* Last Modified: Oct.11/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.05/2017 COQ  File created.
 -----------------------------------------------------------------------------*/

package com.csoftz.ceiba.java.learn.parking.commons.consts;

/**
 * General constants definitions. <br>
 * <br>
 * <b>NOTE<b>: Notice that some variables are mapped to the ParkinglotConfig
 * stored values. Read along javadocs for this class.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.11/2017
 * @since 1.8 (JDK), Oct.05/2017
 */
public class GlobalConstants {
	/*
	 * General
	 */
	public static final int VEHICLE_CAR_CAPACITY = 20;
	public static final int VEHICLE_MOTORCYCLE_CAPACITY = 10;
	public static final int VEHICLE_TYPE_CAR = 1;
	public static final int VEHICLE_TYPE_MOTORCYCLE = 2;
	public static final int VEHICLE_TYPE_OTHER = 3;

	public static final String VEHICLE_PLATE_START_WITH_A = "A";
	public static final String VEHICLE_CANNOT_ENTER_NOT_BUSINESS_DAY = "Vehicle cannot enter because it is not in a business day";

	/*
	 * FARE values. See Key values for configuration store.
	 */
	public static final int VEHICLE_CAR_FARE_HOUR = 1000;
	public static final int VEHICLE_CAR_FARE_DAY = 8000;
	public static final int VEHICLE_MOTORCYCLE_FARE_HOUR = 500;
	public static final int VEHICLE_MOTORCYCLE_FARE_DAY = 6000;
	public static final int VEHICLE_MOTORCYCLE_FARE_ADDITIONAL = 2000;

	/**
	 * This global constant is to be defined in a configuration store for
	 * Parkinglot. Use the key PARKINGLOG_FULL_CAPACITY.
	 */
	public static final int PARKINGLOG_FULL_CAPACITY = VEHICLE_CAR_CAPACITY + VEHICLE_MOTORCYCLE_CAPACITY;

	/**
	 * Following definitions are key values for configuration store values see
	 * ParkinglotConfig domain object.
	 */
	public static final String FULL_CAPACITY_KEY = "PARKINGLOG_FULL_CAPACITY";
	public static final String VEHICLE_CAR_FARE_HOUR_KEY = "VEHICLE_CAR_FARE_HOUR";
	public static final String VEHICLE_CAR_FARE_DAY_KEY = "VEHICLE_CAR_FARE_DAY";
	public static final String VEHICLE_MOTORCYCLE_FARE_HOUR_KEY = "VEHICLE_MOTORCYCLE_FARE_HOUR";
	public static final String VEHICLE_MOTORCYCLE_FARE_DAY_KEY = "VEHICLE_MOTORCYCLE_FARE_DAY";
	public static final String VEHICLE_MOTORCYCLE_FARE_ADDITIONAL_KEY = "VEHICLE_MOTORCYCLE_FARE_ADDITIONAL";
	public static final String VEHICLE_CANNOT_ENTER_NOT_BUSINESS_DAY_KEY = "VEHICLE_CANNOT_ENTER_NOT_BUSINESS_DAY";

	/**
	 * 
	 * Defined to make SonarLint compliant.
	 */
	private GlobalConstants() {
		throw new IllegalStateException("Utility class");
	}
}