package com.cg.mts.dto;

import java.time.LocalDate;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDTO {
    private int transactionId;

    @Valid
    @JsonIgnore
    @JsonIgnoreProperties("booking")
    private ShowDTO show;

    @NotNull(message = "Booking date cannot be null")
    private LocalDate bookingDate;

    @Pattern(regexp = "(Online|Offline|)", message = "Invalid transaction mode")
    private String transactionMode;

    @Pattern(regexp = "(Pending|Completed|Cancelled)", message = "Invalid transaction status")
    private String transactionStatus;

    @Positive(message = "Total cost must be a positive value")
    private double totalCost;

    private CustomerDTO customer;

    private TicketDTO ticket;
}
