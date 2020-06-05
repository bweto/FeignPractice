package com.feign.parctice.feign.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.feign.parctice.dto.PostsRspDto;

import feign.FeignException;

public class PostsFallBack implements Posts {
	
	private static final Logger LOG = LoggerFactory.getLogger(PostsFallBack.class);
	private Throwable cause;
	
	public PostsFallBack(Throwable cause) {
		this.cause = cause;
	}
	
	@Override
	public PostsRspDto getPost(String id) {

			LOG.info("El error es {}", cause.getMessage());
	
		if(cause instanceof FeignException && ((FeignException) cause).status() == 200) {
			LOG.error("404 error took place when getAlbums was called with userId: ".concat(id).concat(" Error messagge: ".concat(cause.getLocalizedMessage())));
		}else {
			LOG.error("Other error took place: ".concat(cause.getLocalizedMessage()));
		}

		return new PostsRspDto();
	}

	@Override
	public List<PostsRspDto> getAllPost() {
		if(cause instanceof FeignException && ((FeignException) cause).status() == 404) {
			LOG.error("404 error took place when getAlbums was called with userId: ".concat(" Error messagge: ".concat(cause.getLocalizedMessage())));
		}else {
			LOG.error("Other error took place: ".concat(cause.getLocalizedMessage()));
		}

		return new ArrayList<>();
	}

}
