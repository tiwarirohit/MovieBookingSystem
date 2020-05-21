
package com.capgemini.moviemgt.exception;

public class SeatIsBooked extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public SeatIsBooked(String msg) {
		super(msg);
	}
}
