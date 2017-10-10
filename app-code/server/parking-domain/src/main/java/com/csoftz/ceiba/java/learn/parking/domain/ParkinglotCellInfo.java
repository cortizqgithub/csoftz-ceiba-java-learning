/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTCELLINFO.JAVA                                     */
/* Description:   Domain definition to manipulate Parking-lot Cell objects.   */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.03/2017                                                 */
/* Last Modified: Oct.10/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.03/2017 COQ  File created.
 -----------------------------------------------------------------------------*/

package com.csoftz.ceiba.java.learn.parking.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Domain definition to manipulate Parking-lot Cell objects. <br>
 * <br>
 * The purpose is to define a cell being used by a Vehicle to control if used or
 * not.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.05/2017
 * @since 1.8 (JDK), Oct.10/2017
 */
public class ParkinglotCellInfo {
	private String plate;
	private int vehicleType;

	/**
	 * Constructor with fields.
	 * 
	 * @param plate
	 *            Description of the Vehicle.
	 * @param vehicleType
	 *            Holds 1:Car, 2:Motorcycle.
	 */
	public ParkinglotCellInfo(String plate, int vehicleType) {
		super();
		this.plate = plate;
		this.vehicleType = vehicleType;
	}

	/**
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
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(plate, other.plate)
				.append(vehicleType, other.vehicleType).isEquals();
	}

	/**
	 * @return the plate
	 */
	public String getPlate() {
		return plate;
	}

	/**
	 * @param plate
	 *            the plate to set
	 */
	public void setPlate(String plate) {
		this.plate = plate;
	}

	/**
	 * @return the vehicleType
	 */
	public int getVehicleType() {
		return vehicleType;
	}

	/**
	 * @param vehicleType
	 *            the vehicleType to set
	 */
	public void setVehicleType(int vehicleType) {
		this.vehicleType = vehicleType;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParkinglotCellInfo [plate=" + plate + ", vehicleType=" + vehicleType + "]";
	}

}