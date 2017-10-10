/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTLOGSERVICE.JAVA                                   */
/* Description:   Implements contract to show parkinglot log activities.      */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.06/2017                                                 */
/* Last Modified: Oct.10/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.06/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.ceiba.java.learn.parking.service;

import org.springframework.stereotype.Service;

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotLog;
import com.csoftz.ceiba.java.learn.parking.domain.Vehicle;
import com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotLogService;
import com.csoftz.ceiba.java.learn.parking.service.repository.interfaces.IParkinglotLogRepository;

/**
 * Implements contract to show parkinglot log activities.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.09/2017
 * @since 1.8 (JDK), Oct.10/2017
 */
@Service
public class ParkinglotLogService implements IParkinglotLogService {
	/*
	 * Dependencies
	 */
	private IParkinglotLogRepository parkinglotLogRepository;

	/**
	 * Constructor
	 * 
	 * @param parkinglotLogRepository
	 *            Inject a parking lot repository.
	 */
	public ParkinglotLogService(IParkinglotLogRepository parkinglotLogRepository) {
		this.parkinglotLogRepository = parkinglotLogRepository;
	}

	/**
	 * @see com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotLogService#save(com.csoftz.ceiba.java.learn.parking.domain.Vehicle)
	 */
	@Override
	public ParkinglotLog save(Vehicle vehicle) {
		return parkinglotLogRepository.save(vehicle);
	}
}