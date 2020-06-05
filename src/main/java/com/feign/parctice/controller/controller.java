package com.feign.parctice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feign.parctice.dto.PostRqsDto;
import com.feign.parctice.dto.PostsRspDto;
import com.feign.parctice.feign.BusinessException;
import com.feign.parctice.feign.service.Posts;

@RestController
public class Controller {
	
	private static final Logger LOG = LoggerFactory.getLogger(Controller.class); 
	
	@Autowired
	private Posts posts;
	
	@PostMapping("/posts")
	public ResponseEntity<PostsRspDto> getPostById(@RequestBody PostRqsDto postRqsDto){
		
		PostsRspDto rsp = null;
		
		try {
			 rsp = posts.getPost(postRqsDto.getId());
			 return ResponseEntity.ok(rsp);
		}catch (BusinessException e) {
			LOG.error("fail by: {} ", e.getMessage() );
			return new ResponseEntity<>(rsp, HttpStatus.BAD_REQUEST);
		}

	}
	
	@GetMapping("/posts")
	public ResponseEntity<List<PostsRspDto>> getAllPosts(){
		return ResponseEntity.ok(posts.getAllPost());
	}

}
