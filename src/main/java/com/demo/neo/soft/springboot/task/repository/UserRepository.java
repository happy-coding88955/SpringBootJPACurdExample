package com.demo.neo.soft.springboot.task.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.neo.soft.springboot.task.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	 Optional<User> findByPhoneNumberOrEmailId(String mobile,String email);

	Optional<User> findById(String userId);

	Optional<User> findByPhoneNumberOrEmailId(String email);
}
