package com.feign.parctice.configuration;

import org.springframework.cloud.openfeign.FeignErrorDecoderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.feign.parctice.feign.FeignErrorDecoder;

import feign.Logger;

@Configuration
public class FeignEnableHystrixConfiguration {

	@Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    } 
	
	@Bean
	public FeignErrorDecoderFactory getFeignErrorDecoder() {
		return new FeignErrorDecoder();
	}
	

}
