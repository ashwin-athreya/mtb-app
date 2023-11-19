package com.cg.mts.entity;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	
	@JsonIgnore
	@OneToOne(mappedBy = "booking")
	private Show show;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate bookingDate;
	
	private String transactionMode;
	private String transactionStatus;
	private double totalCost;
	
	@JsonIgnore
	@ManyToOne
	private Customer customer;
	
	@JsonIgnore
	@OneToOne(mappedBy = "booking")
	private Ticket ticket;


	public Booking(Show show, LocalDate bookingDate, String transactionMode, String transactionStatus, double totalCost,
			Customer customer, Ticket ticket) {
		super();
		this.show = show;
		this.bookingDate = bookingDate;
		this.transactionMode = transactionMode;
		this.transactionStatus = transactionStatus;
		this.totalCost = totalCost;
		this.customer = customer;
		this.ticket = ticket;
	}

	
}