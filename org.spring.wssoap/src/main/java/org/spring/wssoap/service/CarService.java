package org.spring.wssoap.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.spring.wssoap.model.CarRequest;
import org.spring.wssoap.model.CarResponse;

@WebService(serviceName = "CarService")
public interface CarService {

	@WebMethod()
	@WebResult(name = "CarResponse")
	public CarResponse getPrice(@WebParam(name = "CarRequest") CarRequest carRequest);
}
