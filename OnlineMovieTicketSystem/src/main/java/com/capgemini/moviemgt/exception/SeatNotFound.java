package com.capgemini.moviemgt.exception;


public class SeatNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SeatNotFound(String msg) {
		super(msg);
	}
}
