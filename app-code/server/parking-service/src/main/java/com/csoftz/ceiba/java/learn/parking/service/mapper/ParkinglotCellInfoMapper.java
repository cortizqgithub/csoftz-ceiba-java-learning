/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTCELLINFOMAPPER.JAVA                               */
/* Description:   Converts from Domain to Entity objects.                     */
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

package com.csoftz.ceiba.java.learn.parking.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotCellInfo;
import com.csoftz.ceiba.java.learn.parking.service.entities.ParkinglotCellInfoEntity;

/**
 * Converts from Domain to Entity objects.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.12/2017
 * @since 1.8 (JDK), Oct.04/2017
 */
@Component
public class ParkinglotCellInfoMapper {

	/**
	 * Puts data from an entity object to a domain object.
	 * 
	 * @param info
	 *            Source data
	 * @return A ParkinglotCellInfo object. NULL if source is NULL.
	 */
	public ParkinglotCellInfo parkinglotCellInfoEntityToParkinglotCellInfo(ParkinglotCellInfoEntity info) {
		if (info == null) {
			return null;
		} else {
			return new ParkinglotCellInfo(info.getPlate(), info.getVehicleType());
		}
	}

	/**
	 * Puts data from a domain object into an entity object.
	 * 
	 * @param info
	 *            Source data
	 * @return A ParkinglotCellInfoEntity object. NULL if source is NULL.
	 */
	public ParkinglotCellInfoEntity parkinglotCellInfoToParkinglotCellInfoEntity(ParkinglotCellInfo info) {
		if (info == null) {
			return null;
		} else {
			return new ParkinglotCellInfoEntity(info.getPlate(), info.getVehicleType());
		}
	}

	/**
	 * Maps a list of ParkinglotCellInfos to ParkinglotCellInfoEntities objects
	 * 
	 * @param parkinglotCellInfos
	 *            Source data.
	 * @return List of ParkinglotCellInfoEntities.
	 */
	public List<ParkinglotCellInfoEntity> parkinglotCellInfosToParkinglotCellInfoEntities(
			List<ParkinglotCellInfo> parkinglotCellInfos) {
		return parkinglotCellInfos.stream().filter(Objects::nonNull)
				.map(this::parkinglotCellInfoToParkinglotCellInfoEntity).collect(Collectors.toList());
	}

	/**
	 * Maps a list of ParkinglotCellInfoEntities to ParkinglotCellInfos
	 * 
	 * @param parkinglotCellInfoEntities
	 *            Source Data
	 * @return List of ParkinglotCellInfos.
	 */
	public List<ParkinglotCellInfo> parkinglotCellInfoEntitiesToParkinglotCellInfos(
			List<ParkinglotCellInfoEntity> parkinglotCellInfoEntities) {
		return parkinglotCellInfoEntities.stream().filter(Objects::nonNull)
				.map(this::parkinglotCellInfoEntityToParkinglotCellInfo).collect(Collectors.toList());
	}
}