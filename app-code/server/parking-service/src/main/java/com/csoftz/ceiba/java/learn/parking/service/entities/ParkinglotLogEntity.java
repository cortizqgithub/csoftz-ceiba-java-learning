/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTLOGENTITY.JAVA                                    */
/* Description:   Domain definition to manipulate Parking-lot Log objects     */
/*                (Entity).                                                   */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.04/2017                                                 */
/* Last Modified: Oct.12/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.04/2017 COQ  File created.
 -----------------------------------------------------------------------------*/

package com.csoftz.ceiba.java.learn.parking.service.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Domain definition to manipulate Parking-lot Log objects (Entity). <br>
 * <br>
 * Its purpose is to hold information about all of the activity in the
 * Parking-lot.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.12/2017
 * @since 1.8 (JDK), Oct.04/2017
 */

@Entity
@Table(name = "parking_lot_log")
public class ParkinglotLogEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String plate;

	@Column(name = "vehicle_type", nullable = false)
	private int vehicleType;

	@Column(name = "admission_date", nullable = false)
	private LocalDateTime admissionDate;

	@Column(name = "departure_date", nullable = true)
	private LocalDateTime departureDate;

	/**
	 * Default constructor.
	 */
	public ParkinglotLogEntity() {
		this.id = 0L;
		this.plate = "";
		this.vehicleType = 0;
		this.admissionDate = LocalDateTime.MIN;
		this.departureDate = LocalDateTime.MIN;
	}

	/**
	 * Constructor with parameters.
	 * 
	 * @param id
	 *            Identification of object
	 * @param plate
	 *            Description of the Vehicle
	 * @param vehicleType
	 *            Holds 1:Car, 2:Motorcycle.
	 * @param admissionDate
	 *            Date/Time when vehicle entered the Parkinglot.
	 * @param departureDate
	 *            Date/Time when vehicle left the Parkinglot.
	 */
	public ParkinglotLogEntity(Long id, String plate, int vehicleType, LocalDateTime admissionDate,
			LocalDateTime departureDate) {
		super();
		this.id = id;
		this.plate = plate;
		this.vehicleType = vehicleType;
		this.admissionDate = admissionDate;
		this.departureDate = departureDate;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(id).append(plate).append(vehicleType).append(admissionDate)
				.append(departureDate).toHashCode();
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

		ParkinglotLogEntity other = (ParkinglotLogEntity) obj;
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
		return "ParkinglotLogEntity [id=" + id + ", plate=" + plate + ", vehicleType=" + vehicleType
				+ ", admissionDate=" + admissionDate + ", departureDate=" + departureDate + "]";
	}

}
