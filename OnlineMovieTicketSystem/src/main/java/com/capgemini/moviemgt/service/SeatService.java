package com.capgemini.moviemgt.service;

import com.capgemini.moviemgt.model.Seat;

public interface SeatService {

	public String blockSeat(Seat seat);

	public Seat bookSeat(Seat seat);

	public String cancelSeat(int sid);
}
