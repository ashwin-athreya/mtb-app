package com.cg.mts.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private int customerId;
    @Size(min = 3, max = 50, message = "Customer name must be between 3 and 50 characters")
    private String customerName;
    @NotBlank(message = "Address is required")
    private String address;
    @Pattern(regexp = "\\d{10}", message = "Mobile number must be a 10-digit number")
    private String mobileNumber;
    @Email(message = "Invalid email address")
    private String email;
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
   
}