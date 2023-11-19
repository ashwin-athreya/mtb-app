package com.cg.mts.dto;

import java.util.List;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheatreDTO {
    private int theatreId;
    @Size(max = 50, message = "Theatre name must be at most 50 characters")
    private String theatreName;
    @Size(max = 20, message = "Theatre city must be at most 20 characters")
    private String theatreCity;
    @Size(max = 30, message = "Manager name must be at most 30 characters")
    private String managerName;
    @Pattern(regexp = "\\d{10}", message = "Manager contact must be a 10-digit number")
    private String managerContact;
    private List<ScreenDTO> screens;
    private List<ShowDTO> shows;
    
}