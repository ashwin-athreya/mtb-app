package com.cg.mts.dto;

public class LoginDTO {
    private boolean loginStatus;
    private UserDTO user;

    public LoginDTO() {

    }

    public LoginDTO(boolean loginStatus, UserDTO user) {
        this.loginStatus = loginStatus;
        this.user = user;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

  public String getRole() {
	  return user.getRole();
  }
}