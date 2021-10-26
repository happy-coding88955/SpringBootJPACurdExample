package com.demo.neo.soft.springboot.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.neo.soft.springboot.task.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{

}
