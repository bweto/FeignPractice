package com.feign.parctice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

@Configuration
public class FeignEnableHystrixConfiguration {

	@Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    } 

}
