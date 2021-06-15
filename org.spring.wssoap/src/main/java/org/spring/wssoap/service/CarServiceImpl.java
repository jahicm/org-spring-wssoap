package org.spring.wssoap.service;

import org.spring.wssoap.model.CarRequest;
import org.spring.wssoap.model.CarResponse;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

	@Override
	public CarResponse getPrice(CarRequest carRequest) {
		CarResponse newCar = new CarResponse();
		newCar.setId(carRequest.getId());
		newCar.setBrand(carRequest.getBrand());
		newCar.setYear(carRequest.getYear());
		newCar.setPrice(25400);
		return newCar;
	}

}
