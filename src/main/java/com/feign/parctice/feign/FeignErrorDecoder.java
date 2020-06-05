package com.feign.parctice.feign;

import org.springframework.cloud.openfeign.FeignErrorDecoderFactory;

import feign.codec.ErrorDecoder;

public class FeignErrorDecoder implements FeignErrorDecoderFactory {

	@Override
	public ErrorDecoder create(Class<?> type) {
		return new CustomFeignError();
	}

}
