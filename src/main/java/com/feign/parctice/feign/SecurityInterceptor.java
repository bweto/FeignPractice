package com.feign.parctice.feign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import feign.RequestInterceptor;
import feign.RequestTemplate;


public class SecurityInterceptor implements RequestInterceptor {
	
	private static final Logger LOG = LoggerFactory.getLogger(SecurityInterceptor.class);
	
	private static final String AUTHENTICATION_HEADER = "Authorization";
	
	@Override
	public void apply(RequestTemplate template) {
		propagateAuthorizationHeader(template);
	}
	
	private void propagateAuthorizationHeader(RequestTemplate template) {
		if(template.headers().containsKey(AUTHENTICATION_HEADER)) {
			LOG.debug("The autorization is: {} in objetc", AUTHENTICATION_HEADER);
		} else {
			LOG.debug("Add token: {} in rqs", AUTHENTICATION_HEADER);
			template.header(AUTHENTICATION_HEADER, SecurityContextHolder.getContext().getAuthentication().getName());
		}
	}

}
