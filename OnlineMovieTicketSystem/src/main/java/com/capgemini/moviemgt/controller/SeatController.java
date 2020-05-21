package com.capgemini.moviemgt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.moviemgt.model.Seat;
import com.capgemini.moviemgt.service.SeatService;

@RestController
@RequestMapping("/seat")
public class SeatController {

	@Autowired
	private SeatService seatService;
	
	@PostMapping(value = "/bookSeat", consumes = MediaType.APPLICATION_JSON_VALUE)
	public Seat bookSeat(@RequestBody Seat seat) {
		return seatService.bookSeat(seat);
	}
	
	@DeleteMapping(value = "/cancelSeat/{seatId}")
	public String cancelSeat(@PathVariable("seatId") Integer sid) {
		return seatService.cancelSeat(sid);
	}
	
	@PostMapping(value = "/blockSeat/{seatId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String blockSeat(@RequestBody Seat seat) {
		return seatService.blockSeat(seat);
	}
	
}
