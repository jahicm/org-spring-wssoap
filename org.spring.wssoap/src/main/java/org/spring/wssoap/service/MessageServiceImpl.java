package org.spring.wssoap.service;

import java.util.Date;

import org.spring.wssoap.model.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

	@Override
	public Message sayHello(String name) {
		Message message = new Message();
		message.setMessage("Hello from MessageService " + name + "!");
		message.setDate(new Date());
		return message;
	}

	@Override
	public Message sayBye(String name) {
		Message message = new Message();
		message.setMessage("Bye from MessageService " + name + "!!!");
		message.setDate(new Date());
		return message;
	}
	
	
}