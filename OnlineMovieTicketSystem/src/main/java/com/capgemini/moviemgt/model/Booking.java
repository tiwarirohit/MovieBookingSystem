/**
 * 
 */
package com.capgemini.moviemgt.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Nishant
 *
 */
@Entity
@Table(name = "booking")
public class Booking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	private int movieId;
	private int showId;
	private LocalDate bookingDate;
	private int transactionId;
	private double totalCost;
	/*
	 * @OneToMany(targetEntity = Ticket.class, cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "booking_fk", referencedColumnName = "bookingId")
	 */
	private Ticket ticket;
	
	@OneToOne(targetEntity = Show.class, cascade = CascadeType.ALL)
//	@JoinColumn(name = "booking_fk", referencedColumnName = "bookingId")
	private Show showref;
	@OneToMany(targetEntity = Seat.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "booking_fk", referencedColumnName = "bookingId")
	private List<Seat> seats;

	public Booking() {

	}

	public Booking(int movieId, int showId, LocalDate bookingDate, int transactionId, double totalCost, Ticket ticket,
			Show showref, List<Seat> seats) {
		super();
		this.movieId = movieId;
		this.showId = showId;
		this.bookingDate = bookingDate;
		this.transactionId = transactionId;
		this.totalCost = totalCost;
		this.ticket = ticket;
		this.showref = showref;
		this.seats = seats;
	}

//	Getters and Setters
	public int getBookingId() {
		return bookingId;
	}

	public Show getShowref() {
		return showref;
	}

	public void setShowref(Show showref) {
		this.showref = showref;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

}
