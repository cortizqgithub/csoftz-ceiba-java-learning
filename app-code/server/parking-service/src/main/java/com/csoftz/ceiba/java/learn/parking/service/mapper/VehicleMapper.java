/*----------------------------------------------------------------------------*/
/* Source File:   VEHICLEMAPPER.JAVA                                          */
/* Description:   Converts from Domain to Entity objects.                     */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.04/2017                                                 */
/* Last Modified: Oct.05/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.04/2017 COQ  File created.
 -----------------------------------------------------------------------------*/

package com.csoftz.ceiba.java.learn.parking.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.csoftz.ceiba.java.learn.parking.domain.Vehicle;
import com.csoftz.ceiba.java.learn.parking.service.entities.VehicleEntity;

/**
 * Converts from Domain to Entity objects.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.05/2017
 * @since 1.8 (JDK), Oct.04/2017
 */
@Component
public class VehicleMapper {

	/**
	 * Puts data from an entity object to a domain object.
	 * 
	 * @param info
	 *            Source data
	 * @return A Vehicle object. NULL if source is NULL.
	 */
	public Vehicle vehicleEntityToVehicle(VehicleEntity info) {
		if (info == null) {
			return null;
		} else {
			Vehicle vehicle = new Vehicle(info.getId(), info.getPlate(), info.getType(), info.getCylinder());
			return vehicle;
		}
	}

	/**
	 * Puts data from a domain object into an entity object.
	 * 
	 * @param info
	 *            Source data
	 * @return A VehicleEntity object. NULL if source is NULL.
	 */
	public VehicleEntity vehicleToVehicleEntity(Vehicle info) {
		if (info == null) {
			return null;
		} else {
			VehicleEntity vehicleEntity = new VehicleEntity(info.getId(), info.getPlate(), info.getType(),
					info.getCylinder());
			return vehicleEntity;
		}
	}

	/**
	 * Maps a list of Vehicles to VehicleEntities objects
	 * 
	 * @param vehicles
	 *            Source data.
	 * @return List of VehicleEntities.
	 */
	public List<VehicleEntity> vehiclesToVehicleEntities(List<Vehicle> vehicles) {
		return vehicles.stream().filter(Objects::nonNull).map(this::vehicleToVehicleEntity)
				.collect(Collectors.toList());
	}

	/**
	 * Maps a list of VehicleEntities to Vehicles
	 * 
	 * @param vehicleEntities
	 *            Source Data
	 * @return List of Vehicles.
	 */
	public List<Vehicle> vehicleEntitiesToVehicles(List<VehicleEntity> vehicleEntities) {
		return vehicleEntities.stream().filter(Objects::nonNull).map(this::vehicleEntityToVehicle)
				.collect(Collectors.toList());
	}

}