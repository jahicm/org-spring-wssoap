package org.spring.wssoap.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import org.spring.wssoap.model.Message;

@WebService(serviceName = "MessageService")
public interface MessageService {

	@WebMethod()
	@WebResult(name = "Message")
	public Message sayHello(@WebParam(name = "MessageRequest") String name);

	@WebMethod()
	@WebResult(name = "Message")
	public Message sayBye(@WebParam(name = "MessageRequest") String name);
}
