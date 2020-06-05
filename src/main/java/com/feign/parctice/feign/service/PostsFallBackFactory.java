package com.feign.parctice.feign.service;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class PostsFallBackFactory implements FallbackFactory<Posts> {

	@Override
	public Posts create(Throwable cause) {
		return new PostsFallBack(cause);
	}
	

}
