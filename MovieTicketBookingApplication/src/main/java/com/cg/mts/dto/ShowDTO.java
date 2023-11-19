package com.cg.mts.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowDTO {
    private int showId;
    @FutureOrPresent(message = "Show start time must be in the present or future")
    private LocalDateTime showStartTime;
    @FutureOrPresent(message = "Show end time must be in the present or future")
    private LocalDateTime showEndTime;
    @Size(max = 20, message = "Show name must be at most 255 characters")
    private String showName;
    private MovieDTO movie;
    private ScreenDTO screen;
    private TheatreDTO theatre;
    @JsonIgnore
    private BookingDTO booking;
    @FutureOrPresent(message = "Show date must be in the present or future")
    private LocalDate showDate;
   
}