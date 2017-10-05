/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTCONFIGMAPPER.JAVA                                 */
/* Description:   Converts from Domain to Entity objects.                     */
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
 * @author Carlos Adolfo Ortiz Quir�s (COQ)
 * @version 1.1, Oct.05/2017
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
	public ParkinglotConfig ParkinglotConfigEntityToParkinglotConfig(ParkinglotConfigEntity info) {
		if (info == null) {
			return null;
		} else {
			ParkinglotConfig parkinglotConfig = new ParkinglotConfig(info.getId(), info.getName(), info.getValue(),
					info.getDescription());
			return parkinglotConfig;
		}
	}

	/**
	 * Puts data from a domain object into an entity object.
	 * 
	 * @param info
	 *            Source data
	 * @return A ParkinglotConfigEntity object. NULL if source is NULL.
	 */
	public ParkinglotConfigEntity ParkinglotConfigToParkinglotConfigEntity(ParkinglotConfig info) {
		if (info == null) {
			return null;
		} else {
			ParkinglotConfigEntity parkinglotConfigEntity = new ParkinglotConfigEntity(info.getId(), info.getName(),
					info.getValue(), info.getDescription());
			return parkinglotConfigEntity;
		}
	}

	/**
	 * Maps a list of ParkinglotConfigs to ParkinglotConfigEntities objects
	 * 
	 * @param ParkinglotConfigs
	 *            Source data.
	 * @return List of ParkinglotConfigEntities.
	 */
	public List<ParkinglotConfigEntity> ParkinglotConfigsToParkinglotConfigEntities(
			List<ParkinglotConfig> ParkinglotConfigs) {
		return ParkinglotConfigs.stream().filter(Objects::nonNull).map(this::ParkinglotConfigToParkinglotConfigEntity)
				.collect(Collectors.toList());
	}

	/**
	 * Maps a list of ParkinglotConfigEntities to ParkinglotConfigs
	 * 
	 * @param ParkinglotConfigEntities
	 *            Source Data
	 * @return List of ParkinglotConfigs.
	 */
	public List<ParkinglotConfig> ParkinglotConfigEntitiesToParkinglotConfigs(
			List<ParkinglotConfigEntity> ParkinglotConfigEntities) {
		return ParkinglotConfigEntities.stream().filter(Objects::nonNull)
				.map(this::ParkinglotConfigEntityToParkinglotConfig).collect(Collectors.toList());
	}

}
