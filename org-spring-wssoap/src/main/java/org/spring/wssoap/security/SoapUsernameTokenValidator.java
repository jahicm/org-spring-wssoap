package org.spring.wssoap.security;

import org.apache.wss4j.common.ext.WSSecurityException;
import org.apache.wss4j.common.ext.WSSecurityException.ErrorCode;
import org.apache.wss4j.dom.handler.RequestData;
import org.apache.wss4j.dom.validate.Credential;
import org.apache.wss4j.dom.validate.UsernameTokenValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.cxf.interceptor.InInterceptors;

@InInterceptors
public class SoapUsernameTokenValidator extends UsernameTokenValidator {

	private static final Logger LOGGER = LoggerFactory.getLogger(SoapUsernameTokenValidator.class);

	@Override
	public Credential validate(Credential credential, RequestData data) throws WSSecurityException {
		String username = credential.getUsernametoken().getName();
		String password = credential.getUsernametoken().getPassword();

		if (username.equals("myuser") && password.equals("mypassword")) {
			LOGGER.info(username + " is successfully validated");
		} else {
			throw new WSSecurityException(ErrorCode.FAILED_AUTHENTICATION);
		}
		return credential;
	}
}
