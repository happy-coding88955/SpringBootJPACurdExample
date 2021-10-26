package com.demo.neo.soft.springboot.task.model;

import javax.validation.constraints.Pattern;

import com.demo.neo.soft.springboot.task.entity.Address;
import com.demo.neo.soft.springboot.task.entity.Auditable;
import com.demo.neo.soft.springboot.task.utils.Constants;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateUserDto extends  Auditable<String>{
	
	private String userName;

	private String email;
	
	@Pattern(regexp = Constants.MOBILE_NUMBER_REGEX, message =
            Constants.MOBILE_NUMBER_REGEX_ERROR_MESSAGE)
	private String mobile;

	private boolean isActive;
	
	private Address address;

}
