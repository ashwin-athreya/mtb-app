package com.cg.mts.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int seatId;
	private String seatNumber;
	private String type;
	private double price;

	@Enumerated(EnumType.STRING)
	private SeatStatus status;
	@JsonIgnore
	@ManyToOne
	private Ticket ticket;
	
	public Seat(String seatNumber, String type, double price, SeatStatus status, Ticket tickett) {
		super();
		this.seatNumber = seatNumber;
		this.type = type;
		this.price = price;
		this.status = status;
		this.ticket = tickett;
	}
}
