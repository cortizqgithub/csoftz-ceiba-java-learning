/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTCELLINFO.JAVA                                     */
/* Description:   Domain definition to manipulate Parking-lot Cell objects.   */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.03/2017                                                 */
/* Last Modified: Oct.03/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.03/2017 COQ  File created.
 -----------------------------------------------------------------------------*/

package com.csoftz.ceiba.java.learn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Domain definition to manipulate Parking-lot Cell objects. <br>
 * <br>
 * The purpose is to define a cell being used by a Vehicle to control if used or
 * not.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.03/2017
 * @since 1.8 (JDK), Oct.03/2017
 */

@Entity
@Table(name = "parking_lot_cell")
public class ParkinglotCellInfo {
	@Id
	private String plate;

	@Column(name = "vehicle_type")
	private int vehicleType;

	/**
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((plate == null) ? 0 : plate.hashCode());
		result = prime * result + vehicleType;
		return result;
	}

	/**
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ParkinglotCellInfo)) {
			return false;
		}
		ParkinglotCellInfo other = (ParkinglotCellInfo) obj;
		if (plate == null) {
			if (other.plate != null) {
				return false;
			}
		} else if (!plate.equals(other.plate)) {
			return false;
		}

		return (vehicleType == other.vehicleType);
	}

}