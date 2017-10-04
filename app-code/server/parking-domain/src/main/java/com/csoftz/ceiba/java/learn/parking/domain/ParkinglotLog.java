/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTLOG.JAVA                                          */
/* Description:   Domain definition to manipulate Parking-lot Log objects.    */
/* Author:        Carlos Adolfo Ortiz Quir�s (COQ)                            */
/* Date:          Oct.03/2017                                                 */
/* Last Modified: Oct.04/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.03/2017 COQ  File created.
 -----------------------------------------------------------------------------*/

package com.csoftz.ceiba.java.learn.parking.domain;

import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Domain definition to manipulate Parking-lot Log objects. <br>
 * <br>
 * Its purpose is to hold information about all of the activity in the
 * Parking-lot.
 *
 * @author Carlos Adolfo Ortiz Quir�s (COQ)
 * @version 1.1, Oct.04/2017
 * @since 1.8 (JDK), Oct.03/2017
 */
public class ParkinglotLog {
	private Long id;
	private String plate;
	private int vehicleType;
	private LocalDateTime admissionDate;
	private LocalDateTime departureDate;

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admissionDate == null) ? 0 : admissionDate.hashCode());
		result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((plate == null) ? 0 : plate.hashCode());
		result = prime * result + vehicleType;
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		ParkinglotLog other = (ParkinglotLog) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(id, other.id).append(plate, other.plate)
				.append(vehicleType, other.vehicleType).append(admissionDate, other.admissionDate)
				.append(departureDate, other.departureDate).isEquals();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * @return the admissionDate
	 */
	public LocalDateTime getAdmissionDate() {
		return admissionDate;
	}

	/**
	 * @param admissionDate
	 *            the admissionDate to set
	 */
	public void setAdmissionDate(LocalDateTime admissionDate) {
		this.admissionDate = admissionDate;
	}

	/**
	 * @return the departureDate
	 */
	public LocalDateTime getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param departureDate
	 *            the departureDate to set
	 */
	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ParkinglotLog [id=" + id + ", plate=" + plate + ", vehicleType=" + vehicleType + ", admissionDate="
				+ admissionDate + ", departureDate=" + departureDate + "]";
	}

}