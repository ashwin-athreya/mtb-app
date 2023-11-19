package com.cg.mts.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mts.dto.LoginDTO;
import com.cg.mts.entity.Login;
import com.cg.mts.mapper.EntityDtoMapper;
import com.cg.mts.service.LoginService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {

	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginService logServ;
	

	@PostMapping("/login/{username}/{password}")
	public LoginDTO loginUser(@PathVariable @Pattern(regexp = "[a-zA-Z0-9]+", message = "Invalid username format")String username, 
			@PathVariable @NotBlank(message = "Password is required")String password) {
		Login login=new Login();
		LoginDTO loginDTO=new LoginDTO();
		try {
			login=logServ.loginWithData(username, password);
			loginDTO=EntityDtoMapper.convertToDTO(login, LoginDTO.class);
		} catch (Exception e) {
			logger.error("------------------LoginFailed---------------");
			return loginDTO;

		}
		logger.info("-----------------Login Successful----------------");
		return loginDTO;
	}

	
	@PostMapping("/logout")
	public HttpStatus logOut() throws Exception {
		if (this.loginStatus()) {
			logServ.logoutPresentUser();
			return HttpStatus.ACCEPTED;
		} else {
			throw new Exception("User Not yet Lo gged In");
		}
	}

	
	public boolean loginStatus() {
		return logServ.loginStatus();
	}

	
	public String getRole() {
		return logServ.getRole();
	}

}