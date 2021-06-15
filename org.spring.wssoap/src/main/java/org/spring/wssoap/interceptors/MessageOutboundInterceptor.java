package org.spring.wssoap.interceptors;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.MessageSenderInterceptor;
import org.apache.cxf.interceptor.OutInterceptors;
import org.apache.cxf.message.Message;

@OutInterceptors
public class MessageOutboundInterceptor extends MessageSenderInterceptor {

	@Override
	public void handleMessage(Message message) throws Fault {
		processPayLoad(message);
		super.handleMessage(message);
	}

	private void processPayLoad(Message message) {

		System.out.println("*** PROCESSING PAYLOAD AT OUT-INTERCEPTOR **");
	}
}