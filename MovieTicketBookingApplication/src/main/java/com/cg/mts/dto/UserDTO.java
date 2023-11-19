package com.cg.mts.dto;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private int userId;
    
//  @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;
//    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
//  @NotBlank(message = "Role is required")
    @Pattern(regexp = "^(ADMIN|CUSTOMER)$", message = "Role must be ADMIN or CUSTOMER")
    private String role;
    
    private CustomerDTO customer;
	
}