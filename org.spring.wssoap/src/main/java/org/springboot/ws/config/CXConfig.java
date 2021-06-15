package org.springboot.ws.config;

import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.ext.logging.LoggingFeature;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.spring.wssoap.interceptors.MessageInboundInterceptor;
import org.spring.wssoap.interceptors.MessageOutboundInterceptor;
import org.spring.wssoap.security.SoapUsernameTokenValidator;
import org.spring.wssoap.service.CarServiceImpl;
import org.spring.wssoap.service.CollectionServiceImpl;
import org.spring.wssoap.service.InfoServiceImpl;
import org.spring.wssoap.service.MessageServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CXConfig {

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		SpringBus springBus = new SpringBus();

		springBus.getInInterceptors().add(new MessageInboundInterceptor());
		springBus.getOutInterceptors().add(new MessageOutboundInterceptor());

		springBus.getInInterceptors().add(getInterceptor());
		Map<String, Object> map = new HashMap<>();
		map.put("ws-security.ut.validator", getSecurityToken());
		springBus.setProperties(map);

		return springBus;
	}

	@Bean
	public Endpoint endpointInfo() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), new InfoServiceImpl());
		endpoint.getFeatures().add(new LoggingFeature());
		endpoint.publish("/InfoService");
		return endpoint;
	}

	@Bean
	public Endpoint endpointMessage() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), new MessageServiceImpl());
		endpoint.getFeatures().add(new LoggingFeature());
		endpoint.publish("/MessageService");
		return endpoint;
	}

	@Bean
	public Endpoint endpointCar() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), new CarServiceImpl());
		endpoint.publish("/CarService");
		return endpoint;
	}

	@Bean
	public Endpoint endpointCollection() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), new CollectionServiceImpl());
		endpoint.publish("/CollectionService");
		return endpoint;
	}

	@Bean
	public SoapUsernameTokenValidator getSecurityToken() {
		return new SoapUsernameTokenValidator();
	}

	@Bean
	public WSS4JInInterceptor getInterceptor() {
		Map<String, Object> interceptorConfig = new HashMap<>();
		interceptorConfig.put("action", "UsernameToken");
		interceptorConfig.put("passwordType", "PasswordText");

		return new WSS4JInInterceptor(interceptorConfig);

	}
}
