package com.demo.neo.soft.springboot.task.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.neo.soft.springboot.task.entity.User;
import com.demo.neo.soft.springboot.task.model.ResponseObject;
import com.demo.neo.soft.springboot.task.model.UpdateUserDto;
import com.demo.neo.soft.springboot.task.model.UserDto;
import com.demo.neo.soft.springboot.task.service.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create an user",
            responses = {
                    @ApiResponse(responseCode = "201", description = "User created successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid input"),
                    @ApiResponse(responseCode = "409", description = "If user already registered with same phoneNumber or email"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            }
    )
    public ResponseObject addUser(
            @Parameter(required = true, description = "Request Body to create an user")
            @Valid @RequestBody UserDto user) {
        return userService.saveUser(user);
    }


    @GetMapping("/{uId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get an user by id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User found in database"),
                    @ApiResponse(responseCode = "400", description = "User status not active in database"),
                    @ApiResponse(responseCode = "404", description = "User not found in database"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            }
    )
    public ResponseObject getUser(
            @Parameter(required = true, description = "id of an user")
            @PathVariable String uId) {
        return userService.findUser(uId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get an user by phoneNumber or email",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User found in database"),
                    @ApiResponse(responseCode = "400", description = "User status not active in database"),
                    @ApiResponse(responseCode = "404", description = "User not found in database"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            }
    )
    public ResponseObject getUserBy(
            @Parameter(description = "emailId of an user")
            @RequestParam(required = false) String email) {
        return userService.findUserBy(email);
    }

    @PutMapping("/{uId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "update an user",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User updated successfully"),
                    @ApiResponse(responseCode = "400", description = "User status not active in database or invalid field value"),
                    @ApiResponse(responseCode = "404", description = "User not found in database"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            }
    )
    public ResponseObject updateUser(
            @Parameter(required = true, description = "user id of an user")
            @PathVariable String userId,
            @Parameter(required = true, description = "Request body to update an user")
            @Valid @RequestBody UpdateUserDto updateUserDto) {
        return userService.updateUser(userId, updateUserDto);
    }

    @PatchMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "deactivate an user",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User deactivated successfully"),
                    @ApiResponse(responseCode = "400", description = "User status not active in database"),
                    @ApiResponse(responseCode = "404", description = "User not found in database"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            })
    public ResponseObject deactivateUser(
            @Parameter(required = true, description = "user id of an user")
            @PathVariable String userId) {
        return userService.deActivateUser(userId);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "delete an user",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User deleted successfully"),
                    @ApiResponse(responseCode = "404", description = "User not found in database"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error"),
            })
    public ResponseObject deleteUser(
            @Parameter(required = true, description = "user id of an user")
            @PathVariable String userId) {
        return userService.deleteUser(userId);
    }


}