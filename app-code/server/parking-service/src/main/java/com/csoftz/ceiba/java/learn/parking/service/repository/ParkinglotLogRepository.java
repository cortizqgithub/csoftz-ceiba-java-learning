package com.csoftz.ceiba.java.learn.parking.service.repository;

import org.springframework.stereotype.Repository;

import com.csoftz.ceiba.java.learn.parking.domain.ParkinglotLog;
import com.csoftz.ceiba.java.learn.parking.domain.Vehicle;
import com.csoftz.ceiba.java.learn.parking.service.repository.interfaces.IParkinglotLogRepository;

@Repository
public class ParkinglotLogRepository implements IParkinglotLogRepository {

	@Override
	public ParkinglotLog save(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

}
