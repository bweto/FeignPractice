package com.feign.parctice.dto;

import java.io.Serializable;

public class PostsRspDto implements Serializable {

	private static final long serialVersionUID = -792987481761678454L;

	private Long id;

	private String title;

	private String body;

	private Integer userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
