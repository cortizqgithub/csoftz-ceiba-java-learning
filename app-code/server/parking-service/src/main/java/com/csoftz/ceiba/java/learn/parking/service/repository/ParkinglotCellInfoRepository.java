package com.csoftz.ceiba.java.learn.parking.service.repository;

import org.springframework.stereotype.Repository;

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotCellInfo;
import com.csoftz.ceiba.java.learn.parking.service.repository.interfaces.IParkinglotCellInfoRepository;

@Repository
public class ParkinglotCellInfoRepository implements IParkinglotCellInfoRepository {

	@Override
	public ParkinglotCellInfo find(String plate, int vehicleType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int takeCapacityFor(int vehicleType) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ParkinglotCellInfo assign(String plate, int vehicleType) {
		// TODO Auto-generated method stub
		return null;
	}

}
