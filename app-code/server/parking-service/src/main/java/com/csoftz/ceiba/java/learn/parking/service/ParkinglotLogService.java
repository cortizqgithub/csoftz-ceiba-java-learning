/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTLOGSERVICE.JAVA                                   */
/* Description:   Implements contract to show parkinglot log activities.      */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.06/2017                                                 */
/* Last Modified: Oct.12/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.06/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.ceiba.java.learn.parking.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotLog;
import com.csoftz.ceiba.java.learn.parking.domain.Vehicle;
import com.csoftz.ceiba.java.learn.parking.service.entities.ParkinglotLogEntity;
import com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotLogService;
import com.csoftz.ceiba.java.learn.parking.service.mapper.ParkinglotLogMapper;
import com.csoftz.ceiba.java.learn.parking.service.repository.interfaces.IParkinglotLogRepository;

/**
 * Implements contract to show parkinglot log activities.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.12/2017
 * @since 1.8 (JDK), Oct.06/2017
 */
@Service
public class ParkinglotLogService implements IParkinglotLogService {
	/*
	 * Dependencies
	 */
	private IParkinglotLogRepository parkinglotLogRepository;
	private ParkinglotLogMapper parkinglotLogMapper;

	/**
	 * Constructor
	 * 
	 * @param parkinglotLogRepository
	 *            Inject a parking lot repository.
	 * @param parkinglotLogMapper
	 *            Inject a Domain to Entity mapper.
	 */
	public ParkinglotLogService(IParkinglotLogRepository parkinglotLogRepository,
			ParkinglotLogMapper parkinglotLogMapper) {
		this.parkinglotLogRepository = parkinglotLogRepository;
		this.parkinglotLogMapper = parkinglotLogMapper;
	}

	/**
	 * @see com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotLogService#save(com.csoftz.ceiba.java.learn.parking.domain.Vehicle)
	 */
	@Override
	public ParkinglotLog save(Vehicle vehicle) {
		if (vehicle == null) {
			return null;
		}

		ParkinglotLogEntity parkinglotLogEntity = new ParkinglotLogEntity(0L, vehicle.getPlate(), vehicle.getType(),
				LocalDateTime.now(), null);
		parkinglotLogEntity = parkinglotLogRepository.save(parkinglotLogEntity);
		return parkinglotLogMapper.parkinglotLogEntityToParkinglotLog(parkinglotLogEntity);
	}
}