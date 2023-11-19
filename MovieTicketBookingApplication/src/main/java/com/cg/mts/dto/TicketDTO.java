package com.cg.mts.dto;

import java.util.List;

import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketDTO {
    private int ticketId;
    @Positive(message = "Number of seats must be a positive integer")
    private int noOfSeats;
    private boolean ticketStatus;
    private List<SeatDTO> seats;
    private BookingDTO booking;
    
}