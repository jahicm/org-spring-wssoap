package org.spring.wssoap.interceptors;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.MessageSenderInterceptor;
import org.apache.cxf.message.Message;

@InInterceptors
public class MessageInboundInterceptor extends MessageSenderInterceptor {

	@Override
	public void handleMessage(Message message) throws Fault {
		processPayLoad(message);
		super.handleMessage(message);
	}

	private void processPayLoad(Message message) {

		System.out.println("*** PROCESSING PAYLOAD AT IN-INTERCEPTOR **");
	}
}
