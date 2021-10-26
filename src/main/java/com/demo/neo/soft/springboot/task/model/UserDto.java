package com.demo.neo.soft.springboot.task.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.demo.neo.soft.springboot.task.entity.Address;
import com.demo.neo.soft.springboot.task.utils.Constants;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDto {
	
	@NotNull(message = "userName should not be null")
	private String userName;

	@Email(message = "Email should be valid")
	private String email;

	@NotNull(message = "phoneNumber should not be null")
    @Pattern(regexp = Constants.MOBILE_NUMBER_REGEX, message =
            Constants.MOBILE_NUMBER_REGEX_ERROR_MESSAGE)
	private String mobile;

	private boolean isActive;
	
	 @NotNull(message = "address should not be null")
	private Address address;
}
