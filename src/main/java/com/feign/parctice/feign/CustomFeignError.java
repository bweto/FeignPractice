package com.feign.parctice.feign;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomFeignError implements ErrorDecoder {
	
	@Override
	public Exception decode(String methodKey, Response response) {
		return new BusinessException(String.format("Fails by status %d, y msg: %s ",response.status(), response.reason()),response.status());
		
	}


}
