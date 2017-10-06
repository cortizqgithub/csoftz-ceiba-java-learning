/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTREGISTEROPCODES.JAVA                              */
/* Description:   Defines the operation codes used in the parking lot         */
/*                registration process.                                       */
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
package com.csoftz.ceiba.java.learn.parking.commons.consts;

/**
 * Defines the operation codes used in the parking lot registration process.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.06/2017
 * @since 1.8 (JDK), Oct.06/2017
 */
public class ParkinglotRegisterOpCodeConstants {

	public static final int PARKING_LOT_REGISTRAR_INVALID_ARGUMENT = -1;

	// OP Code to indicate a success in the registration process.
	public static final int PARKING_LOT_REGISTRAR_OK = 100;

	/**
	 * Defined to make SonarLint compliant.
	 */
	private ParkinglotRegisterOpCodeConstants() {
		throw new IllegalStateException("Utility class");
	}
}
