/*----------------------------------------------------------------------------*/
/* Source File:   VEHICLEENTITY.JAVA                                          */
/* Description:   Domain definition to manipulate Vehicle objects (Entity).   */
/* Author:        Carlos Adolfo Ortiz Quir�s (COQ)                            */
/* Date:          Oct.04/2017                                                 */
/* Last Modified: Oct.05/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.04/2017 COQ  File created.
 -----------------------------------------------------------------------------*/

package com.csoftz.ceiba.java.learn.parking.service.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * Domain definition to manipulate Vehicle objects (Entity).
 *
 * @author Carlos Adolfo Ortiz Quir�s (COQ)
 * @version 1.1, Oct.05/2017
 * @since 1.8 (JDK), Oct.04/2017
 */

@Entity
@Table(name = "vehicle")
public class VehicleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true)
	private String plate;

	@Column(nullable = false)
	private int type;

	@Column(nullable = false)
	private int cylinder;

	/**
	 * Constructor with fields
	 * 
	 * @param id
	 *            Identifier to the object.
	 * @param plate
	 *            Description of the Vehicle.
	 * @param type
	 *            Holds 1:Car, 2:Motorcycle.
	 * @param cylinder
	 *            It is -1 for car, otherwise it is for motorcycle.
	 */
	public VehicleEntity(Long id, String plate, int type, int cylinder) {
		super();
		this.id = id;
		this.plate = plate;
		this.type = type;
		this.cylinder = cylinder;
	}

	/**
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
		VehicleEntity other = (VehicleEntity) obj;
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
		return "VehicleEntity [id=" + id + ", plate=" + plate + ", type=" + type + ", cylinder=" + cylinder + "]";
	}

}
