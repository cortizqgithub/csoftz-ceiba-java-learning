/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTLOGMAPPER.JAVA                                    */
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

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotLog;
import com.csoftz.ceiba.java.learn.parking.service.entities.ParkinglotLogEntity;

/**
 * Converts from Domain to Entity objects.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.05/2017
 * @since 1.8 (JDK), Oct.04/2017
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
	public ParkinglotLog parkinglotLogEntityToParkinglotLog(ParkinglotLogEntity info) {
		if (info == null) {
			return null;
		} else {
			ParkinglotLog parkinglotLog = new ParkinglotLog(info.getId(), info.getPlate(), info.getVehicleType(),
					info.getAdmissionDate(), info.getDepartureDate());
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
	public ParkinglotLogEntity parkinglotLogToParkinglotLogEntity(ParkinglotLog info) {
		if (info == null) {
			return null;
		} else {
			ParkinglotLogEntity parkinglotLogEntity = new ParkinglotLogEntity(info.getId(), info.getPlate(),
					info.getVehicleType(), info.getAdmissionDate(), info.getDepartureDate());
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
	public List<ParkinglotLogEntity> parkinglotLogsToParkinglotLogEntities(List<ParkinglotLog> ParkinglotLogs) {
		return ParkinglotLogs.stream().filter(Objects::nonNull).map(this::parkinglotLogToParkinglotLogEntity)
				.collect(Collectors.toList());
	}

	/**
	 * Maps a list of ParkinglotLogEntities to ParkinglotLogs
	 * 
	 * @param ParkinglotLogEntities
	 *            Source Data
	 * @return List of ParkinglotLogs.
	 */
	public List<ParkinglotLog> parkinglotLogEntitiesToParkinglotLogs(List<ParkinglotLogEntity> ParkinglotLogEntities) {
		return ParkinglotLogEntities.stream().filter(Objects::nonNull).map(this::parkinglotLogEntityToParkinglotLog)
				.collect(Collectors.toList());
	}

}
