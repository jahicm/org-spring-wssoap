package org.spring.wssoap.service;

import java.util.Date;

import org.spring.wssoap.model.Message;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {

	@Override
	public Message sayHowAreYou(String name) {
		Message message = new Message();
		message.setMessage("How are you " + name + "!!!");
		message.setDate(new Date());
		return message;
	}
}
