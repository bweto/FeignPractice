package com.feign.parctice.feign;

public class BusinessException extends Exception {

	private static final long serialVersionUID = 1809981444400466907L;
	
	private final int status;
	
	private final String rason;


	public BusinessException(String rason, int status) {
		super(rason);
		this.rason = rason;
		this.status = status;
	}


	public int getStatus() {
		return status;
	}

	public String getRason() {
		return rason;
	}


}
