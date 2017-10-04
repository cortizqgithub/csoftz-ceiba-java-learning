/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTLOGMAPPER.JAVA                                    */
/* Description:   Converts from Domain to Entity objects.                     */
/* Author:        Carlos Adolfo Ortiz Quir�s (COQ)                            */
/* Date:          Oct.04/2017                                                 */
/* Last Modified: Oct.04/2017                                                 */
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

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotLog;
import com.csoftz.ceiba.java.learn.parking.service.entities.ParkinglotLogEntity;

/**
 * Converts from Domain to Entity objects.
 *
 * @author Carlos Adolfo Ortiz Quir�s (COQ)
 * @version 1.1, Oct.04/2017
 * @since 1.8 (JDK), Oct.03/2017
 */
@Component
public class ParkinglotLogMapper {

	/**
	 * Puts data from an entity object to a domain object.
	 * 
	 * @param info
	 *            Source data
	 * @return A ParkinglotLog object. NULL if source is NULL.
	 */
	public ParkinglotLog ParkinglotLogEntityToParkinglotLog(ParkinglotLogEntity info) {
		if (info == null) {
			return null;
		} else {
			ParkinglotLog parkinglotLog = new ParkinglotLog();

			// Fill data
			parkinglotLog.setId(info.getId());
			parkinglotLog.setPlate(info.getPlate());
			parkinglotLog.setVehicleType(info.getVehicleType());
			parkinglotLog.setAdmissionDate(info.getAdmissionDate());
			parkinglotLog.setDepartureDate(info.getDepartureDate());
			return parkinglotLog;
		}
	}

	/**
	 * Puts data from a domain object into an entity object.
	 * 
	 * @param info
	 *            Source data
	 * @return A ParkinglotLogEntity object. NULL if source is NULL.
	 */
	public ParkinglotLogEntity ParkinglotLogToParkinglotLogEntity(ParkinglotLog info) {
		if (info == null) {
			return null;
		} else {
			ParkinglotLogEntity parkinglotLogEntity = new ParkinglotLogEntity();

			// Fill data
			parkinglotLogEntity.setId(info.getId());
			parkinglotLogEntity.setPlate(info.getPlate());
			parkinglotLogEntity.setVehicleType(info.getVehicleType());
			parkinglotLogEntity.setAdmissionDate(info.getAdmissionDate());
			parkinglotLogEntity.setDepartureDate(info.getDepartureDate());
			return parkinglotLogEntity;
		}
	}

	/**
	 * Maps a list of ParkinglotLogs to ParkinglotLogEntities objects
	 * 
	 * @param ParkinglotLogs
	 *            Source data.
	 * @return List of ParkinglotLogEntities.
	 */
	public List<ParkinglotLogEntity> ParkinglotLogsToParkinglotLogEntities(List<ParkinglotLog> ParkinglotLogs) {
		return ParkinglotLogs.stream().filter(Objects::nonNull).map(this::ParkinglotLogToParkinglotLogEntity)
				.collect(Collectors.toList());
	}

	/**
	 * Maps a list of ParkinglotLogEntities to ParkinglotLogs
	 * 
	 * @param ParkinglotLogEntities
	 *            Source Data
	 * @return List of ParkinglotLogs.
	 */
	public List<ParkinglotLog> ParkinglotLogEntitiesToParkinglotLogs(List<ParkinglotLogEntity> ParkinglotLogEntities) {
		return ParkinglotLogEntities.stream().filter(Objects::nonNull).map(this::ParkinglotLogEntityToParkinglotLog)
				.collect(Collectors.toList());
	}

}