package org.spring.wssoap.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.spring.wssoap.model.Message;

@WebService(serviceName = "InfoService")
public interface InfoService {
	@WebMethod()
	@WebResult(name = "Message")
	public Message sayHowAreYou(@WebParam(name = "InfoRequest") String name);
}
