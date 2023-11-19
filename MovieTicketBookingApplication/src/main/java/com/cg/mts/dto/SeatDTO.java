package com.cg.mts.dto;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.cg.mts.entity.SeatStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatDTO {
    private int seatId;
    @Size(max = 5, message = "Seat number must be at most 10 characters")
    private String seatNumber;
    @Size(max = 10, message = "Seat type must be at most 20 characters")
    private String type;
    @Positive(message = "Price must be a positive value")
    private double price;
    private SeatStatus status;
    private TicketDTO ticket;
	    
}