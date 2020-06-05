package com.feign.parctice.feign.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.feign.parctice.dto.PostsRspDto;
import com.feign.parctice.feign.BusinessException;

@FeignClient(name = "posts", url="${placeholder.url}")
public interface Posts {

	@GetMapping(path = "/posts/{id}")
	PostsRspDto getPost(@PathVariable(name = "id") String id) throws BusinessException;
	
	@GetMapping(path = "/posts")
	List<PostsRspDto> getAllPost();
	
}
