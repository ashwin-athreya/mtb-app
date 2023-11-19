package com.cg.mts.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MovieDTO {
    private int movieId;
    @NotBlank(message = "Movie name is required")
    private String movieName;
    @NotBlank(message = "Movie genre is required")
    private String movieGenre;
    @NotBlank(message = "Movie hours are required")
    @Pattern(regexp = "^\\d{1,2}:\\d{2}$", message = "Invalid time format. Use HH:mm")
    private String movieHours;
    @NotBlank(message = "Movie language is required")
    private String movieLanguage;
    @NotBlank(message = "Movie description is required")
    private String movieDescription;
    @NotBlank(message = "Movie rating is required")
    @Pattern(regexp = "^[1-9]|10$", message = "Invalid rating. Use a number between 1 and 10")
    private String movieRating;
    @NotNull(message = "Movie date is required")
    private LocalDate movieDate;
    private ShowDTO shows;
    
}