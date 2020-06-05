package com.feign.parctice.feign;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.client.RestClientException;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomFeignError implements ErrorDecoder {
	
	private static final Logger log = LoggerFactory.getLogger(CustomFeignError.class);
	
	private ErrorDecoder delegate = new ErrorDecoder.Default();
	 
    private ObjectMapper mapper = new ObjectMapper();

	@Override
	public Exception decode(String methodKey, Response response) {
		log.trace("An exception has been caught in {}, trying to parse the playload.", methodKey);
		 
        if (response.body() == null) {
            log.error("Failed to parse the playload: Response has no body.");
            return delegate.decode(methodKey, response);
        }
        
        MessageResource messageResource;
        try {
            messageResource = mapper.readValue(response.body().asInputStream(), MessageResource.class);
        } catch (IOException e) {
            log.trace("Failed to parse the playload. The format of the message does not correspond with the predefined for the architecture.", e);
            return delegate.decode(methodKey, response);
        }
 
        final HttpStatus status = HttpStatus.valueOf(response.status());
 
        final String firstMessage =
            messageResource.getMessages().isEmpty() ? status.getReasonPhrase() : messageResource.getMessages().get(0);
 
        log.trace("Throwing proper exception with this message \"{}\" ", firstMessage);
 
        if (status == HttpStatus.FORBIDDEN || status == HttpStatus.UNAUTHORIZED) {
            return new AccessDeniedException(firstMessage);
        } 
        else if (status.is4xxClientError()) {
            return new BusinessException(status.getReasonPhrase() + messageResource);
 
        } 
        else {
            return new RestClientException(firstMessage);
        }
 
	}

}
