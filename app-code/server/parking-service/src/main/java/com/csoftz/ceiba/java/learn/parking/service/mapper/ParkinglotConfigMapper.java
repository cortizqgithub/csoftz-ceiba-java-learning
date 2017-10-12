/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTCONFIGMAPPER.JAVA                                 */
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

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotConfig;
import com.csoftz.ceiba.java.learn.parking.service.entities.ParkinglotConfigEntity;

/**
 * Converts from Domain to Entity objects.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.12/2017
 * @since 1.8 (JDK), Oct.04/2017
 */
@Component
public class ParkinglotConfigMapper {
	/**
	 * Puts data from an entity object to a domain object.
	 * 
	 * @param info
	 *            Source data
	 * @return A ParkinglotConfig object. NULL if source is NULL.
	 */
	public ParkinglotConfig parkinglotConfigEntityToParkinglotConfig(ParkinglotConfigEntity info) {
		if (info == null) {
			return null;
		} else {
			return new ParkinglotConfig(info.getId(), info.getName(), info.getValue(), info.getDescription());
		}
	}

	/**
	 * Puts data from a domain object into an entity object.
	 * 
	 * @param info
	 *            Source data
	 * @return A ParkinglotConfigEntity object. NULL if source is NULL.
	 */
	public ParkinglotConfigEntity parkinglotConfigToParkinglotConfigEntity(ParkinglotConfig info) {
		if (info == null) {
			return null;
		} else {
			return new ParkinglotConfigEntity(info.getId(), info.getName(), info.getValue(), info.getDescription());
		}
	}

	/**
	 * Maps a list of ParkinglotConfigs to ParkinglotConfigEntities objects
	 * 
	 * @param parkinglotConfigs
	 *            Source data.
	 * @return List of ParkinglotConfigEntities.
	 */
	public List<ParkinglotConfigEntity> parkinglotConfigsToParkinglotConfigEntities(
			List<ParkinglotConfig> parkinglotConfigs) {
		return parkinglotConfigs.stream().filter(Objects::nonNull).map(this::parkinglotConfigToParkinglotConfigEntity)
				.collect(Collectors.toList());
	}

	/**
	 * Maps a list of ParkinglotConfigEntities to ParkinglotConfigs
	 * 
	 * @param parkinglotConfigEntities
	 *            Source Data
	 * @return List of ParkinglotConfigs.
	 */
	public List<ParkinglotConfig> parkinglotConfigEntitiesToParkinglotConfigs(
			List<ParkinglotConfigEntity> parkinglotConfigEntities) {
		return parkinglotConfigEntities.stream().filter(Objects::nonNull)
				.map(this::parkinglotConfigEntityToParkinglotConfig).collect(Collectors.toList());
	}
}
