package com.feign.parctice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feign.parctice.dto.PostRqsDto;
import com.feign.parctice.dto.PostsRspDto;
import com.feign.parctice.feign.service.Posts;

@RestController
public class controller {
	
	@Autowired
	private Posts posts;
	
	@PostMapping("/posts")
	public ResponseEntity<PostsRspDto> getPostById(@RequestBody PostRqsDto postRqsDto){
		
		PostsRspDto rsp = null;
		try {
			 rsp = posts.getPost(postRqsDto.getId());
		}catch (Exception e) {
			
		}
		
		
		if(rsp == null) {
			rsp = new PostsRspDto();
		}
		
		return ResponseEntity.ok(rsp);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<List<PostsRspDto>> getAllPosts(){
		return ResponseEntity.ok(posts.getAllPost());
	}

}
