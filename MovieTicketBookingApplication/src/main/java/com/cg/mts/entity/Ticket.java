package com.cg.mts.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ticketId;
	private int noOfSeats;
	private boolean ticketStatus;
	//@OneToMany(mappedBy = "ticket")
	@OneToMany
	@JsonIgnore
	private List<Seat> seats;
	@OneToOne
	@JsonIgnore
	private Booking booking;

	public Ticket(int noOfSeats, boolean ticketStatus, List<Seat> seats, Booking booking) {
		super();
		this.noOfSeats = noOfSeats;
		this.ticketStatus = ticketStatus;
		this.seats = seats;
		this.booking = booking;
	}
}