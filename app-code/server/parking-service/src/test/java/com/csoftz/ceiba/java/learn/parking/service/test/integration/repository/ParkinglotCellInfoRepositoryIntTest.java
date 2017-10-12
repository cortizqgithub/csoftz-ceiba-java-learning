/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTCELLINFOREPOSITORYINTTEST.JAVA                    */
/* Description:   Test for Parking lot Cell Info Repository.                  */
/*                (Integration Test).                                         */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.10/2017                                                 */
/* Last Modified: Oct.12/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.09/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.ceiba.java.learn.parking.service.test.integration.repository;

import static com.csoftz.ceiba.java.learn.parking.commons.consts.GlobalConstants.VEHICLE_TYPE_CAR;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.csoftz.ceiba.java.learn.parking.service.entities.ParkinglotCellInfoEntity;
import com.csoftz.ceiba.java.learn.parking.service.repository.interfaces.IParkinglotCellInfoRepository;
import com.csoftz.ceiba.java.learn.parking.service.test.entities.data.builder.ParkinglotCellInfoEntityDataBuilder;

/**
 * Test for Parking lot Cell Info Repository.
 *
 * @author Carlos Adolfo Ortiz Quirós (COQ)
 * @version 1.1, Oct.12/2017
 * @since 1.8 (JDK), Oct.10/2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkinglotCellInfoRepositoryIntTest {
	private static final String PLATE = "KDF123";
	private static final int VEHICLE_TYPE = VEHICLE_TYPE_CAR;

	@Autowired
	private IParkinglotCellInfoRepository parkinglotCellInfoRepository;

	/**
	 * Verifies that a record is saved to repository.
	 */
	@Test
	public void testSave() {
		ParkinglotCellInfoEntity parkinglotCellInfoEntity = new ParkinglotCellInfoEntityDataBuilder().withPlate(PLATE)
				.withVehicleType(VEHICLE_TYPE).build();
		parkinglotCellInfoEntity = parkinglotCellInfoRepository.save(parkinglotCellInfoEntity);
		assertThat(parkinglotCellInfoEntity).isNotNull();
	}
}