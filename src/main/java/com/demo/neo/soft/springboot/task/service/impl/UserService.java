package com.demo.neo.soft.springboot.task.service.impl;

import com.demo.neo.soft.springboot.task.model.ResponseObject;
import com.demo.neo.soft.springboot.task.model.UpdateUserDto;
import com.demo.neo.soft.springboot.task.model.UserDto;

public interface UserService {
	
	ResponseObject saveUser(UserDto userDto);

    ResponseObject findUser(String userId);

    ResponseObject findUserBy(String email);

    ResponseObject updateUser(String userId, UpdateUserDto updateUserDto);

    ResponseObject deActivateUser(String userId);

    ResponseObject deleteUser(String userId);
}
