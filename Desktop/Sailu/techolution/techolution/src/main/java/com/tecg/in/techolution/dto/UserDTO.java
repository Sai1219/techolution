package com.tecg.in.techolution.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


import com.tecg.in.techolution.config.Constants;


public class UserDTO {

	private Long id;

    @NotBlank(message="Mobile number should not be empty")
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 11, max = 11, message="Please enter valid mobile number")
    private String login;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", login=" + login + "]";
	}
    
    
	
	

}
