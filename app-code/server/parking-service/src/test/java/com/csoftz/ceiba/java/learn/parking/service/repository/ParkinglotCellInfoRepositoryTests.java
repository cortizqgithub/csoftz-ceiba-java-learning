/*----------------------------------------------------------------------------*/
/* Source File:   PARKINGLOTCELLINFOREPOSITORYTESTS.JAVA                      */
/* Description:   Test for Parking lot Cell Info Repository.                  */
/* Author:        Carlos Adolfo Ortiz Quirós (COQ)                            */
/* Date:          Oct.10/2017                                                 */
/* Last Modified: Oct.10/2017                                                 */
/* Version:       1.1                                                         */
/* Copyright (c), 2017 CSoftZ, Ceiba.                                         */
/*----------------------------------------------------------------------------*/
/*-----------------------------------------------------------------------------
 History
 Oct.09/2017 COQ  File created.
 -----------------------------------------------------------------------------*/
package com.csoftz.ceiba.java.learn.parking.service.repository;

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
 * @version 1.1, Oct.10/2017
 * @since 1.8 (JDK), Oct.10/2017
 */
// @RunWith(SpringRunner.class)
// @DataJpaTest(showSql = true)
// @AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkinglotCellInfoRepositoryTests {
	private static final Long ID = 1L;
	private static final String PLATE = "KDF123";
	private static final String PLATE_STARTS_WITH_A = "ABC123";
	private static final int VEHICLE_TYPE = VEHICLE_TYPE_CAR;
	private static final int CYLINDER = 120;

	// @Autowired
	// private TestEntityManager entityManager;

	@Autowired
	private IParkinglotCellInfoRepository parkinglotCellInfoRepository;

	// @Test
	// public void saveACellInfo() {
	// ParkinglotCellInfoEntity parkinglotCellInfoEntity = new
	// ParkinglotCellInfoEntityDataBuilder().withPlate(PLATE)
	// .withVehicleType(VEHICLE_TYPE).build();
	// entityManager.persist(parkinglotCellInfoEntity);
	//
	// parkinglotCellInfoEntity =
	// parkinglotCellInfoRepository.findByPlateAndVehicleType(PLATE, VEHICLE_TYPE);
	// assertThat(parkinglotCellInfoEntity).isNotNull();
	// }

	@Test
	public void testSave() {
		ParkinglotCellInfoEntity parkinglotCellInfoEntity = new ParkinglotCellInfoEntityDataBuilder().withPlate(PLATE)
				.withVehicleType(VEHICLE_TYPE).build();
		parkinglotCellInfoRepository.save(parkinglotCellInfoEntity);
		assertThat(parkinglotCellInfoEntity).isNotNull();
	}
}