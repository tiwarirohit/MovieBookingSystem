
package com.capgemini.moviemgt.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.moviemgt.dao.SeatDao;
import com.capgemini.moviemgt.exception.SeatIsBooked;
import com.capgemini.moviemgt.exception.SeatNotFound;
import com.capgemini.moviemgt.model.BookingState;
import com.capgemini.moviemgt.model.Seat;

@Service
@Transactional
public class SeatServiceImpl implements SeatService{

	@Autowired
	private SeatDao sdao;
	
	@Override
	public String blockSeat(Seat seat) {
		Optional<Seat> findbyId = sdao.findById(seat.getSeatId());
		if(findbyId.isPresent() && findbyId.get().getSeatStatus().equals(BookingState.AVAILABLE)) {
			findbyId.get().setSeatStatus(BookingState.BLOCKED);
			return "The Seat is Blocked";
		}
		else
			return "Seat is available";
	}

	@Override
	public Seat bookSeat(Seat seat) {
		// TODO Auto-generated method stub
		Optional<Seat> seatFindId = sdao.findById(seat.getSeatId());
			try {
				if(seatFindId.isPresent())
					throw new SeatIsBooked("Seat is already Booked");
			} catch (SeatIsBooked e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			seatFindId.get().setSeatStatus(BookingState.BOOKED);
		return sdao.save(seat);
	}

	@Override
	public String cancelSeat(int sid) {
		// TODO Auto-generated method stub
		Optional<Seat> seat = sdao.findById(sid);			
		try {
			if(!seat.isPresent() || seat == null) {
				throw new SeatNotFound("Seat is not found by given ID");
			}
		} catch(SeatNotFound e) {
			e.printStackTrace();
		}
		sdao.deleteById(sid);
		seat.get().setSeatStatus(BookingState.AVAILABLE);
		return "Seat is Cancelled";
	}
}
