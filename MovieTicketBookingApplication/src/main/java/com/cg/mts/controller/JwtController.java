package com.cg.mts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.jwt.JwtResponse;
import com.cg.mts.jwt.JwtTokenUtil;
import com.cg.mts.jwt.MyUserDetailService;
import com.cg.mts.entity.User;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class JwtController {
	
	@Autowired
	private MyUserDetailService userService;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
//	@Autowired
//	private JwtUserDetailsService userDetailsService;
//
    @Autowired
    private AuthenticationManager authenticationManager;
	

	
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticateToken(@RequestBody User user) throws Exception {
		try {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				user.getUsername(),user.getPassword()));
}
		catch(BadCredentialsException e) {
			throw new Exception("Incorrect password");
		}
		
		final UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(jwt));
	}
	

}
