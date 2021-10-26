package com.demo.neo.soft.springboot.task.service.impl;



import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.demo.neo.soft.springboot.task.entity.User;
import com.demo.neo.soft.springboot.task.exception.InternalStandardError;
import com.demo.neo.soft.springboot.task.exception.UserServiceException;
import com.demo.neo.soft.springboot.task.model.ResponseObject;
import com.demo.neo.soft.springboot.task.model.UpdateUserDto;
import com.demo.neo.soft.springboot.task.model.UserDto;
import com.demo.neo.soft.springboot.task.repository.UserRepository;
import com.demo.neo.soft.springboot.task.utils.CommonUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repository;

	@Override
    public ResponseObject saveUser(UserDto userDto) {
        log.debug("save user called..");
        if (isUserExist(userDto.getMobile(), userDto.getEmail())) {
            log.error("user already exist");
            throw new UserServiceException(InternalStandardError.USER_ALREADY_EXIST);
        }
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        User savedUser = repository.save(user);
        log.info("user saved successfully : {}", savedUser.getUserId());
        return ResponseObject.builder().status("User Saved with id: " + savedUser.getUserId()).build();
    }

    @Override
    public ResponseObject findUser(String userId) {
        Optional<User> userOpt = repository.findById(userId);
        if (!isActiveUser(userOpt)) {
            log.error("user not found with id {}", userId);
            throw new UserServiceException(InternalStandardError.USER_NOT_FOUND);
        }
        log.info("retrieving user info : {}", userId);
        return ResponseObject.builder().data(userOpt.get()).build();
    }

    @Override
    public ResponseObject findUserBy(String email) {
        Optional<User> userOpt = repository.findByPhoneNumberOrEmailId(email);
        if (!isActiveUser(userOpt)) {
            log.error("user not found");
            throw new UserServiceException(InternalStandardError.USER_NOT_FOUND);
        }
        log.info("retrieving user info : {}", userOpt.get().getUserId());
        return ResponseObject.builder().data(userOpt.get()).build();
    }

    @Override
    public ResponseObject updateUser(String userId, UpdateUserDto updateUserDto) {
        User user = (User) findUser(userId).getData();
        CommonUtils.copyValues(updateUserDto, user);
        User savedUser = repository.save(user);
        log.info("user updated successfully : {}", savedUser.getUserId());
        return ResponseObject.builder()
                .status("user updated successfully : " + savedUser.getUserId())
                .data(savedUser)
                .build();
    }

    @Override
    public ResponseObject deActivateUser(String uId) {
        User user = (User) findUser(uId).getData();
        user.setActive(false);
        log.info("deactivated user : {}", uId);
        repository.save(user);
        return ResponseObject.builder().data("deactivated user successfully : " + uId).build();
    }

    @Override
    public ResponseObject deleteUser(String userId) {
        Optional<User> userOpt = repository.findById(userId);
        if (!userOpt.isPresent()) {
            log.error("user not found");
            throw new UserServiceException(InternalStandardError.USER_NOT_FOUND);
        }
        repository.delete(userOpt.get());
        log.info("deleted user : {}", userId);
        return ResponseObject.builder().data("User deleted Successfully").build();
    }

    private boolean isActiveUser(Optional<User> userOpt) {
        boolean isExist = userOpt.isPresent();
        if (isExist && !userOpt.get().isActive()) {
            log.info("deactivated user : {}", userOpt.get().getUserId());
            throw new UserServiceException(InternalStandardError.USER_DEACTIVATED);
        }

        return isExist;
    }


    private boolean isUserExist(String mobile,String email) {
        return repository.findByPhoneNumberOrEmailId(mobile,email).isPresent();
    }
}