/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTCELLINFOSERVICE.JAVA                              */
/* Description:   Implements Parking lot Cell Info service contract for       */
/*                accessing ParkinglotCellInfo domain objects.                */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.09/2017                                                 */
/* Last Modified: Oct.12/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.09/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.ceiba.java.learn.parking.service;

import org.springframework.stereotype.Service;

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotCellInfo;
import com.csoftz.ceiba.java.learn.parking.service.entities.ParkinglotCellInfoEntity;
import com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotCellInfoService;
import com.csoftz.ceiba.java.learn.parking.service.mapper.ParkinglotCellInfoMapper;
import com.csoftz.ceiba.java.learn.parking.service.repository.interfaces.IParkinglotCellInfoRepository;

/**
 * Implements Parking lot Cell Info service contract for accessing
 * ParkinglotCellInfo domain objects.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.12/2017
 * @since 1.8 (JDK), Oct.09/2017
 */
@Service
public class ParkinglotCellInfoService implements IParkinglotCellInfoService {
	/*
	 * Dependencies
	 */
	private IParkinglotCellInfoRepository parkinglotCellInfoRepository;
	private ParkinglotCellInfoMapper parkinglotCellInfoMapper;

	/**
	 * Constructor
	 * 
	 * @param parkinglotCellInfoRepository
	 *            Inject a parking lot log repository.
	 */
	public ParkinglotCellInfoService(IParkinglotCellInfoRepository parkinglotCellInfoRepository,
			ParkinglotCellInfoMapper parkinglotCellInfoMapper) {
		this.parkinglotCellInfoRepository = parkinglotCellInfoRepository;
		this.parkinglotCellInfoMapper = parkinglotCellInfoMapper;
	}

	/**
	 * @see com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotCellInfoService#find(java.lang.String,
	 *      int)
	 */
	@Override
	public ParkinglotCellInfo find(String plate, int vehicleType) {
		ParkinglotCellInfoEntity parkinglotCellInfoEntity = parkinglotCellInfoRepository
				.findByPlateAndVehicleType(plate, vehicleType);
		return parkinglotCellInfoMapper.parkinglotCellInfoEntityToParkinglotCellInfo(parkinglotCellInfoEntity);
	}

	/**
	 * @see com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotCellInfoService#takeCapacityFor(int)
	 */
	@Override
	public int takeCapacityFor(int vehicleType) {
		return parkinglotCellInfoRepository.countByVehicleType(vehicleType);
	}

	/**
	 * @see com.csoftz.ceiba.java.learn.parking.service.interfaces.IParkinglotCellInfoService#assign(java.lang.String,
	 *      int)
	 */
	@Override
	public ParkinglotCellInfo assign(String plate, int vehicleType) {
		ParkinglotCellInfoEntity parkinglotCellInfoEntity = new ParkinglotCellInfoEntity(plate, vehicleType);
		parkinglotCellInfoEntity = parkinglotCellInfoRepository.save(parkinglotCellInfoEntity);
		return parkinglotCellInfoMapper.parkinglotCellInfoEntityToParkinglotCellInfo(parkinglotCellInfoEntity);
	}
}
