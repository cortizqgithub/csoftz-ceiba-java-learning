/*----------------------------------------------------------------------------*/
/* Source File:   VEHICLE.JAVA                                                */
/* Description:   Domain definition to manipulate Vehicle objects.            */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.03/2017                                                 */
/* Last Modified: Oct.11/2017                                                 */
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
 * Domain definition to manipulate Vehicle objects.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.11/2017
 * @since 1.8 (JDK), Oct.03/2017
 */
public class Vehicle {
	private Long id;
	private String plate;
	private int type;
	private int cylinder;

	/**
	 * Default constructor.
	 */
	public Vehicle() {
		this.id = 0L;
		this.plate = "";
		this.type = 0;
		this.cylinder = 0;
	}

	/**
	 * Constructor with fields
	 * 
	 * @param id
	 *            Identifier to the object
	 * @param plate
	 *            Description of the Vehicle
	 * @param type
	 *            Holds 1:Car, 2:Motorcycle.
	 * @param cylinder
	 *            It is -1 for car, otherwise it is for motorcycle.
	 */
	public Vehicle(Long id, String plate, int type, int cylinder) {
		super();
		this.id = id;
		this.plate = plate;
		this.type = type;
		this.cylinder = cylinder;
	}

	/**
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cylinder;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((plate == null) ? 0 : plate.hashCode());
		result = prime * result + type;
		return result;
	}

	/**
	 * 
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
		Vehicle other = (Vehicle) obj;
		return new EqualsBuilder().appendSuper(super.equals(obj)).append(id, other.id).append(plate, other.plate)
				.append(type, other.type).append(cylinder, other.cylinder).isEquals();
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
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the cylinder
	 */
	public int getCylinder() {
		return cylinder;
	}

	/**
	 * @param cylinder
	 *            the cylinder to set
	 */
	public void setCylinder(int cylinder) {
		this.cylinder = cylinder;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", plate=" + plate + ", type=" + type + ", cylinder=" + cylinder + "]";
	}

}
