package com.feign.parctice.feign;

import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;

import com.feign.parctice.dto.PostsRspDto;
import com.feign.parctice.feign.service.Posts;

import feign.Feign;
import feign.Logger.Level;
import feign.codec.Decoder;
import feign.slf4j.Slf4jLogger;

//@Import(FeignClientsConfiguration.class)
public class PostControllerFeign {
/*	
	private Posts post;
	
	public PostControllerFeign(Decoder decoder) {
		this.post = Feign.builder()
				.logger(new Slf4jLogger())
				.logLevel(Level.FULL)
				.decoder(decoder)
				.target(Posts.class, "https://jsonplaceholder.typicode.com");
			
	}

	public PostsRspDto getPostRspDto(String id) {
		return post.getPost(id);
	}

*/
}
